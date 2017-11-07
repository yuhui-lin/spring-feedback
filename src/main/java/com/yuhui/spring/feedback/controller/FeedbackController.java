package com.yuhui.spring.feedback.controller;

import com.yuhui.spring.feedback.model.Feedback;
import com.yuhui.spring.feedback.model.Product;
import com.yuhui.spring.feedback.repository.FeedbackRepository;
import com.yuhui.spring.feedback.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * main controller for adding/showing feedbacks.
 */
@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/feedbacks")
    public String getFeedbacks(Model model) {

        // TODO: add pageable and sort
        model.addAttribute("feedbacks", this.feedbackRepository.findAll());
        List<Product> p = this.productRepository.findAll();
        model.addAttribute("products", p);
        return "feedbacksList";
    }

    @GetMapping("/feedbacks/{id}")
    public String getFeedbackById(@PathVariable String id, Model model) {
        Feedback fb = this.feedbackRepository.findOne(id);
        if (fb == null)
            throw new RuntimeException("fb wrong");
        model.addAttribute("feedback", fb);
        return "feedbackDetails";
    }

    @GetMapping("/feedbacks/create")
    public String createFeedback(@RequestParam("id") String id, Model model) {
        // if this feedback has been submitted before, don't create.
        if (this.feedbackRepository.findOne(id) != null) {
            return "redirect:/";
        }
        model.addAttribute("feedback", new Feedback(id));
        return "create";
    }

    @PostMapping(value = "/feedbacks/create")
    public String createFeedback(@Valid Feedback feedback, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        this.feedbackRepository.save(feedback);
        return "redirect:/feedbacks/" + feedback.getId();
    }
}
