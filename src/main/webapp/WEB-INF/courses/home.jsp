<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="formActionUrl" value="${action}"/>


<c:forEach var="page" items="${pages}">
	<div>PageName: ${page.name}</div>
</c:forEach>

<form:form modelAttribute="coursebean" role="form" method="post" action="${formActionUrl}" enctype="multipart/form-data">
	<input type="text" name="name">
	<button type="submit">SUBMIITZ</button>
</form:form>
<br>
Hello ${world}!
