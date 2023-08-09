package com.jobmicroservice.joblisting.controller;

import com.jobmicroservice.joblisting.entity.Post;
import com.jobmicroservice.joblisting.repository.PostRepository;
import com.jobmicroservice.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    SearchRepository searchRepository;

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    // @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public void addPost(@RequestBody Post post) {
        postRepository.save(post);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{text}")
    public List<Post> getPostsByText(@PathVariable String text) {
        return searchRepository.findByText(text);
    }

    public void updatePosts(){
        postRepository.
    }
}
