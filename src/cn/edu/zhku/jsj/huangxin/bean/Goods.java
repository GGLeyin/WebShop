package cn.edu.zhku.jsj.huangxin.bean;

public class Goods {

	private int goodsID;		//商品编号
	private String goodsName;	//商品名
	private String price;		//商品单价
	private String type;		//商品类型
	private String shopName;	//商品所属店铺名字
	private String inventory;	//库存
	private String sales;		//销量
	private String imagePath;	//商品图片
	public Goods(){}
	public Goods(int goodsID, String goodsName, String price, String type,
			String shopID, String inventory,String imagePath) {
		super();
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.price = price;
		this.type = type;
		this.shopName = shopID;
		this.inventory = inventory;
		this.sales ="0";
		this.imagePath = imagePath;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
}
