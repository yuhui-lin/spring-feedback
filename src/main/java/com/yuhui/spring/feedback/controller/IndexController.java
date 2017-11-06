package com.yuhui.spring.feedback.controller;

import com.yuhui.spring.feedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("feedback-link")
    public String confirm(Model model) {
        String code = this.generateId();
        while (this.feedbackRepository.findOne(code) != null) {
            code = this.generateId();
        }
        model.addAttribute("id", code);
        return "link";
    }

    // generate 12 digit code
    public String generateId() {
        String[] result = new String[3];
        for (int i = 0; i < result.length; ++i) {
            result[i] = Integer.toString(ThreadLocalRandom.current().nextInt(1000, 10000));
        }
        return String.join("-", result);
    }
}
