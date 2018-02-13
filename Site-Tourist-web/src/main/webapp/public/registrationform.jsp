<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<jsp:include page="inc/header.jsp" flush="true" />
<jsp:include page="inc/menu.jsp" flush="true" />


<div >
	  <div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				
				<s:form theme="bootstrap" cssClass="well form-vertical" action="addUser" method="post" >
				    
				    <div >Registration</div>
				    <div class="alert-danger"><s:property value="error"/></div>
					<s:textfield
				            placeholder="Username"
				            name="user.userName" required="true"/>
				    
				    <s:password
				            placeholder="Password"
				            name="user.password" required="true"/>
				         
				    <s:password
				            placeholder="Confirm password"
				            name="user.passwordConfirmation" required="true"/>     
				                    
				    <sj:datepicker name="user.dateNaissance" 
								displayFormat="dd/mm/y" label="Date de Naissance" />
				    
				    <s:textfield label="email *" name="user.email" />
				
				    <s:submit cssClass="btn btn-primary" value="Registre"/>
				    
				</s:form>
				
				
			</div>
		</div>
	</div>
    <!-- end of column four -->
  </div>



 <jsp:include page="inc/footer.jsp" />