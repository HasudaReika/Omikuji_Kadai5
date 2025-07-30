package omikuji5;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/*
 * 入力された誕生日の過去半年の結果をリスト化
 */
public class ListAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		OmikujiDB omikujiDB = new OmikujiDB();
		List<OmikujiResult> results = null;

		//誕生日文字列を受け取る
		String birthday = request.getParameter("birthday");

		//String型からLocalDate型に変換
		LocalDate bdDate = LocalDate.parse(birthday);
		//過去半年の結果を取得		
		results = omikujiDB.getResultPastSixMonths(bdDate);
		//リクエストスコープにリストをセット
		request.setAttribute("results", results);
		//リクエストスコープに誕生日をセット
		request.setAttribute("birthday", birthday);
		

		return mapping.findForward("success");

	}

}
