package org.fenixedu.courses.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.courses.ui.PostBean;
import org.joda.time.DateTime;

public class Post extends Post_Base {

    public Post() {
        super();
    }

    public Post(PostBean postbean) {
        super();
        setBody(postbean.getContent());
        setCreated(new DateTime());
        setAuthor(Authenticate.getUser());
    }

    public List<Comment> getComments() {
        Stream<Comment> comments = getCommentSet().stream();
        return comments.sorted(Comment.BY_DATE_COMPARATOR).collect(Collectors.toList());
    }
}
