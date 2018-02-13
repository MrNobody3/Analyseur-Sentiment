package com.web.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Commentaire;
import com.bo.Destination;
import com.bo.Role;
import com.bo.User;
import com.genericdao.common.EntityNotFoundException;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.service.TouristService;
import com.service.UserService;

public class UserAction extends BaseAction {

	/**
	 * 
	 */

	private User user;

	private List<User> listUser;

	@Autowired
	private UserService userService;
	private Long selectedRole;
	@Autowired
	private TouristService touristService;
	private List<Role> listRoles;
	private String error;
	private Commentaire userComment;
	private String[] badWord={"fuck","bitch"};
	private Destination destination;
	private Long idDestination;
	
	//*************Méthode d'administrateur*****************
	@Action(value = "initFormAddUser", results = {
			@Result(name = "success", location = "/private/admin/registrationFormByAdmin.jsp") })
	
	public String initFormAddUser() {
		//il est Obligatoire de récupérer la lsit des roles avant de l'affiche la formulaire d'iscription
		listRoles = userService.getAllRoles();
		return SUCCESS;
	}

	@Action(value = "addUserbyAmin", results = { @Result(name = "success",type="redirectAction",  location = "listUser"),
			@Result(name = "error", location = "/private/admin/eroor.jsp"), 
			@Result(name="input",location = "/private/admin/registrationFormByAdmin.jsp")})
	public String addUserbyAdmin() {
		
		listRoles = userService.getAllRoles();
		
		if(getSelectedRole()==-1){
			error = "Role invalide";
			return "input";
		}
		try {
		  

			user.setRole(userService.getRoleById(selectedRole));
			userService.addUser(user);

		} catch (Exception ex) {
			System.out.println("Error:"+ex.getMessage());
			error= "Username exist";
			return "input";
			

		}

		addActionMessage("Utilisateur ajouté avec succès");

		return SUCCESS;

	}
	@Action(value = "listUser", results = { @Result(name = "success", location = "/private/admin/listUser.jsp") })
	public String listUser() {

		listUser = userService.getAllUser();
		System.out.println("UserName:"+listUser.get(0).getUserName()+"Password:"+listUser.get(0).getPassword());

		// On retoune la page associ�e � success
		return SUCCESS;

	}
	
	@Action(value = "deleteUser", results = { @Result(name = "success",type="redirectAction", location = "listUser") })
	public String supprimerPersonne()
	{
		String username = getRequest().getParameter("username");
		System.out.println(username);
		
			try {
				userService.removeUser(username);
				return "success";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Delete NumberFormatException exeption catch");
				return "input";
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Delete EntityNotFoundException exeption catch");
				return "input";
			}
		
		
		
	}
	//****************************Fin****************************
	
	//************Méthode d'utilisateur*******************************

	@Action(value="getForm",results={@Result(name="success",location="/public/registrationform.jsp")})
	public String getForm(){
		return SUCCESS;
	}
	
	@Action(value = "addUser", results = {
			@Result(name = "success", location="/public/LoginForm.jsp"),
			@Result(name = "input", location = "/public/registrationform.jsp")})
	public String addUser() {
		if(!user.getPassword().equals(user.getPasswordConfirmation())){
			error="password doesn't match confirm password";
		}else {
			if(userService.findUser(user.getUserName()) != null){
				error="Username exist";
			}
			else{
				Role r=userService.finRolebyRolename("ROLE_USER");
				user.setRole(r);
				userService.addUser(user);
		       	// On retoune la page associ�e � success
				return SUCCESS;
			}
		}
		return INPUT;
	}

	
	
	@Action(value = "/showDestination", results = { @Result(name = "public", location = "/public/destination.jsp")
													,@Result(name = "private", location = "/private/user/destination.jsp")
	})
	public String showDestination() {

		// On récupère l'id de la destination
//		if(getSession().getAttribute("idDestination")==null)
			getSession().setAttribute("idDestination", Long.valueOf(getRequest().getParameter("idDestination")));

		destination = touristService.getDestinationById(Long.valueOf(getRequest().getParameter("idDestination")));
		User  user= (User) getSession().getAttribute("user");
		if(user!=null)
			return "private";
		else
			return "public";
		
	}
	
	
	@Action(value = "/addComment", results = {
			@Result(name = "success",location = "/private/user/destination.jsp"),
			@Result(name="error",location="/public/error.jsp")

	})
	public String addComment() {

		for(int i=0;i<badWord.length;i++){
			if(userComment.getText().contains(badWord[i])){
				return "error";
			}
				
		}
		Long id = (Long) getSession().getAttribute("idDestination");
		User  user= (User) getSession().getAttribute("user");
		// TODO : si destination est introuvable
		destination = touristService.getDestinationById(id);
		
		userComment.setUser(user);
		destination.addCommentaire(userComment);
		
		
		 
		 touristService.updateDestination(destination);

		return SUCCESS;

	}
//********************************Fiin*******************************

	public TouristService getTouristService() {
		return touristService;
	}

	public void setTouristService(TouristService touristService) {
		this.touristService = touristService;
	}

	public Commentaire getUserComment() {
		return userComment;
	}

	public void setUserComment(Commentaire userComment) {
		this.userComment = userComment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getListUser() {
		return listUser;
	}
	public void setUserList(List<User> listUser) {
		this.listUser = listUser;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Long getSelectedRole() {
		return selectedRole;
	}
	public void setSelectedRole(Long selectedRole) {
		this.selectedRole = selectedRole;
	}
	public List<Role> getListRoles() {
		return listRoles;
	}
	public void setListRoles(List<Role> listRoles) {
		this.listRoles = listRoles;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Long getIdDestination() {
		return idDestination;
	}

	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	

}
