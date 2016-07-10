package com.zs.minitcp.controller;

import com.zs.minitcp.entity.ReqBlogList;
import com.zs.minitcp.entity.response.BaseResponse;
import com.zs.minitcp.model.Blog;
import com.zs.minitcp.model.BlogLink;
import com.zs.minitcp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by eric on 16/7/5.
 */
@Controller
@RequestMapping("admin/api")
public class ABlogController extends BaseController {
    @Autowired
    BlogService blogService;

    @RequestMapping("blog/add")
    @ResponseBody
    public Object apiAddBlog(BlogLink blogLink) {
        blogService.addByBlogLink(blogLink);
        return BaseResponse.NormalResponse;
    }

    @RequestMapping("blog/list")
    @ResponseBody
    public Object apiBlogList(ReqBlogList reqBlogList) {
        List<Blog> blogs = blogService.getBlogs(reqBlogList.getSt(), reqBlogList.getSize());
        return new BaseResponse<>(blogs);
    }

    @RequestMapping("blog/del/{id}")
    @ResponseBody
    public Object apiBlogList(@PathVariable("id") String blogId) {
        blogService.delBlog(blogId);
        return BaseResponse.NormalResponse;
    }
}
