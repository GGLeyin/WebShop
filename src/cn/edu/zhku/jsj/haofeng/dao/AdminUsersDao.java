package cn.edu.zhku.jsj.haofeng.dao;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.User_list;

public interface AdminUsersDao {

	int RowCount();

	List<User_list> getAll(String name,int pageSize, int pageNo);

	int delete(String username);

}
