package cn.edu.zhku.jsj.haofeng.bean;

public class Shops {
	private String shopName;
	private String description;
	private String buildTime;
	private String username;
	public Shops() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shops(String shopName, String description, String buildTime,
			String username) {
		super();
		this.shopName = shopName;
		this.description = description;
		this.buildTime = buildTime;
		this.username = username;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
