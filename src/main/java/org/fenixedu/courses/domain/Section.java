package org.fenixedu.courses.domain;

import org.fenixedu.courses.ui.SectionBean;

public class Section extends Section_Base {

    public Section() {
        super();
    }

    public Section(SectionBean sectionBean) {
        setName(sectionBean.getName());
    }

}
