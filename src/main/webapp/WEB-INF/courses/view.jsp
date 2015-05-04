<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>${course.name}</h1>
<spring:url var="postActionUrl" value="${actionPost}"/>
<spring:url var="commentActionUrl" value="${actionComment}"/>
<c:forEach var="section" items="${course.section}">
	<div>sectionName: ${section.name}</div>
	<div>sectionLenght: ${section.post}</div>
	<c:forEach var="post" items="${section.post}">
		<div class="col-md-12 bg-info" style="margin-bottom:14px;">
			post: ${post.body}
			<c:forEach var="comment" items="${post.comments}">
				<div class="bg-warning">
					comment: ${comment.body}
					<p> author: ${comment.author.name} -- ${comment.created}</p>
				</div>
			</c:forEach>
			postAuthor: ${post.author.name}
			<form:form modelAttribute="commentBean" role="form" method="post" action="${commentActionUrl}/${post.externalId}" enctype="multipart/form-data">
				<form:input type="text" placeholder="Commentzz" class="form-control" path="content" required="required"></form:input>
				<button type="submit">SUBMIITZ</button>
			</form:form>
			
		</div>
		<br/><br/>
	</c:forEach>
	<form:form modelAttribute="postBean" role="form" method="post" action="${postActionUrl}/${section.externalId}" enctype="multipart/form-data">
		<form:input type="text" placeholder="POSTZZ" class="form-control" path="content" required="required"></form:input>
		<button type="submit">SUBMIITZ</button>
	</form:form>
</c:forEach>
