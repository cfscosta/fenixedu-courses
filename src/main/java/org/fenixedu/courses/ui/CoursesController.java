package org.fenixedu.courses.ui;

import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courses")
@SpringApplication(group = "logged", path = "courses", title = "title.Courses")
@SpringFunctionality(app = CoursesController.class, title = "title.Courses")
public class CoursesController {

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("world", "Worldeee");
        return "courses/home";
    }

    @RequestMapping(value = "/joinCourse/{courseId}", method = RequestMethod.GET)
    public String joinCourse(Model model, @PathVariable Page courseId) {
        return "";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.GET)
    public String createCourse(Model model) {
        return "";
    }

    @RequestMapping(value = "/visitCourse/(courseId}", method = RequestMethod.GET)
    public String visitCourse(Model model, @PathVariable Page courseId) {
        return "";
    }

}