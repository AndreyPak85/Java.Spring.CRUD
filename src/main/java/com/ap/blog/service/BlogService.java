package com.ap.blog.service;

import com.ap.blog.dto.Blog;
import com.ap.blog.entity.BlogEntity;
import com.ap.blog.exceptions.BlogAlreadyExistException;
import com.ap.blog.exceptions.BlogNotFound;
import com.ap.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepo;

    public Iterable<BlogEntity> getBlogs() {
        return blogRepo.findAll();
    }

    public BlogEntity saveBlog(BlogEntity blog) throws BlogAlreadyExistException {
        if(blogRepo.findByTitle(blog.getTitle()) != null) {
            throw new BlogAlreadyExistException("Title already exist");
        }

        return blogRepo.save(blog);
    }

    public Blog getDetailBlog(Long id) throws BlogNotFound {
        if(blogRepo.findById(id).get() == null) {
            throw new BlogNotFound("Blog id is not found");
        }
        return Blog.toDto(blogRepo.findById(id).get());
    }

    public Long deleteBlog(Long id) {
        blogRepo.deleteById(id);
        return id;
    }

}
