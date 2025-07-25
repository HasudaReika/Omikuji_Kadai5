package omikuji5;

import org.apache.struts.action.ActionForm;

public class BirthdayActionForm extends ActionForm {

	private String birthday;

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
