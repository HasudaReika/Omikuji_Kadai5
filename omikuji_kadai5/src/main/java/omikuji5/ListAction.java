package omikuji5;

import java.sql.SQLException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
public class ListAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		OmikujiDB omikujiDB = new OmikujiDB();
		List<OmikujiResult> results = null;

		//アクションフォーム
		OmikujiForm birthdayActionForm = (OmikujiForm) form;
		//誕生日文字列を受け取る
		String birthday = birthdayActionForm.getBirthday();

		//birthdayをLocalDate型に変換
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		//変換後の今日の日付
		LocalDate bdDate = null;

		//誕生日文字列を半角に変換
		String birthdayString = Normalizer.normalize(birthday, Form.NFKC);
		try {
			bdDate = LocalDate.parse(birthdayString, formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}

		//過去半年の結果を取得		
		results = omikujiDB.getResultPastSixMonths(bdDate);
		//リクエストスコープにリストをセット
		request.setAttribute("results", results);
		//リクエストスコープに誕生日をセット
		request.setAttribute("birthday", bdDate);

		return mapping.findForward("success");

	}

}
