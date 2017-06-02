package cn.edu.zhku.jsj.haofeng.service;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.User_list;

public interface AdminUsersService {

	int RowCount();

	List<User_list> getAll(String name,int pageSize, int pageNo);

	int delete(String username);

}
