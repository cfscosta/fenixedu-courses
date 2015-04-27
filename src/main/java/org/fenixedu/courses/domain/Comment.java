package org.fenixedu.courses.domain;

import org.fenixedu.courses.ui.CommentBean;

public class Comment extends Comment_Base {

    public Comment() {
        super();
    }

    public Comment(CommentBean commentBean) {
        setBody(commentBean.getContent());
    }

}
