<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<jsp:include page="inc/header.jsp" flush="true" />
<jsp:include page="inc/menu.jsp" flush="true" />

<div >

    <div class="container">
        <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                        <h3><s:property value="destination.nom"/><h3>
                        <p>Note de : <s:property value="destination.note"/><br/><p>
                </div>
        </div>
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                    <img src="<s:property value='destination.photo'/>" style="height: 200px; float : right"/>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent mi dui, vestibulum at pharetra non, condimentum vel mauris. Nam feugiat finibus luctus. Nam at nibh urna. Vestibulum ultricies diam euismod odio hendrerit, ac facilisis ipsum ultrices. Etiam blandit eu ex id iaculis. Etiam efficitur in massa ac rhoncus. Vivamus diam libero, commodo vel dictum nec, ultrices sed ex. Suspendisse at pharetra nisi, eu viverra augue. Nunc pharetra, magna nec imperdiet aliquam, sapien augue ultrices sapien, a venenatis lacus erat placerat purus. Cras dignissim enim arcu, sit amet tempor nunc pellentesque a. Fusce nec libero venenatis augue varius ornare. Donec mi risus, accumsan sit amet tincidunt quis, aliquet eu justo. Aenean porttitor sollicitudin felis sed molestie. Pellentesque convallis, turpis vitae varius consectetur, odio mauris varius ex, a suscipit augue risus eu leo.</p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <h4>Les commentaires</h4>
                <s:iterator  var="commentaire" step="1" value="destination.commentaires">

                    <div class="alert alert-success">
						<strong><s:property value="user.userName"/></strong> <s:property value="text"/>
					</div>

                </s:iterator>
            </div>
        </div>
        

    </div>


</div>

<jsp:include page="inc/footer.jsp" />