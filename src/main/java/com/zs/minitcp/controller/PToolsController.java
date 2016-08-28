package com.zs.minitcp.controller;

import com.zs.minitcp.entity.ReqBlogList;
import com.zs.minitcp.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eric on 16/7/3.
 */
@Controller
public class PToolsController extends BaseController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/jsonTool", method = RequestMethod.GET)
    public String BlogsPage(ReqBlogList reqBlogList, Model model) {
        return "tool/jsonTool";
    }

    @RequestMapping(value = "/timeTool", method = RequestMethod.GET)
    public String timeToolPage(ReqBlogList reqBlogList, Model model) {
        return "tool/timeTool";
    }

}
