package org.fenixedu.courses.ui;

import javax.servlet.UnavailableException;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Course;
import org.fenixedu.courses.ui.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import pt.ist.fenixframework.FenixFramework;

@SpringApplication(group = "anyone", path = "courses", title = "title.Courses", hint = "courses-2.0")
@SpringFunctionality(app = LobbyController.class, title = "title.Courses")
@RequestMapping("/lobby")
public class LobbyController {

    @Autowired
    CourseService courseService;

    @RequestMapping
    public String home(Model model) {
        User user = Authenticate.getUser();
        model.addAttribute("actionCreate", "/lobby/createCourse");
        model.addAttribute("actionVisit", "/lobby/visitCourse");
        model.addAttribute("coursebean", new CreateCourseBean());
        model.addAttribute("courses", user.getCourseSet());
        return "courses/home";
    }

    @RequestMapping(value = "/joinCourse/{course}", method = RequestMethod.POST)
    public String joinCourse(@PathVariable Course course, @ModelAttribute JoinCourseBean coursebean, Model model) {
        Course page = FenixFramework.getDomainObject(coursebean.getCourseId());
        if (FenixFramework.isDomainObjectValid(page)) {
            if (page.getExternalId().equals(coursebean.getCouseToken())) {
                page.addUser(Authenticate.getUser());
            } else {
                return home(model);
            }
        }
        return visitCourse(page, model);
    }

    @RequestMapping(value = "/visitCourse/{course}", method = RequestMethod.GET)
    public String visitCourse(@PathVariable Course course, Model model) {
        model.addAttribute("course", course);
        model.addAttribute("postBean", new PostBean());
        model.addAttribute("commentBean", new CommentBean());
        model.addAttribute("actionPost", "/courses/addPost");
        model.addAttribute("actionComment", "/courses/addComment");
        return "courses/view";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.GET)
    public String createCourse(Model model) {
        return "courses/create";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public RedirectView createCourse(@ModelAttribute CreateCourseBean coursebean, Model model, BindingResult errors)
            throws UnavailableException {
        Course course = courseService.newCourse(coursebean);
        return new RedirectView("/lobby/visitCourse/" + course.getExternalId(), true);
    }

}