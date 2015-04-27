package org.fenixedu.courses.ui.service;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.security.Authenticate;
import org.fenixedu.courses.domain.Comment;
import org.fenixedu.courses.domain.Course;
import org.fenixedu.courses.domain.Post;
import org.fenixedu.courses.domain.Section;
import org.fenixedu.courses.domain.Vote;
import org.fenixedu.courses.ui.CommentBean;
import org.fenixedu.courses.ui.CreateCourseBean;
import org.fenixedu.courses.ui.PostBean;
import org.fenixedu.courses.ui.SectionBean;
import org.fenixedu.courses.ui.VoteBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pt.ist.fenixframework.Atomic;

@Service
public class CourseService {

    @Atomic
    public Course newCourse(CreateCourseBean coursebean) {
        Course course = new Course();
        course.setName(coursebean.getName());
        course.setOwner(Authenticate.getUser());
        course.addUsers(Authenticate.getUser());
        Section section = new Section();
        section.setName("default");
        course.addSections(section);
        return course;
    }

    @Atomic
    public boolean addSection(@PathVariable Course courseId, @ModelAttribute SectionBean sectionBean) {
        User user = Authenticate.getUser();
        if (courseId.getOwner().equals(user)) {
            courseId.addSections(new Section(sectionBean));
            return true;
        }
        return false;
    }

    @Atomic
    public boolean addPost(@PathVariable Section sectionId, @ModelAttribute PostBean postbean) {
        User user = Authenticate.getUser();
        if (sectionId.getCourse().equals(user)) {
            sectionId.addPosts(new Post(postbean));
            return true;
        }
        return false;
    }

    @Atomic
    public boolean addComment(Post postId, @ModelAttribute CommentBean commentBean) {
        if (postId.getSections().getCourse().getUsersSet().contains(Authenticate.getUser())) {
            postId.addComment(new Comment(commentBean));
            return true;
        }

        return false;
    }

    @Atomic
    public boolean votePost(Post postId, @ModelAttribute VoteBean voteBean) {
        if (postId.getSections().getCourse().getUsersSet().contains(Authenticate.getUser())) {
            postId.addVote(new Vote(voteBean));
            return true;
        }
        return false;
    }

    @Atomic
    public boolean voteComment(Comment commentId, @ModelAttribute VoteBean voteBean) {
        if (commentId.getPost().getSections().getCourse().getUsersSet().contains(Authenticate.getUser())) {
            commentId.addVote(new Vote(voteBean));
            return true;
        }
        return false;
    }

}
