package cn.edu.zhku.jsj.haofeng.bean;

public class Orders2 {
	private int id;
	private String userName;
	private String userAddress;
	private String userDrom;
	private String userPhoneNumber;
	private String goodsName;
	private String goodsTypeName;
	private int goodsNumber;
	private String price;
	private int ifBuy;//是否购买
	private int ifDispose;//是否受理
	
	public Orders2() {}

	public Orders2(int id, String userName, String userAddress, String userDrom,
			String userPhoneNumber, String goodsName, String goodsTypeName,
			int goodsNumber, String price,int ifBuy, int ifDispose) 
	{
		this.id = id;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userDrom = userDrom;
		this.userPhoneNumber = userPhoneNumber;
		this.goodsName = goodsName;
		this.goodsTypeName = goodsTypeName;
		this.goodsNumber = goodsNumber;
		this.price = price;
		this.ifBuy = ifBuy;
		this.ifDispose = ifDispose;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDrom() {
		return userDrom;
	}

	public void setUserDrom(String userDrom) {
		this.userDrom = userDrom;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public int getIfBuy() {
		return ifBuy;
	}

	public void setIfBuy(int ifBuy) {
		this.ifBuy = ifBuy;
	}

	public int getIfDispose() {
		return ifDispose;
	}

	public void setIfDispose(int ifDispose) {
		this.ifDispose = ifDispose;
	}

}
