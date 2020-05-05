package lab.spboot.hateoas.model;

import org.springframework.hateoas.RepresentationModel;


public class Antricicclagio extends RepresentationModel<Antricicclagio>{
	
	private String input1;
	private String input2;

	private String input3;

	public String getInput3() {
		return input3;
	}
	public void setInput3(String input3) {
		this.input3 = input3;
	}
	public String getInput1() {
		return input1;
	}
	public void setInput1(String input1) {
		this.input1 = input1;
	}
	public String getInput2() {
		return input2;
	}
	public void setInput2(String input2) {
		this.input2 = input2;
	}
	

}
