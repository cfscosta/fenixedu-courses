<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
s${actionCreate}s
<spring:url var="formActionUrl" value="${actionCreate}"/>
<spring:url var="visitActionUrl" value="${actionVisit}"/>
${courses}
<c:forEach var="course" items="${courses}">
	<div>courseName: ${course.name} <a href="${visitActionUrl}/${course.externalId}">VISITAAAAAR </a></div>
</c:forEach>

<form:form modelAttribute="coursebean" role="form" method="post" action="${formActionUrl}" enctype="multipart/form-data">
	<input type="text" name="name">
	<button type="submit">SUBMIITZ</button>
</form:form>
<br>
Hello ${world}!
