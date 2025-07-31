package omikuji5;

/*
 * 過去半年と本日の運勢の割合を表示
 */
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class StatsAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		OmikujiDB omikujiDB = new OmikujiDB();
		Map<String, Integer> resultPastSixMonths = null;
		Map<String, Integer> resultToday = null;

		//過去半年と本日の運勢の割合のマップを取得
		resultPastSixMonths = omikujiDB.getUnseiPastSixMonths();
		resultToday = omikujiDB.getUnseiToday();

		//過去半年の格運勢の個数を取得
		double total = resultPastSixMonths.values().stream().mapToDouble(Integer::doubleValue).sum();
		//それぞれの割合を計算し、新しいマップに格納
		Map<String, Double> ratioPSM = resultPastSixMonths.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() / total) * 100));

		//本日の格運勢の個数を取得
		double total2 = resultToday.values().stream().mapToDouble(Integer::doubleValue).sum();
		//それぞれの割合を計算し、新しいマップに格納
		Map<String, Double> ratioToday = resultToday.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() / total2) * 100));

		//リクエストスコープにマップをセット
		request.setAttribute("resultPastSixMonths", ratioPSM);
		request.setAttribute("resultToday", ratioToday);

		return mapping.findForward("success");

	}

}
