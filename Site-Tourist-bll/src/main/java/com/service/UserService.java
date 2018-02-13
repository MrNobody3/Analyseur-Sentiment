package com.service;

import com.bo.Role;
import com.bo.User;
import com.genericdao.common.EntityNotFoundException;

import java.util.List;

public interface UserService {
	public void addUser(User user);
	public List<User> getAllUser();
	public User findUser(String userName)throws EntityNotFoundException;
	public Role finRolebyRolename(String roleName);
	public Role getRoleById(Long pRoleId);
	public List<Role> getAllRoles();
	public void removeUser(String username);
	public void updateUser(User user);
	
}
