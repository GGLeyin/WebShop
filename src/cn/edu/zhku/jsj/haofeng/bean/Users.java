package cn.edu.zhku.jsj.haofeng.bean;

public class Users {
	private int id;
	private String userName;
	private String userPwd;
	private String userAddress;
	private String userDrom;
	private String userPhoneNumber;
	
	public Users(){}
	public Users(int id, String userName, String userPwd, String userAddress,
			String userDrom, String userPhoneNumber) {
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAddress = userAddress;
		this.userDrom = userDrom;
		this.userPhoneNumber = userPhoneNumber;
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
	
}
