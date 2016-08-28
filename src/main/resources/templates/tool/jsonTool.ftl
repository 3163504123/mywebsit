<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="robots" content="all" />
    <meta name="author" content="minitcp.com" />

    <meta name="keywords" content="json,json在线解析,json格式化,json格式验证,json转xml,xml转json"/>
    <meta name="description" content="Json中文网致力于在中国推广Json,并提供相关的Json解析、验证、格式化、压缩、编辑器以及Json与XML相互转换等服务"/>   <meta charset="UTF-8">
    <title>MiniTcp</title>
    <#include "../common/common.ftl"/>
    <script src="js/jsonFormater.js"></script>
    <link href="css/jsonFormater.css" type="text/css" rel="stylesheet"/>
    <link href="css/json.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="container">
   <#include "../common/nav.ftl"/>
       <div class="HeadersRow">
           <h1 id="HeaderSubTitle">JSON格式化 </h1>
       </div>
       <div class="main-json">
           <div class="txt-wrapper">
				<textarea id="RawJson">
		    	{"number":1,"array":[],"null":null,"string":"leo108","boolean":true,"obj":{},"level1":{"level2":{"level3":{"level4":{"level5":{"level6":{"level7":{"level8":{}}}}}}}},"number":1,"array":[],"null":null,"string":"leo108"}
		    	</textarea>
           </div>
           <div class="rt-cont">
               <div id="ControlsRow">
                   <div>
                       <input type="Button" value="格式化" id='format' class="btn-json"/>
                   </div>
                   <div>
				    	<span id="TabSizeHolder">
						    缩进量
						    <select id="TabSize">
						        <option value="1">1</option>
						        <option value="2" selected>2</option>
						        <option value="3">3</option>
						        <option value="4">4</option>
						        <option value="5">5</option>
						        <option value="6">6</option>
						    </select>
						</span>
                   </div>
                   <div>
                       <input type="checkbox" id="QuoteKeys" checked='checked' />
                       <label for="QuoteKeys">
                           引号
                       </label>
                   </div>
                   <div>
                       <input type="checkbox" id="CollapsibleView" checked='checked' />
                       <label for="CollapsibleView">
                           显示控制
                       </label>
                   </div>
                   <div>
				    	<span id="CollapsibleViewDetail">
						    <a href="javascript:void(0);" id="expandAll">展开</a>
						    <a href="javascript:void(0);" id="collapseAll">叠起</a>
						    <a href="javascript:void(0);" class="expand" data-level="3">2级</a>
						    <a href="javascript:void(0);" class="expand" data-level="4">3级</a>
						    <a href="javascript:void(0);" class="expand" data-level="5">4级</a>
						    <a href="javascript:void(0);" class="expand" data-level="6">5级</a>
						</span>
                   </div>
                   <div>
                       <input type="Button" value="压缩" id='compress' class="btn-json""/>
                   </div>
               </div>
               <div id="right-box">
                   <div id="Canvas" class="Canvas"></div>
               </div>
           </div>
       </div>

       <script type="application/javascript">
           $(document).ready(function () {
               var format = function () {
                   var options = {
                       dom: '#Canvas',
                       isCollapsible: $('#CollapsibleView').prop('checked'),
                       quoteKeys: $('#QuoteKeys').prop('checked'),
                       tabSize: $('#TabSize').val()
                   };
                   window.jf = new JsonFormater(options);
                   jf.doFormat($('#RawJson').val());
               };
               $('#format').click(function () {
                   format();
               });
               $('#expandAll').click(function () {
                   window.jf.expandAll();
               });
               $('#collapseAll').click(function () {
                   window.jf.collapseAll();
               });
               $('#TabSize, #CollapsibleView, #QuoteKeys').change(function () {
                   format();
               });
               $('.expand').click(function () {
                   var level = $(this).data('level');
                   window.jf.collapseLevel(level);
               });
               $('#compress').click(function () {
                   var jsonObj=JSON.parse($('#RawJson').val());
                   $('#Canvas').html(JSON.stringify(jsonObj));
               })
           });
       </script>
</div>
</body>
</html>