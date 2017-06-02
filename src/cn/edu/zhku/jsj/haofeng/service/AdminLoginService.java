package cn.edu.zhku.jsj.haofeng.service;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.bean.Boss;

public interface AdminLoginService {

	Boss getBoss(String username, String password);

	Admins getAdmins(String username, String password);

	int update(String pwd, int id);

	int updateB(String pwd, int id);


}
