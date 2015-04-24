<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>${course.name}</h1>

<c:forEach var="section" items="${course.sections}">
	<div>sectionName: ${section.name}</div>
	<div>sectionLenght: ${section.posts}</div>
	<c:forEach var="post" items="${section.posts}">
		<div>post: ${post.text}</div>
	</c:forEach>
	<form:form modelAttribute="coursebean" role="form" method="post" action="${formActionUrl}" enctype="multipart/form-data">
		<input type="text" name="name">
		<button type="submit">SUBMIITZ</button>
	</form:form>
</c:forEach>
<input placeholder="What's on your mind, hey teach'?" class="form-control">
<div class="col-md-11"></div>
<div class="col-md-1"><input type="submit"></div>