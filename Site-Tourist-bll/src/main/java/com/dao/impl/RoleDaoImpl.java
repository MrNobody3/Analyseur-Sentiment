package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.bo.Role;
import com.dao.RoleDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;


@Repository
public class RoleDaoImpl extends HibernateSpringGenericDaoImpl<Role, Long> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
	}

	@Override
	public Role getRoleByname(String roleName) {
		java.util.List<Role> roles =   getEntityByColValue("Role",  "roleName", roleName);
		return roles.get(0);
	}

}
