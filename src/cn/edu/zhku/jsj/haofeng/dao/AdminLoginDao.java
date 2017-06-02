package cn.edu.zhku.jsj.haofeng.dao;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.bean.Boss;

public interface AdminLoginDao {

	Boss getBoss(String username, String password);

	Admins getAdmins(String username, String password);

	int update(String pwd, int id);

	int updateB(String pwd, int id);


}
