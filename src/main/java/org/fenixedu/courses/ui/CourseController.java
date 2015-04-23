package org.fenixedu.courses.ui;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Comment;
import org.fenixedu.courses.domain.Course;
import org.fenixedu.courses.domain.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courses/page/")
@SpringApplication(group = "logged", path = "courses", title = "title.Courses")
@SpringFunctionality(app = LobbyController.class, title = "title.Courses")
public class CourseController {

    @RequestMapping
    public String home(Model model) {
        User user = Authenticate.getUser();
        model.addAttribute("pages", user.getCoursesSet());
        model.addAttribute("world", "Worldeee");
        return "courses/home";
    }

    @RequestMapping(value = "/addPost/{courseId}", method = RequestMethod.POST)
    public String addPost(Model model, @PathVariable Course courseId) {
        return "";
    }

    @RequestMapping(value = "/addComment/{courseId}/{postId}", method = RequestMethod.POST)
    public String addComment(Model model, @PathVariable Course courseId, Post postId) {
        return "";
    }

    @RequestMapping(value = "/votePost/{courseId}/{postId}", method = RequestMethod.POST)
    public String votePost(Model model, @PathVariable Course courseId, Post postId) {
        return "";
    }

    @RequestMapping(value = "/voteComment/{courseId}/{postId}/{commentId}", method = RequestMethod.POST)
    public String voteComment(Model model, @PathVariable Course courseId, Post postId, Comment commentId) {
        return "";
    }

}