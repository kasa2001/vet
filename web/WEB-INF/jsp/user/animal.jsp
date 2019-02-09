<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="../shared/head.jsp">
    <jsp:param name="pageName" value="Weterynarz"/>
</jsp:include>
<body class="card">
<jsp:include page="../shared/header-user.jsp">
    <jsp:param name="pageName" value="animal"/>
</jsp:include>
<section class="container">
    <div class="mt-3 mb-3">
        <main id="main" class="card-body bg-light radius">
            <h1 class="text-center" >Lista zwierzątek</h1>
            <div class="row">
                <c:forEach var="simple" items="${animal}" >
                    <div class="col-3">
                        Id <c:out value = "${simple.id}"/>
                    </div>
                    <div class="col-3">
                        Imię: <c:out value = "${simple.name}"/>
                    </div>
                    <div class="col-3">
                        Typ: <c:out value = "${simple.animalType.name}"/>
                    </div>
                    <div class="col-3">
                        <a href="/user/animal/${simple.id}">Zobacz badania zwierzątka</a>
                    </div>
                </c:forEach>
            </div>
        </main>
    </div>
</section>
<jsp:include page="../shared/footer.jsp"/>
</body>
</html>