package lib;

public class Module {
	
	private String code;
	private String name;
	private int examWeight;
	private int cwkWeight;
	
	public Module() {
		this.code = "";
		this.name = "";
		this.examWeight = 0;
		this.cwkWeight = 0;
	}
	
	public Module(String code, String name) {
		this.code = code;
		this.name = name;
		this.examWeight = 0;
		this.cwkWeight = 0;
	}
	
	public Module(String code, String name, int examWeight, int cwkWeight) {
		this.code = code;
		this.name = name;
		this.examWeight = examWeight;
		this.cwkWeight = cwkWeight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setExamWeight(int examWeight) {
		this.examWeight = examWeight;
		this.cwkWeight = 100 - examWeight;
	}
	
	public int getExamWeight() {
		return examWeight;
	}
	
	public void setCwkWeight(int cwkWeight) {
		this.cwkWeight = cwkWeight;
		this.examWeight = 100 - cwkWeight;
	}
	
	public int getCwkWeight() {
		return cwkWeight;
	}
	
	public String toString() {
		return "Module:[code=" + code + ", name=" + name + ", examWeight=" + examWeight + ", cwkWeight=" + cwkWeight + "]";
	}
	
	

}
