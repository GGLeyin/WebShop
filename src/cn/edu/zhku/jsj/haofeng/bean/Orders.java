package cn.edu.zhku.jsj.haofeng.bean;

public class Orders {
	private int orderID;
	private String username;
	private String shopName;
	private String goodsName;
	private String quantity;
	private String price;
	private String consignee;
	private String phone;
	private String address;
	private String state;
	private String time;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int orderID, String username, String shopName,
			String goodsName, String quantity, String price, String consignee,
			String phone, String address, String state, String time) {
		super();
		this.orderID = orderID;
		this.username = username;
		this.shopName = shopName;
		this.goodsName = goodsName;
		this.quantity = quantity;
		this.price = price;
		this.consignee = consignee;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.time = time;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
