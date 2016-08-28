<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="robots" content="all" />
    <meta name="author" content="minitcp.com" />

    <meta name="keywords" content="json,json在线解析,json格式化,json格式验证,json转xml,xml转json"/>
    <meta name="description" content="Json中文网致力于在中国推广Json,并提供相关的Json解析、验证、格式化、压缩、编辑器以及Json与XML相互转换等服务"/>   <meta charset="UTF-8">
    <title>MiniTcp</title>
    <#include "../common/common.ftl"/>
    <link href="css/unix.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div class="container">
   <#include "../common/nav.ftl"/>
       <div class="unix_main">
           <h1 class="mb20">Unix时间戳(Unix timestamp)</h1>
           <div class="w80">
               <div class="untime clear mb20">
                   <label class="fz14 col-blue02">Unix时间戳（Unix timestamp）</label>
                   <input type="text" name="timestamp" id="firstTimestamp" class="InputTxt w140">
                   <span class="fl lh30 plr5 pr15">秒/毫秒</span>
                   <input type="button" value="转换成北京时间" id="unixtoutc8" class="InputBtnC col-blue02 plr10 mr20">
                   <input type="text" name="unixtimeresult1" class="InputTxt w140" readonly="">
               </div>
               <div class="untime clear">
                   <label class="fz14 col-blue02">北京时间（年/月/日 时:分:秒）</label>
                   <input type="text" name="utc8" id="utc8" class="InputTxt w140 mr20">
                   <input type="button" value="转换成Unix时间戳" id="utc8tounix1" class="InputBtnC col-blue02 plr5 mr20  ml10">
                   <input type="text" name="unixtoutc8result" class="InputTxt w140" readonly="">
                   <lable class="fl lh30 pl5">秒</lable>
               </div>
           </div>
       </div>
       <script src="js/jquery.min.js"></script>
       <script src="js/moment.js"></script>
       <script>
           var domTimeStamp = $('input#firstTimestamp'),domUtc8 = $('input#utc8');
           var resultTime = $('input[name=unixtimeresult1]'),resultUtc = $('input[name=unixtoutc8result]');
           var btnTime = $('input#unixtoutc8'), btnUtc= $('input#utc8tounix1');
           btnTime.on('click',function(){
               var _val = domTimeStamp.val().trim();
               if(_val.length == 0) return;
               if(_val > 10000000000) {
                   resultTime.val(moment(_val, "x").format("YYYY/MM/DD HH:mm:ss"));
               }else{
                   resultTime.val(moment(_val, "X").format("YYYY/MM/DD HH:mm:ss"));
               }

           });


           btnUtc.on('click',function(){
               var _val = domUtc8.val().trim();
               if(_val.length == 0) return;
               resultUtc.val(moment(_val,"YYYY/MM/DD HH:mm:ss").format("X"));
           });


       </script>
</div>
</body>
</html>