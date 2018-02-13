package com.web.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.User;
import com.bo.Destination;
import com.service.TouristService;
import com.service.UserService;

@Results({ @Result(name = "login", location = "/public/LoginForm.jsp") })
public class LoginAction extends BaseAction implements SessionAware{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 9061182391863720650L;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TouristService touristService;
	private String userName;
	private String password;
	private Map<String,Object> session;
	
	private List<Destination> destinations;
	
	
	
	
	@Action(value="accueil", results = { @Result(name="success", type="redirectAction", location="execute") })
	public String getAceuil(){
		return SUCCESS;
	}
	
	@Action(value="getFormLogin" , results = { @Result(name = "success", location = "/public/LoginForm.jsp") })
	public String getFormLogin() { return SUCCESS;}
	
	
	@Action(value="/" , results = { @Result(name = "public", location = "/public/accueil.jsp") 
	,@Result(name="successAdmin",location="/private/admin/homeAdmin.jsp"),
	@Result(name="successUser",location="/private/user/homeUser.jsp")})
public String execute() {
		destinations=touristService.getAllDestinations();
			User user = (User) session.get("user");

			if (user != null && user.getRole() != null && "ROLE_ADMIN".equals(user.getRole().getRoleName())) {
					return "successAdmin";

}
// Si user
			else if (user != null && user.getRole() != null && "ROLE_USER".equals(user.getRole().getRoleName())) {

					return "successUser";

}

// Si role inconnu
				return "public";
}
	
	@Action(value="Login",results = { @Result(name = "success", type = "redirectAction", location = "/"),
			@Result(name = "input", location = "/public/LoginForm.jsp") })
	public String Login(){
		
		if(userName.isEmpty()||password.isEmpty()){
			addFieldError("Invalid", "userName and Password are required");
			return INPUT;
		}
		User user=userService.findUser(userName);
		if (user != null && password.equals(user.getPassword())) {
			session.put("user", user);
			return SUCCESS;
		} else {
			addFieldError("Invalid", "Invalid userName or password");
			return INPUT;
		}
	}

	@Action(value="logout")
	public String logout(){
		session.remove("user");
		return LOGIN;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public TouristService getTouristService() {
		return touristService;
	}

	public void setTouristService(TouristService touristService) {
		this.touristService = touristService;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	
	
}

