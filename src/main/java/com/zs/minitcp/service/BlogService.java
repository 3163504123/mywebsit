package com.zs.minitcp.service;

import com.ptb.uranus.spider.weixin.WeixinSpider;
import com.ptb.uranus.spider.weixin.bean.WxArticle;
import com.zs.minitcp.dao.BlogDao;
import com.zs.minitcp.exception.ZeusException;
import com.zs.minitcp.model.Blog;
import com.zs.minitcp.model.BlogLink;
import com.zs.minitcp.utils.MConvertUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by eric on 16/7/4.
 */
@Component
public class BlogService {
    static Logger logger = LoggerFactory.getLogger(BlogService.class);
    @Autowired
    BlogDao blogDao;

    WeixinSpider weixinSpider = new WeixinSpider();

    public List<Blog> getBlogs(long ts, int limit) {
        return blogDao.getBlogsByTs(ts, limit);
    }

    @Scheduled(fixedRate = 3600000, initialDelay = 6000)
    public void importSogouArticle() {
        logger.info("start schedule");
        List<String> hotArticleFromSogou = getHotArticleFromSogou();
        hotArticleFromSogou.forEach(k -> {
                    try {
                        addByBlogLink(new BlogLink(k, 0));
                    } catch (Exception e) {
                        logger.warn(String.format("add article url %s error", k));
                    }

                }
        );
        logger.info("end schedule");
    }

    public List<String> getHotArticleFromSogou() {
        List<String> articles = new ArrayList<>();
            try {
                Document parse = Jsoup.parse(
                        new URL("http://weixin.sogou.com/pcindex/pc/pc_9/pc_9.html"), 2000);
                Elements src = parse.select("a[href^=\"http://mp.weixin.qq.com/s\"]");
                List<String> urls = src.parallelStream().map(element -> {
                    String url = element.attr("href");
                    return url;
                }).distinct().collect(Collectors.toList());
                if (urls != null) {
                    articles.addAll(urls);
                }
            } catch (Exception e) {
            }
        return articles;
    }

    public void addByBlogLink(BlogLink blogLink) {
        Optional<WxArticle> articleOptional = weixinSpider.getArticleByUrl(blogLink.getUrl());
        if (articleOptional.isPresent()) {
            blogDao.addBlog(MConvertUtils.convertWxArticleToBlog(articleOptional.get()));
        } else {
            throw ZeusException.BlogClawerWxArticleError;
        }
    }

    public void delBlog(String blogId) {
        blogDao.delBlogById(blogId);
    }

    public Blog getBlog(String blogId) {
        return blogDao.getBlogById(blogId);
    }
}
