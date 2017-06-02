package cn.edu.zhku.jsj.huangxin.bean;

public class Orders {
	
	private int ordersID;		//�������
	private String username;	//�����û�
	private String shopName;	//��������
	private String goodsName;	//��Ʒ��
	private String quantity;	//��Ʒ����
	private String price;		//��Ʒ�۸�
	private String consignee;	//�ջ���
	private String phone;		//�ջ����ֻ���
	private String address;		//�ջ���ַ
	private String state;		//����״̬
	private String time;		//�µ�ʱ��
	public Orders() {
		super();
	}
	public Orders(String username, String shopName, String goodsName,
			String quantity, String price, String consignee, String phone,
			String address, String time) {
		super();
		this.username = username;
		this.shopName = shopName;
		this.goodsName = goodsName;
		this.quantity = quantity;
		this.price = price;
		this.consignee = consignee;
		this.phone = phone;
		this.address = address;
		this.state="���ջ�";
		this.time = time;
	}

	public int getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
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
