<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>${course.name}</h1>
<spring:url var="postActionUrl" value="${actionPost}"/>
<spring:url var="visitActionUrl" value="${actionVisit}"/>
<c:forEach var="section" items="${course.sections}">
	<div>sectionName: ${section.name}</div>
	<div>sectionLenght: ${section.posts}</div>
	<c:forEach var="post" items="${section.posts}">
		<div>post: ${post.body}</div>
	</c:forEach>
	<form:form modelAttribute="postbean" role="form" method="post" action="${postActionUrl}/${section.externalId}" enctype="multipart/form-data">
		<form:input placeholder="What's on your mind, hey teach'?" class="form-control" path="content"></form:input>
		<button type="submit">SUBMIITZ</button>
	</form:form>

		
</c:forEach>




<div class="col-md-11"></div>
<div class="col-md-1"><input type="submit"></div>