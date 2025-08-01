package omikuji5;

import org.apache.struts.validator.ValidatorForm;

public class OmikujiForm extends ValidatorForm {

	private String birthday;

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
//	@Override
//	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//		String hwBirthday = Normalizer.normalize(birthday, Form.NFKC);
//		this.birthday = hwBirthday;
//		
//		ActionErrors errors = super.validate(mapping, request);
//		return errors;
//		
//	}

}
