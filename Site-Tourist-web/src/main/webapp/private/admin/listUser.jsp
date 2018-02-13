<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<jsp:include page="../inc/header.jsp" flush="true" />
<jsp:include page="../inc/menuAdmin.jsp" flush="true" />

    <div >
	  
	<div class="container">
		
		<div class="row">
					
			
			
			<div class="col-sm-10 col-sm-offset-1">
			
				<h2>List users</h2>
				
				<d:table name="listUser" pagesize="10" export="true" decorator="com.web.decorators.UserActionDecorator" requestURI="/listUser" class="table">
					<d:column property="userName" title="UserName" sortable="true" />
					<d:column property="password" title="Password" sortable="true" />
					<d:column property="email" title="Email" />
					<d:column property="role.roleName" title="Role"/>
					<d:column property="deleteUserLink" title="Supprimer" />
				</d:table>
				
			</div>
		</div>
			
			
	</div>
	
	</div>
    
    <!-- end of column four -->
  </div>
  <jsp:include page="../inc/footer.jsp" />

