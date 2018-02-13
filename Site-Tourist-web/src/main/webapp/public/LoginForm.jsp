<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<jsp:include page="inc/header.jsp" flush="true" />
<jsp:include page="inc/menu.jsp" flush="true" />

<div >
	  <div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				
				<s:form theme="bootstrap" cssClass="well form-vertical" action="Login" method="post" >
				
				<div>Login</div>
				<div class="alert-danger"><s:fielderror name="Invalid"/></div>
				<s:textfield
				            placeholder="Username"
				            name="userName" required="true"/>
				    
				<s:password
				            placeholder="Password"
				            name="password" required="true"/>
				            
				    <s:submit cssClass="btn btn-primary" value="Login"/>
				</s:form>
				
				
			</div>
		</div>
	</div>
    <!-- end of column four -->
  </div>
  


 <jsp:include page="inc/footer.jsp" />