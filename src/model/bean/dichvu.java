package model.bean;

public class dichvu {
	private String madichvu, tendichvu;

	public dichvu() {
		super();
	}

	public dichvu(String madichvu, String tendichvu) {
		super();
		this.madichvu = madichvu;
		this.tendichvu = tendichvu;
	}

	public String getMadichvu() {
		return madichvu;
	}

	public void setMadichvu(String madichvu) {
		this.madichvu = madichvu;
	}

	public String getTendichvu() {
		return tendichvu;
	}

	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}
}
