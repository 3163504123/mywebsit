package com.zs.minitcp.utils;

import com.ptb.uranus.spider.weixin.bean.WxArticle;
import com.zs.minitcp.model.Blog;
import org.jsoup.Jsoup;

/**
 * Created by eric on 16/7/5.
 */
public class MConvertUtils {
    public static Blog convertWxArticleToBlog(WxArticle wxArticle) {
        Blog blog = new Blog();
        blog.setContent(Jsoup.parseBodyFragment(wxArticle.getContent()).text());
        blog.setPostTime(wxArticle.getPostTime());
        blog.setTitle(wxArticle.getTitle());
        blog.setAuthor(wxArticle.getAuthor());
        blog.setSource(wxArticle.getNickName());
        blog.setSourceUrl(wxArticle.getArticleUrl());
        blog.setConverPlan(wxArticle.getCoverImgUrl());
        return blog;
    }
}
