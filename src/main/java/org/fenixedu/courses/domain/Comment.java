package org.fenixedu.courses.domain;

import java.util.Comparator;

import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.courses.ui.CommentBean;
import org.joda.time.DateTime;

public class Comment extends Comment_Base {

    static Comparator<Comment> BY_DATE_COMPARATOR = new Comparator<Comment>() {

        @Override
        public int compare(Comment o1, Comment o2) {
            DateTime o1Date = o1.getCreated();
            DateTime o2Date = o2.getCreated();
            if (o1Date == null || o2Date == null) {
                return 0;
            }
            try {
                return o1Date.compareTo(o2Date);
            } catch (NumberFormatException fe) {
            }

            return 0;
        }

    };

    public Comment() {
        super();
    }

    public Comment(CommentBean commentBean) {
        super();
        setBody(commentBean.getContent());
        setCreated(new DateTime());
        setAuthor(Authenticate.getUser());
    }

}
