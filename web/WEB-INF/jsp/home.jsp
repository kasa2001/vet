<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="shared/head.jsp">
    <jsp:param name="pageName" value="Weterynarz"/>
</jsp:include>
<body class="card">
<c:if test="${user.userType.id == 1}">
    <jsp:include page="shared/header-user.jsp">
        <jsp:param name="pageName" value="home"/>
    </jsp:include>
</c:if>

<c:if test="${user.userType.id == 2}">
    <jsp:include page="shared/header-admin.jsp">
        <jsp:param name="pageName" value="home"/>
    </jsp:include>
</c:if>

<c:if test="${user == null}">
    <jsp:include page="shared/header.jsp">
        <jsp:param name="pageName" value="home"/>
    </jsp:include>
</c:if>

<section class="container">
    <div class="mt-3 mb-3">
        <main id="main" class="card-body bg-light radius">
            <h1 class="text-center" >Zwierzaki to nasza pasja!!!</h1>
            <div class="row">
                <div class="col-12">
                    <img class="image" src="https://ocdn.eu/pulscms-transforms/1/l3YktkpTURBXy81NGUzMjMzMjU3MjE3YmJhMDVkYzVjNTFkY2IxNzQ2ZS5qcGeRkwIAzQHk">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <img class="image" src="https://ocdn.eu/pulscms-transforms/1/l3YktkpTURBXy81NGUzMjMzMjU3MjE3YmJhMDVkYzVjNTFkY2IxNzQ2ZS5qcGeRkwIAzQHk">
                </div>
            </div>
        </main>
    </div>
</section>
<jsp:include page="shared/footer.jsp"/>
</body>
</html>