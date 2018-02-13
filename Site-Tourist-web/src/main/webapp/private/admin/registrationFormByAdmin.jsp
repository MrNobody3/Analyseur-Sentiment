<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<jsp:include page="../inc/header.jsp" flush="true" />
<jsp:include page="../inc/menuAdmin.jsp" flush="true" />


<div >
	  <div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				
				<s:form theme="bootstrap" cssClass="well form-vertical" action="addUserbyAmin" method="post" >
				    
				    <div >Registration</div>
				    <div class="alert-danger"><s:property value="error"/></div>
				    
					<s:textfield
				            placeholder="Username"
				            name="user.userName" required="true"/>
				    
				    <s:password
				            placeholder="Password at least 8 caracteres"
				            name="user.password" required="true"/>   
				    
				    <s:select label="Selectionner un role"  headerKey="-1" listKey="id"
							listValue="roleName" headerValue="--- Select ---" list="listRoles"
								emptyOption="false" name="selectedRole" />
				                
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



 <jsp:include page="../inc/footer.jsp" />
