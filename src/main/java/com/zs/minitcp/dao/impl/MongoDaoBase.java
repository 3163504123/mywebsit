package com.zs.minitcp.dao.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.zs.minitcp.utils.MongoUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.bson.Document;

/**
 * Created by eric on 16/7/5.
 */
public class MongoDaoBase {
    protected Configuration conf;
    protected String minitcpDB;
    protected MongoClient mongoClient;

    public MongoDaoBase() {
        try {
            conf = new PropertiesConfiguration("minitcp.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("没有找到mintcp.properties的配置文件", e);
        }
        MongoUtils.configure(conf.getString("minitcp.server.mongodb.host", "127.0.0.1"),
                conf.getInt("minitcp.server.mongodb.port",27017));
        minitcpDB = conf.getString("minitcp.server.mongodb.db","minitcp");
        mongoClient = MongoUtils.instance();
    }
    public Document toDocument(Object object) {
        return Document.parse(JSON.toJSONString(object));
    }

    public <T> T toObject(Document doc,Class<T> t) {
        return JSON.parseObject(JSON.toJSONString(doc),t);
    }
}
