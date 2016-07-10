package com.zs.minitcp.dao;

import com.zs.minitcp.model.Blog;

import java.util.List;

/**
 * Created by eric on 16/7/5.
 */
public interface BlogDao {
    List<Blog> getBlogsByTs(long st, int limit);

    void addBlog(Blog blog);

    void delBlogById(String blogId);

    Blog getBlogById(String blogId);
}
