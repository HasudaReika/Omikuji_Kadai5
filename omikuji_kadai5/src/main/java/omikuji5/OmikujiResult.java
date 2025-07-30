package omikuji5;

/**
 * おみくじの結果を取得
 */
import java.time.LocalDate;

public class OmikujiResult {

	private LocalDate birthday;
	private LocalDate fortuneTellingDate;
	private String fortuneName;
	private String negaigoto;
	private String akinai;
	private String gakumon;

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDate getFortuneTellingDate() {
		return fortuneTellingDate;
	}

	public void setFortuneTellingDate(LocalDate fortuneTellingDate) {
		this.fortuneTellingDate = fortuneTellingDate;
	}

	public String getFortuneName() {
		return fortuneName;
	}

	public void setFortuneName(String fortuneName) {
		this.fortuneName = fortuneName;
	}

	public String getNegaigoto() {
		return negaigoto;
	}

	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}

	public String getAkinai() {
		return akinai;
	}

	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}

	public String getGakumon() {
		return gakumon;
	}

	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

	//コンストラクタで値を取得
	public OmikujiResult(LocalDate fortuneTellingDate, String fortuneName, String negaigoto, String akinai,
			String gakumon) {
		this.fortuneTellingDate = fortuneTellingDate;
		this.fortuneName = fortuneName;
		this.negaigoto = negaigoto;
		this.akinai = akinai;
		this.gakumon = gakumon;

	}

}
