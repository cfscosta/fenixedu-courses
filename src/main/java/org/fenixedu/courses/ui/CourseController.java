package org.fenixedu.courses.ui;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.fenixedu.courses.domain.Comment;
import org.fenixedu.courses.domain.Course;
import org.fenixedu.courses.domain.Post;
import org.fenixedu.courses.domain.Section;
import org.fenixedu.courses.ui.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@SpringFunctionality(app = LobbyController.class, title = "title.Courses")
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping
    public String home(Model model) {
        User user = Authenticate.getUser();
        model.addAttribute("pages", user.getCourseSet());
        model.addAttribute("world", "Worldeee");
        return "courses/home";
    }

    @RequestMapping(value = "/addSection/{courseId}", method = RequestMethod.POST)
    public RedirectView addSection(Model model, @PathVariable Course courseId, @ModelAttribute SectionBean sectionBean) {
        courseService.addSection(courseId, sectionBean);
        return new RedirectView("/lobby/visitCourse/" + courseId.getExternalId(), true);
    }

    @RequestMapping(value = "/addPost/{sectionId}", method = RequestMethod.POST)
    public RedirectView addPost(Model model, @PathVariable Section sectionId, @ModelAttribute PostBean postbean) {
        courseService.addPost(sectionId, postbean);
        return new RedirectView("/lobby/visitCourse/" + sectionId.getCourse().getExternalId(), true);
    }

    @RequestMapping(value = "/addComment/{postId}", method = RequestMethod.POST)
    public RedirectView addComment(Model model, @PathVariable Post postId, @ModelAttribute CommentBean commentBean) {
        courseService.addComment(postId, commentBean);
        return new RedirectView("/lobby/visitCourse/" + postId.getSections().getCourse().getExternalId(), true);
    }

    @RequestMapping(value = "/votePost/{postId}", method = RequestMethod.POST)
    public RedirectView votePost(Model model, @PathVariable Post postId, @ModelAttribute VoteBean voteBean) {
        courseService.votePost(postId, voteBean);
        return new RedirectView("/lobby/visitCourse/" + postId.getSections().getCourse().getExternalId(), true);
    }

    @RequestMapping(value = "/voteComment/{commentId}", method = RequestMethod.POST)
    public RedirectView voteComment(Model model, @PathVariable Comment commentId, @ModelAttribute VoteBean voteBean) {
        courseService.voteComment(commentId, voteBean);
        return new RedirectView("/lobby/visitCourse/" + commentId.getPost().getSections().getCourse().getExternalId(), true);
    }

}