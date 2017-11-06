package com.yuhui.spring.feedback.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private String id;
    private String name;
    private String imagePath;
}
