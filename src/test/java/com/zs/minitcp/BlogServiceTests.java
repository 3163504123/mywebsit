package com.zs.minitcp;

import com.ptb.uranus.spider.weixin.WeixinSpider;
import com.zs.minitcp.model.Blog;
import com.zs.minitcp.model.BlogLink;
import com.zs.minitcp.service.BlogService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class BlogServiceTests {

    @Autowired
    BlogService blogService;
    WeixinSpider weixinSpider = new WeixinSpider();

    @Test
    public void CRUD() throws Exception {
        String url = "http://mp.weixin.qq.com/s?__biz=MjM5NjMzMTkzNQ==&mid=2656582605&idx=1&sn=78b0856b6b6ea544b95f8773fe46d839#rd";
        blogService.addByBlogLink(new BlogLink(url, 0));

        List<Blog> blogs = blogService.getBlogs(System.currentTimeMillis(), 10);
        for (Blog blog : blogs) {
            System.out.println(blog.toString());
        }

        blogService.delBlog(DigestUtils.sha1Hex(url));

    }
}
