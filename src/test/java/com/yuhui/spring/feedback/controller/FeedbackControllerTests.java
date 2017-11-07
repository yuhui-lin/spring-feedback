package com.yuhui.spring.feedback.controller;

import com.yuhui.spring.feedback.model.Feedback;
import com.yuhui.spring.feedback.repository.FeedbackRepository;
import com.yuhui.spring.feedback.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * test class for testing FeedbackController.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FeedbackController.class)
public class FeedbackControllerTests {

    private static final String TEST_ID = "1234-5678-1111";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FeedbackRepository feedbackRepository;
    @MockBean
    private ProductRepository productRepository;

    private Feedback feedback;

    @Before
    public void setup() {
        feedback = new Feedback(this.TEST_ID);
        feedback.setFirstName("George");
        feedback.setLastName("Franklin");
        feedback.setAddress("110 W. Liberty St.");
        feedback.setCity("Madison");
        feedback.setPhoneNum("6085551023");
        feedback.setRating("3");
        given(this.feedbackRepository.findOne(TEST_ID)).willReturn(feedback);
    }

    @Test
    public void testInitCreationForm() throws Exception {
        mockMvc.perform(get("/feedbacks/create?id=" + "2222-2222-2222"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("feedback"))
                .andExpect(view().name("create"));
    }

    @Test
    public void testProcessCreationFormSuccess() throws Exception {
        mockMvc.perform(post("/feedbacks/create")
                .param("firstName", "Joe")
                .param("lastName", "Bloggs")
                .param("address", "123 Caramel Street")
                .param("city", "London")
                .param("phoneNum", "01316761638")
                .param("rating", "4")
        )
                .andExpect(status().is3xxRedirection());
    }

    // TODO: create more unit tests
}
