<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>${course.name}</h1>
<spring:url var="postActionUrl" value="${actionPost}"/>
<spring:url var="commentActionUrl" value="${actionComment}"/>
<c:forEach var="section" items="${course.sections}">
	<div>sectionName: ${section.name}</div>
	<div>sectionLenght: ${section.posts}</div>
	<c:forEach var="post" items="${section.posts}">
		<div class="col-md-12 bg-info">
			post: ${post.body}
			<c:forEach var="comment" items="${post.commentSet}">
				<p class="bg-warning"> comment: ${comment.body}</p>
			</c:forEach>
			<form:form modelAttribute="commentBean" role="form" method="post" action="${commentActionUrl}/${post.externalId}" enctype="multipart/form-data">
				<form:input placeholder="Commentzz" class="form-control" path="content"></form:input>
				<button type="submit">SUBMIITZ</button>
			</form:form>
		</div>
		<p class="bg-info"> - </p>
	</c:forEach>
	<form:form modelAttribute="postBean" role="form" method="post" action="${postActionUrl}/${section.externalId}" enctype="multipart/form-data">
		<form:input placeholder="POSTZZ" class="form-control" path="content"></form:input>
		<button type="submit">SUBMIITZ</button>
	</form:form>
</c:forEach>
