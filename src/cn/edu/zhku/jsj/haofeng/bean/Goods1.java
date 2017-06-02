package cn.edu.zhku.jsj.haofeng.bean;

public class Goods1 {
	private int id;
	private String goodsName;
	private String goodsTypeName;//类型名称
	private int goodsNumber;//商品数量
	private String goodsPrice;
	private String goodsIntroduce;//介绍
	private String bigPricture;//大图
	private String smallPricture1;//小图1
	private String smallPricture2;//小图2
	private String smallPricture3;//小图3
	private String aPath;//超链接路径
	private String productionPeople;//生产商
	private String productionTime;//生产日期
	private String shelfLife;//保质期
	
	public Goods1(){}
	public String getProductionPeople() {
		return productionPeople;
	}
	public void setProductionPeople(String productionPeople) {
		this.productionPeople = productionPeople;
	}
	public String getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public Goods1(int id, String goodsName, String goodsTypeName,
			int goodsNumber, String goodsPrice, String goodsIntroduce,
			String bigPricture, String smallPricture1, String smallPricture2,
			String smallPricture3, String aPath, String productionPeople,
			String productionTime, String shelfLife) {
		this.id = id;
		this.goodsName = goodsName;
		this.goodsTypeName = goodsTypeName;
		this.goodsNumber = goodsNumber;
		this.goodsPrice = goodsPrice;
		this.goodsIntroduce = goodsIntroduce;
		this.bigPricture = bigPricture;
		this.smallPricture1 = smallPricture1;
		this.smallPricture2 = smallPricture2;
		this.smallPricture3 = smallPricture3;
		this.aPath = aPath;
		this.productionPeople = productionPeople;
		this.productionTime = productionTime;
		this.shelfLife = shelfLife;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}
	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}
	public String getBigPricture() {
		return bigPricture;
	}
	public void setBigPricture(String bigPricture) {
		this.bigPricture = bigPricture;
	}
	public String getSmallPricture1() {
		return smallPricture1;
	}
	public void setSmallPricture1(String smallPricture1) {
		this.smallPricture1 = smallPricture1;
	}
	public String getSmallPricture2() {
		return smallPricture2;
	}
	public void setSmallPricture2(String smallPricture2) {
		this.smallPricture2 = smallPricture2;
	}
	public String getSmallPricture3() {
		return smallPricture3;
	}
	public void setSmallPricture3(String smallPricture3) {
		this.smallPricture3 = smallPricture3;
	}
	public String getaPath() {
		return aPath;
	}
	public void setaPath(String aPath) {
		this.aPath = aPath;
	}
	
}
