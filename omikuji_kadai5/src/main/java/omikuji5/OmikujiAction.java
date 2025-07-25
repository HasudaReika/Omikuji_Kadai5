package omikuji5;

import java.sql.SQLException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class OmikujiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		OmikujiDB omikujiDB = new OmikujiDB();
		//DBにおみくじが格納されているかチェック
		try {
			if (omikujiDB.checkDB()) { //DBにおみくじが格納されていない場合
				//おみくじをDBに格納する
				omikujiDB.importOmikujiFromCsv();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		//アクションフォームから誕生日を受け取る
		BirthdayActionForm birthdayActionForm = (BirthdayActionForm) form;
		String birthday = birthdayActionForm.getBirthday();

		//--------おみくじを取得する---------

		//今日の日時を取得
		LocalDate today = LocalDate.now();
		//birthdayをLocalDate型に変換
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		//誕生日文字列を半角に変換
		String birthdayString = Normalizer.normalize(birthday, Form.NFKC);
		LocalDate bdDate = LocalDate.parse(birthdayString, formatter);

		//resultテーブルから取得するおみくじ変数
		Omikuji omikuji = null;
		//ランダムに新しいおみくじを取得する変数
		Omikuji newOmikuji = null;

		//resultテーブルに占った日と誕生日が一致する結果が存在するかチェック、あればおみくじを取得
		try {
			omikuji = omikujiDB.getOmikujiFromResult(today, bdDate);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (omikuji != null) { //該当するおみくじがある場合
			//DBからおみくじを取得しリクエストスコープにセット
			request.setAttribute("omikuji", omikuji);
			//コンソールに出力用
			System.out.println(omikuji.disp());

		} else {
			//なければDBからおみくじをランダムに1つ取得
			try {
				newOmikuji = omikujiDB.getRandomOmikuji();
				//リクエストスコープに値をセット
				request.setAttribute("omikuji", newOmikuji);
				//コンソールに出力用
				System.out.println(newOmikuji.disp());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			//---------結果をDBに登録----------
			try {
				omikujiDB.saveResult(bdDate, newOmikuji);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

		//処理結果をJSPに転送
		return mapping.findForward("result");

	}

}
