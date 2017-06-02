package cn.edu.zhku.jsj.haofeng.bean;

public class Goods {
	private int goodsID;
	private String goodsName;
	private String price;
	private String shopName;
	private String inventory;
	private String sales;
	private String imagePath;
	private String type;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(int goodsID, String goodsName, String price, String shopName,
			String inventory, String sales, String imagePath, String type) {
		super();
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.price = price;
		this.shopName = shopName;
		this.inventory = inventory;
		this.sales = sales;
		this.imagePath = imagePath;
		this.type = type;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
