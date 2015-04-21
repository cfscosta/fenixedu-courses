package org.fenixedu.courses.ui;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Comment;
import org.fenixedu.courses.domain.Page;
import org.fenixedu.courses.domain.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courses/page/")
@SpringApplication(group = "logged", path = "courses", title = "title.Courses")
@SpringFunctionality(app = CoursesController.class, title = "title.Courses")
public class PageController {

    @RequestMapping
    public String home(Model model) {
        User user = Authenticate.getUser();
        model.addAttribute("pages", user.getPagesSet());
        model.addAttribute("world", "Worldeee");
        return "courses/home";
    }

    @RequestMapping(value = "/addPost/{courseId}", method = RequestMethod.POST)
    public String addPost(Model model, @PathVariable Page courseId) {
        return "";
    }

    @RequestMapping(value = "/addComment/{courseId}/{postId}", method = RequestMethod.POST)
    public String addComment(Model model, @PathVariable Page courseId, Post postId) {
        return "";
    }

    @RequestMapping(value = "/votePost/{courseId}/{postId}", method = RequestMethod.POST)
    public String votePost(Model model, @PathVariable Page courseId, Post postId) {
        return "";
    }

    @RequestMapping(value = "/voteComment/{courseId}/{postId}/{commentId}", method = RequestMethod.POST)
    public String voteComment(Model model, @PathVariable Page courseId, Post postId, Comment commentId) {
        return "";
    }

    @RequestMapping(value = "/visitCourse/(courseId}", method = RequestMethod.GET)
    public String visitCourse(Model model, @PathVariable Page courseId) {
        return "";
    }

}