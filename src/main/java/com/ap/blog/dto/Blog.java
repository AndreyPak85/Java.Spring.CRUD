package com.ap.blog.dto;

import com.ap.blog.entity.BlogEntity;
import org.springframework.http.ResponseEntity;

public class Blog {
    public Long id;
    public String title;

    public Blog() {


    }

    public static Blog toDto(BlogEntity entity) {
        Blog model = new Blog();
        model.setId(entity.getId());
        model.setTitle( entity.getTitle());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
