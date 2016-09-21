<#-- @ftlvariable name="blogs" type="com.zs.minitcp.model.Blog[]" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="keywords" content="Java学习,Java视频,Hadoop视频,JSON格式化,XML格式化,微信阅读数"/>
    <meta name="description" content="Java学习,Java视频,Hadoop视频,Java学习,XML转换,JSON转换,微信阅读数,REST API,IT视频" />
    <meta charset="UTF-8">
    <title>MiniTcp</title>
    <#include "common/common.ftl"/>
</head>
<body>
<div class="container">
<#include "common/nav.ftl"/>
    <div class="main">
        <div class="mydata toolData">
            <h2>
                热门工具 / <span>Hot Tools</span>
                <a href="#" rel="nofollow">更多&gt;&gt;</a>
            </h2>
            <ul>
                <li>
                    <div class="dataDiv">
                        <a href="jsonTool" title="">
                            <img class="png_bg" src="img/file-json.png" alt="">
                        </a>
                    </div>
                    <div class="dataDes">
                        <div class="dataTitle">JSON格式化</div>
<#--                        <p>已连接APP：<span>39904</span></p>-->
                    </div>
                </li>
                <li>
                    <div class="dataDiv">
                        <a href="timeTool" title="">
                            <img class="png_bg" src="img/timer.png" alt="">
                        </a>
                    </div>
                    <div class="dataDes">
                        <div class="dataTitle">时间戳转换</div>
                    <#--                        <p>已连接APP：<span>39904</span></p>-->
                    </div>
                </li>
            </ul>
        </div>
        <div class="mydata recentTools">
            <h2>
                最新视频 / <span>Recent Video</span>
                <a href="#" rel="nofollow">更多&gt;&gt;</a>
            </h2>
            <ul>
            <#--    <li>
                    <div class="dataDiv">
                        <a href="#" title="">
                            <img class="png_bg" src="img/a8.png" alt="">
                        </a>
                    </div>
                    <div class="dataDes">
                        <div class="dataTitle">JavaApi-</div>
                       &lt;#&ndash; <p>已连接APP：<span>39904</span></p>&ndash;&gt;
                    </div>
                </li>-->
            </ul>
        </div>
        <div class="miniList">
            <div class="listDiv latestEnjoy">
                <h3>
                    最新分享
                    <span> / Latest Enjoy</span>
                    <a href="#">更多&gt;&gt;</a>
                </h3>
                <ul class="articleUl">
                    <#list blogs as item>
                        <li>
                            <div class="art-img">
                                <img src="${"http://img02.store.sogou.com/net/a/05/link?appid=100520091&w=240&h=120&url="+item.getConverPlan()}" alt="" />
                            </div>
                            <div class="art-txt">
                                <h4>
                                    <a href="${item.sourceUrl}"  target="_blank">
                                        ${item.getTitle()}
                                    </a>
                                </h4>
                                <div class="art-ft">
                                    发布时间：${item.postTime()?string("yyyy-MM-dd HH:mm:ss")}
                                </div>
                            </div>
                        </li>
                    </#list>
                </ul>
            </div>
            <div class="listDiv netHot">
                <h3>
                    互联网IT热文
                    <span> / IT Hot Article</span>
                    <a href="#">更多&gt;&gt;</a>
                </h3>
                <ul class="articleUl">
                <#list blogs as item>
                    <li>
                        <div class="art-img">
                            <img src="${"http://img02.store.sogou.com/net/a/05/link?appid=100520091&w=240&h=120&url="+item.getConverPlan()}" alt="" />
                        </div>
                        <div class="art-txt">
                            <h4>
                                <a href="${item.sourceUrl}" target="_blank">
                                ${item.getTitle()}
                                </a>
                            </h4>

                            <div class="art-ft">
                                发布时间：${item.postTime()?string("yyyy-MM-dd HH:mm:ss")}
                            </div>
                        </div>
                    </li>
                </#list>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>