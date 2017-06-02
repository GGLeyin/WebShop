package cn.edu.zhku.jsj.haofeng.bean;

public class Cart {
	private int cartID;
	private String username;
	private String shopName;
	private String goodsName;
	private String price;
	private String quantity;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(int cartID, String username, String shopName, String goodsName,
			String price, String quantity) {
		super();
		this.cartID = cartID;
		this.username = username;
		this.shopName = shopName;
		this.goodsName = goodsName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
