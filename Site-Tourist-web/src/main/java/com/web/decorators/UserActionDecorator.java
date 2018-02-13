package com.web.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bo.User;

public class UserActionDecorator extends TableDecorator {

	private String deleteUserLink;
	private String bloquerUserLink;

	public String getDeleteUserLink() {

		User user = (User) getCurrentRowObject();
		String username = user.getUserName();

		this.deleteUserLink = "<a href=\"deleteUser?username=" + username
				+ "\">Supprimer</a>";

		return this.deleteUserLink;
	}
	

	

}