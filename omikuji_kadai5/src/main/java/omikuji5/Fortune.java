package omikuji5;

import java.util.ResourceBundle;

public interface Fortune {

	String disp();

	String DISP_STR = ResourceBundle.getBundle("omikuji5.fortune").getString("DISP_STR");

}
