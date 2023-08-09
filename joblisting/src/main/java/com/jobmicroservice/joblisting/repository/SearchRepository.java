package com.jobmicroservice.joblisting.repository;

import com.jobmicroservice.joblisting.entity.Post;

import java.util.List;

public interface SearchRepository {
        public List<Post> findByText(String text);
}
