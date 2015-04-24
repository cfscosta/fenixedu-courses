package org.fenixedu.courses.ui;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Comment;
import org.fenixedu.courses.domain.Course;
import org.fenixedu.courses.domain.Post;
import org.fenixedu.courses.domain.Section;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/addSection/{courseId}", method = RequestMethod.POST)
    public String addSection(Model model, @PathVariable Course courseId, @ModelAttribute SectionBean sectionBean) {
        return "";
    }

    @RequestMapping(value = "/addPost/{sectionId}", method = RequestMethod.POST)
    public String addPost(Model model, @PathVariable Course courseId, @PathVariable Section sectionId,
            @ModelAttribute JoinCourseBean coursebean) {
        return "";
    }

    @RequestMapping(value = "/addComment/{postId}", method = RequestMethod.POST)
    public String addComment(Model model, Post postId, @ModelAttribute CommentBean commentBean) {
        return "";
    }

    @RequestMapping(value = "/votePost/{postId}", method = RequestMethod.POST)
    public String votePost(Model model, Post postId, @ModelAttribute VoteBean voteBean) {
        return "";
    }

    @RequestMapping(value = "/voteComment/{commentId}", method = RequestMethod.POST)
    public String voteComment(Model model, Comment commentId, @ModelAttribute VoteBean voteBean) {
        return "";
    }

}