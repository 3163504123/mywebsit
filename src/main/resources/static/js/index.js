$(function() { 
	function init(){
		var title = $('.listDiv li .art-txt h4 a'),maxVal=30;		
		title.each(function(){
			var val = $(this).html().trim();
			if(getBytesCount(val) > maxVal){					
				$(this).html(val.substring(0,getBytes(val,maxVal))+'...');
			}
		});		
		
	}
	init()
	
	/*统计中英文数量*/
	function getBytesCount(str) {
	    var bytesCount = 0;
	    for (var i = 0; i < str.length; i++) {
	        var c = str.charAt(i);
	        if (/^[\u0000-\u00ff]$/.test(c)) //匹配双字节
	        {
	            bytesCount += 0.5;
	        }
	        else {
	            bytesCount += 1;
	        }
	
	    }
	    return bytesCount;
	}
	/*查找指定位置序号*/
	function getBytes(str, maxVal) {
	    var bytesCount = 0;
	    for (var i = 0; i < str.length; i++) {
	        var c = str.charAt(i);
	        if (/^[\u0000-\u00ff]$/.test(c)) //匹配双字节
	        {
	            bytesCount += 0.5;
	        }
	        else {
	            bytesCount += 1;
	        }
	        if (bytesCount > maxVal) {
	            return i;
	            break;
	        }
	    }
	}
})