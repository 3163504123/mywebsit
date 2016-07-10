package com.zs.minitcp.controller;

import com.zs.minitcp.entity.ReqBlogList;
import com.zs.minitcp.model.Blog;
import com.zs.minitcp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by eric on 16/7/3.
 */
@Controller
public class PBlogController extends BaseController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/blog/list", method = RequestMethod.GET)
    public String BlogsPage(ReqBlogList reqBlogList, Model model) {
        List<Blog> blogs = blogService.getBlogs(reqBlogList.getSt(), reqBlogList.getSize());
        if (blogs != null) {
            model.addAttribute("blogs",blogs);
        }
        return "blogs";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        List<Blog> blogs = blogService.getBlogs(System.currentTimeMillis(), 10);
        if (blogs != null) {
            model.addAttribute("blogs",blogs);
        }
        return "blogs";
    }

    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.GET)
    public String BlogsDetail(@PathVariable String blogId, Model model) {
        Blog blog = blogService.getBlog(blogId);
        model.addAttribute(blog);
        return "blog";
    }

}
