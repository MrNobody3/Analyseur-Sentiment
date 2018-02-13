package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Role;
import com.bo.User;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.genericdao.common.EntityNotFoundException;
import com.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Override
	public void addUser(User user) {
		userDao.create(user);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return userDao.getAll();
	}

	@Override
	public User findUser(String userName) throws EntityNotFoundException {
		if(userDao.findById(userName)!=null)
			return userDao.findById(userName);
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Role finRolebyRolename(String roleName) {
		return roleDao.getRoleByname(roleName);
	}
	public Role getRoleById(Long pRoleId){
		return roleDao.findById(pRoleId);
		}
	public List<Role> getAllRoles() {
		return roleDao.getAll();
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void removeUser(String username) {
		userDao.delete(username);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);		
	}
	

}
