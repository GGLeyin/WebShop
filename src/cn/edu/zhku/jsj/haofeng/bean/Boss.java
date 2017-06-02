package cn.edu.zhku.jsj.haofeng.bean;

public class Boss {
	private int id;
	private String bossName;
	private String bossPwd;
	
	public Boss(){}
	public Boss(int id, String bossName, String bossPwd) {
		this.id = id;
		this.bossName = bossName;
		this.bossPwd = bossPwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBossName() {
		return bossName;
	}
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	public String getBossPwd() {
		return bossPwd;
	}
	public void setBossPwd(String bossPwd) {
		this.bossPwd = bossPwd;
	}
	
}
