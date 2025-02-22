<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>${home}</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="/pages/partials/navigation.jsp"/>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Country Name</th>
                <th scope="col">Continent</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${country.name}</td>
                <td>${country.continent}</td>
                <td>
                    <a href="${path}/update?countryId=<c:out value='${country.countryId}'/>">Edit</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="${path}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>
