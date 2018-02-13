<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../inc/header.jsp" flush="true" />
<jsp:include page="../inc/menuUser.jsp" flush="true" />

<h1>Espace User</h1>
<h3>Hello <s:property value="#session['user'].userName"/></h3>
<div >

    <div class="container">
        <div class="row">
            <s:iterator  var="destination" step="1" value="destinations">
                <div class="col-sm-3">
                    <s:property value="nom"/><br />
                    <s:a href="%{go}">
                    <img src="<s:property value='photo'/>" style="height: 200px; witdh :200px;"/>
					</s:a>

                        <s:url var="go" action="showDestination">
                                    <s:param name="idDestination"><s:property value="id"/></s:param>

                        </s:url>
                </div>

            </s:iterator>
        </div>
    </div>


</div>

 <jsp:include page="../inc/footer.jsp" />