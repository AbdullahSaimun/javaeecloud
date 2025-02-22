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

  <div class="col-12">
    <form action="${path}/" method="get" class="col-4" style="margin-top: 5px">
      <div class="input-group">
        <input type="text" name="search" placeholder="Search by country name or continent"
               value="${search}"
               class="form-control"/>
        <button type="submit" class="btn btn-primary">Search</button>
      </div>
    </form>
  </div>

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
      <c:forEach var="country" items="${countries}">
        <tr>
          <td>${country.name}</td>
          <td>${country.continent}</td>
          <td>
            <a href="${path}/details?countryId=<c:out value='${country.countryId}'/>">Details</a>
            <a href="${path}/update?countryId=<c:out value='${country.countryId}'/>">Update</a>
            <a href="${path}/delete?countryId=<c:out value='${country.countryId}'/>">Delete</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <nav aria-label="Page navigation example">
      <ul class="pagination">

        <c:if test="${currentPage > 1}">
          <li class="page-item">
            <a class="page-link" href="${path}/?page=${currentPage - 1}">Previous</a>
          </li>
        </c:if>

        <c:forEach var="i" begin="1" end="${totalPages}">
          <li class="page-item $(i eq currentPage ? 'active': '' ">
            <a class="page-link" href="${path}/?page=${i}">${i}</a>
          </li>
        </c:forEach>

        <c:if test="${currentPage < totalPages}">
          <li class="page-item">
            <a class="page-link" href="${path}/?page=${currentPage +1}">Next</a>
          </li>
        </c:if>
      </ul>
    </nav>
  </div>
</div>
<script src="${path}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>
