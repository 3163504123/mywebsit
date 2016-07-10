package com.zs.minitcp.model;

import javax.validation.constraints.NotNull;

/**
 * Created by eric on 16/7/5.
 */
public class BlogLink {
    final static int BlogTypeCommon = 0; //common
    final static int BlogTypeSelf = 1; //common

    @NotNull
    String url;

    @NotNull
    int type;

    public BlogLink(String s, int i) {
        this.url = s;
        this.type = i;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
