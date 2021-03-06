package cn.edu.zhku.jsj.haofeng.dao;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Admins;

public interface AdminEmployeeDao {

	List<Admins> getAll(String name);

	int insert(String name, String pwd, int age, String gender, String address,
			String phone);

	Admins getById(int id);

	int update(String name, int age, String gender, String address,
			String phone, int id);

	int deleteById(int id);

}
