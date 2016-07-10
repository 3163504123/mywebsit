$(function () {
    $('iframe').each(function () {
        var frameid = 'frameimg' + Math.random();
        window.strsc = window.strsc || {};
        window.strsc[frameid] = '<img width="90px" height="90px" id="img' + frameid + '" src=\'' + $(this).attr('src') + '\'/>';
        var str = "javascript:parent.strsc['" + frameid + "'];";
        $(this).attr('src', str);
    });
})


/*
 $('img[data-src*="mmbiz"]').replaceWith(function () {
 /!*    var whAttr = $(this).attr("data-s")*!/
 var styleAttr = $(this).attr("style")
 var height =  " style='"+styleAttr  + "' width='auto'";
 /!*    if(whAttr != undefined) {
 height = " style='"+styleAttr  + "' width='" + $(this).attr("data-s").split(",")[1]  + "' height='" + $(this).attr("data-s").split(",")[0] + "' ";
 }*!/
 /!*    var width = " width='" + $(this).attr("data-s").split(",")[0] + "' ";*!/


 var frameid = 'frameimg' + Math.random();
 window.strsc = window.strsc || {};
 window.strsc[frameid] = '<img id="' + frameid + '"   src=\'' + $(this).attr('data-src').replace(/https/g,"http") + '\''+ height + '/>';
 var str = "javascript:parent.strsc['" + frameid + "'];";
 //$(this).attr('src',str);
 return "<iframe src='"+str+  +" frameBorder='0' scrolling='no'  </iframe>"
 })*/
