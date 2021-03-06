package org.fenixedu.courses.ui;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Answer;
import org.fenixedu.courses.domain.Course;
import org.fenixedu.courses.domain.Question;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/courses/qanda/")
@SpringApplication(group = "logged", path = "courses", title = "title.Courses")
@SpringFunctionality(app = LobbyController.class, title = "title.Courses")
public class QandAController {

    @RequestMapping
    public String home(Model model) {
        User user = Authenticate.getUser();
        model.addAttribute("pages", user.getCourseSet());
        model.addAttribute("world", "Worldeee");
        return "courses/home";
    }

    @RequestMapping(value = "/addQuestion/{courseId}", method = RequestMethod.POST)
    public String addPost(Model model, @PathVariable Course courseId) {
        return "";
    }

    @RequestMapping(value = "/addAnswer/{courseId}/{postId}", method = RequestMethod.POST)
    public String addComment(Model model, @PathVariable Course courseId, Question questionId) {
        return "";
    }

    @RequestMapping(value = "/voteQuestion/{courseId}/{postId}", method = RequestMethod.POST)
    public String votePost(Model model, @PathVariable Course courseId, Question questionId) {
        return "";
    }

    @RequestMapping(value = "/voteAnswer/{courseId}/{postId}/{commentId}", method = RequestMethod.POST)
    public String voteComment(Model model, @PathVariable Course courseId, Question questionId, Answer answerId) {
        return "";
    }

    @RequestMapping(value = "/visitQuestion/(courseId}", method = RequestMethod.GET)
    public String visitCourse(Model model, @PathVariable Course courseId, Question questionId) {
        return "";
    }

}