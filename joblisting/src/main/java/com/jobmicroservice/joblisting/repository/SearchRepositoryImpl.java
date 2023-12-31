package com.jobmicroservice.joblisting.repository;

import com.jobmicroservice.joblisting.entity.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SearchRepositoryImpl implements SearchRepository {
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    public List<Post> findByText(String text) {
        List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("Cluster0");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                new Document("text",
                new Document("query", text)
                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(converter.read(Post.class,doc))); //doc is in mongoDB document format whereas posts is in java format,so we need converter
        return posts;
    }
}
