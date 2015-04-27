package org.fenixedu.courses.domain;

import org.fenixedu.courses.ui.VoteBean;

public class Vote extends Vote_Base {

    public Vote() {
        super();
    }

    public Vote(VoteBean voteBean) {
        setUp(voteBean.isUp());
    }

}
