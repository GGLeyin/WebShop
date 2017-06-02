package cn.edu.zhku.jsj.huangxin.user.service;

import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.user.dao.UserDao;

public class UserService {

	UserDao dao = new UserDao();

	public void register(User user) throws Exception {

		boolean result = dao.findUsername(user.getUsername());
		if(result){
			throw new UserExistException("�û��Ѵ��ڣ�");
		}else{
			boolean rs=dao.addUser(user.getUsername(),user.getPassword());
			if(!rs){
				throw new Exception("�޷����ע��");
			}
		}
	}

	public User login(String username, String password) {
		
		User user = null;
		user=dao.getUserByNameAndPw(username, password);
		return user;
	}

	public void updatepw(String username, String passwordnew) throws Exception {
		
		boolean rs = dao.update(username, "password", passwordnew);
		if (!rs) {
			throw new Exception("�����޸ĳ���");
		}
	}

	public void updatePhone(String username, String phone) throws Exception {

		Boolean rs = dao.update(username, "phone", phone);
		if (!rs) {
			throw new Exception("�ֻ������޸ĳ���");
		}
	}

	public void updateConsignee(String username, String consignee)
			throws Exception {

		Boolean rs = dao.update(username, "consignee", consignee);
		if (!rs) {
			throw new Exception("�ջ����޸ĳ���");
		}
	}

	public void updateAddress(String username, String address) throws Exception {

		boolean rs = dao.update(username, "address", address);
		if (!rs) {
			throw new Exception("��ַ�޸ĳ���");
		}
	}
	public void updateMoney(String username,String money){
		dao.updateMoney(username, money);
	}
}
