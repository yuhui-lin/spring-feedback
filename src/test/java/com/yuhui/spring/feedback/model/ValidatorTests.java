package com.yuhui.spring.feedback.model;

import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTests {
    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Test
    public void shouldNotValidateWhenFirstNameEmpty() {

        LocaleContextHolder.setLocale(Locale.ENGLISH);
        Feedback feedback = new Feedback();
        feedback.setFirstName("");
        feedback.setLastName("smith");
        feedback.setCity("waterloo");
        feedback.setPhoneNum("1234567890");
        feedback.setRating("5");

        Validator validator = createValidator();
        Set<ConstraintViolation<Feedback>> constraintViolations = validator.validate(feedback);

        assertThat(constraintViolations.size()).isEqualTo(1);
        ConstraintViolation<Feedback> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("firstName");
        assertThat(violation.getMessage()).isEqualTo("may not be empty");
    }

}
