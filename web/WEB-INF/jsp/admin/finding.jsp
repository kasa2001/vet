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
<jsp:include page="../shared/header-admin.jsp">
    <jsp:param name="pageName" value="visit"/>
</jsp:include>
<section class="container">
    <div class="mt-3 mb-3">
        <main id="main" class="card-body bg-light radius">
            <h1 class="text-center" >Dodaj diagnozę :)</h1>
            <form:form modelAttribute="finding">
                <div class="form-group">
                    <label for="diagnose" class="bmd-label-floating">Diagnoza:</label>
                    <form:input path="diagnose" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                    <form:errors path="diagnose" cssClass="error text-danger" element="div"/>
                </div>
                <button type="submit" class="btn btn-primary btn-raised">Załóż konto</button>
            </form:form>
        </main>
    </div>
</section>
<jsp:include page="../shared/footer.jsp"/>
</body>
</html>