package org.fenixedu.courses.ui;

import javax.servlet.UnavailableException;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Course;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

@RequestMapping("/courses")
@SpringApplication(group = "logged", path = "courses", title = "title.Courses")
@SpringFunctionality(app = LobbyController.class, title = "title.Courses")
public class LobbyController {

    @RequestMapping
    public String home(Model model) {
        User user = Authenticate.getUser();
        model.addAttribute("action", "/createCourse");
        model.addAttribute("pages", user.getCoursesSet());
        model.addAttribute("world", "Worldeee");
        return "courses/home";
    }

    @RequestMapping(value = "/joinCourse/{courseId}", method = RequestMethod.POST)
    public String joinCourse(Model model, @PathVariable Course courseId, @ModelAttribute JoinCourseBean coursebean) {
        Course page = FenixFramework.getDomainObject(coursebean.getCourseId());
        if (FenixFramework.isDomainObjectValid(page)) {
            if (page.getExternalId().equals(coursebean.getCouseToken())) {
                page.addUsers(Authenticate.getUser());
            } else {
                return home(model);
            }
        }
        return visitCourse(model, page);
    }

    @RequestMapping(value = "/visitCourse/(courseId}", method = RequestMethod.GET)
    public String visitCourse(Model model, @PathVariable Course courseId) {
        return "courses/view";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.GET)
    public String createCourse(Model model) {
        return "courses/create";
    }

    @Atomic
    public Course newCourse(CreateCourseBean coursebean) {
        Course course = new Course();
        course.setName(coursebean.getName());
        course.setOwner(Authenticate.getUser());
        course.addUsers(Authenticate.getUser());
        return course;
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@ModelAttribute CreateCourseBean coursebean, Model model, BindingResult errors)
            throws UnavailableException {
        Course course = newCourse(coursebean);
        return visitCourse(model, course);
    }

}