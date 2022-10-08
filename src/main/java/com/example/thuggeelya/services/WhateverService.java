package com.example.thuggeelya.services;

import com.example.thuggeelya.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WhateverService {

    private static final Integer POINTS_FOR_BEST_COMMENT_WHEN_CLOSING_CASE = 20;
    private final ActivityRepository activityRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final Comparator<Activity> casesComparator = Comparator.comparingInt(a -> a.getComments().size());

    @Autowired
    public WhateverService(ActivityRepository activityRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public List<Activity> getCases() {
        return activityRepository.findCases().stream().sorted(casesComparator).collect(Collectors.toList());
    }

    public Activity findCaseById(Integer id) {
        return activityRepository.findByIdactivity(id).orElseThrow(NoSuchElementException::new);
    }

    public Comment comment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByIdactivity(Integer idactivity) {
        return new ArrayList<>(activityRepository.findByIdactivity(idactivity)
                .orElseThrow(NoSuchElementException::new)
                .getComments());
    }

    public void likeComment(Comment comment) {
        comment.setNlikes(comment.getNlikes() + 1);
        commentRepository.save(comment);
        User user = comment.getIduser();
        user.setMonthrate(user.getMonthrate() + 1);
        userRepository.save(user);
        System.out.println("user #" + user.getIduser() + " up month rate by comment #" + comment.getIdcomment());
    }

    public boolean closeCase(Integer idactivity) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {
            return false;
        }

        Object principal = auth.getPrincipal();
        LoginForm loginForm = (principal instanceof LoginForm) ? (LoginForm) principal : null;
        System.out.println(loginForm);
        User user = Objects.nonNull(loginForm) ? userRepository.findByIduser(loginForm.getIduser()).orElse(null) : null;

        if (Objects.nonNull(loginForm) && Objects.isNull(user)) {
            user = userRepository.findByIduser(loginForm.getIduser()).orElseThrow(NoSuchElementException::new);
        }

        if (Objects.isNull(user)) {
            System.err.println("user is null");
            return false;
        }

        Activity acase = activityRepository.findByIdactivity(idactivity).orElseThrow(NoSuchElementException::new);

        if (acase.getCreator().equals(user)) {
            acase.setStatus(ActivityStatus.getPASSED());
            activityRepository.save(acase);

            user.setMonthrate(user.getMonthrate() + POINTS_FOR_BEST_COMMENT_WHEN_CLOSING_CASE);
            userRepository.save(user);
            return true;
        }

        return false;
    }
}
