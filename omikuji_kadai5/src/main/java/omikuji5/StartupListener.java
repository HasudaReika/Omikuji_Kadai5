package omikuji5;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

	//起動時に一度だけ実行する処理
	@Override
	public void contextInitialized(ServletContextEvent sce) {

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
	}

	//アプリケーション終了時に実行する処理
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("終了します");
	}

}
