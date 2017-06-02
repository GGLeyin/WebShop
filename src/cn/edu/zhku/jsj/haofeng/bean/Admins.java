package cn.edu.zhku.jsj.haofeng.bean;

public class Admins {
	private int id;
	private String adminName;
	private String adminPwd;
	private int adminAge;
	private String adminGender;
	private String adminAddress;
	private String adminPhone;

	public Admins() {}
	public Admins(int id, String adminName, String adminPwd, int adminAge,
			String adminGender, String adminAddress, String adminPhone) {
		this.id = id;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminAddress = adminAddress;
		this.adminPhone = adminPhone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getAdminAge() {
		return adminAge;
	}
	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}
	public String getAdminGender() {
		return adminGender;
	}
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	
}
