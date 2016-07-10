package com.zs.minitcp.dao.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.zs.minitcp.dao.BlogDao;
import com.zs.minitcp.model.Blog;
import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by eric on 16/7/5.
 */
@Component
public class BlogMongoDao extends MongoDaoBase implements BlogDao {
    MongoCollection<Document> cBlog;

    public BlogMongoDao() {
        super();
        cBlog = mongoClient.getDatabase(minitcpDB).getCollection("blog");
    }

    @Override
    public List<Blog> getBlogsByTs(long st, int limit) {
        FindIterable<Document> postTime = cBlog.find(Filters.lt("postTime", st)).limit(limit);
        List<Blog> blogs = new LinkedList<>();
        for (Document document : postTime) {
            blogs.add(toObject(document,Blog.class));
        }
        return blogs;
    }

    @Override
    public void addBlog(Blog blog) {
        blog.setId(DigestUtils.sha1Hex(blog.getSourceUrl()));
        Document document = toDocument(blog);
        document.put("_id",blog.getId());
        cBlog.insertOne(document);
    }

    @Override
    public void delBlogById(String blogId) {
        cBlog.deleteOne(Filters.eq("_id",blogId));
    }

    @Override
    public Blog getBlogById(String blogId) {
        Document doc = cBlog.find(Filters.eq("_id", blogId)).first();
        return toObject(doc,Blog.class);
    }
}
