package omikuji5;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/*
 * 入力された誕生日の過去半年の結果をリスト化
 */
public class ListAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		OmikujiDB omikujiDB = new OmikujiDB();

		//アクションフォームから誕生日を受け取る
		OmikujiForm birthdayActionForm = (OmikujiForm) form;
		String birthday = birthdayActionForm.getBirthday();

		//String型からLocalDate型に変換
		LocalDate bdDate = LocalDate.parse(birthday);
		//過去半年の結果を取得
		omikujiDB.getResultPastSixMonths(bdDate);
		
		

		return null;

	}

}
