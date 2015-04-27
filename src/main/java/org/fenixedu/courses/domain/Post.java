package org.fenixedu.courses.domain;

import org.fenixedu.courses.ui.PostBean;

public class Post extends Post_Base {

    public Post() {
        super();
    }

    public Post(PostBean postbean) {
        setBody(postbean.getContent());
    }
}
