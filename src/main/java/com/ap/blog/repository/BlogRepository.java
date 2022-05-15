package com.ap.blog.repository;

import com.ap.blog.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<BlogEntity, Long> {

    BlogEntity findByTitle(String title);

}
