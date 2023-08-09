package com.jobmicroservice.joblisting.repository;

import com.jobmicroservice.joblisting.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
