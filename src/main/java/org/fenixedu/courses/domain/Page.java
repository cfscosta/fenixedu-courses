package org.fenixedu.courses.domain;

import java.util.List;

import org.fenixedu.bennu.core.domain.User;

public class Page extends Page_Base {

    public Page() {
        super();
    }

    public Page(List<User> users, User owner) {

    }

    public Page(List<User> users, List<User> owners) {

    }

}
