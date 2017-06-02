package cn.edu.zhku.jsj.haofeng.bean;

public class User_list {
	private String username;
	private String password;
	private String money;
	private String consignee;
	private String phone;
	private String address;
	private String shopName;
	public User_list() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_list(String username, String password, String money,
			String consignee, String phone, String address,String shopName) {
		super();
		this.username = username;
		this.password = password;
		this.money = money;
		this.consignee = consignee;
		this.phone = phone;
		this.address = address;
		this.shopName = shopName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
