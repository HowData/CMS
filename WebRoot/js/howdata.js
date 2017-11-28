$(function(){
	//获取火炬动态数据
	getData();
	var $modal = $('#my-modal');
	var iname = $("#hd-m-i-name");
	var iurl = $("#hd-m-i-url");
	var itime = $("#hd-m-i-time");
	iname.focus(function(){
		iname.removeClass("txtWarning");
	});
	iurl.focus(function(){
		iurl.removeClass("txtWarning");
	});
	itime.focus(function(){
		itime.removeClass("txtWarning");
	});
	 
	$("#hd-modal-add").click(function(){
		$modal.modal({
			dimmer : false
		});
	});
	$("#hd-cancel").click(function(){
		 $modal.modal('close');
	});
	//添加火炬动态信息
	$("#hd-confirm").click(function(){
		var nameval = $.trim(iname.val());
		var urlval = $.trim(iurl.val());
		var timeval = $.trim(itime.val());
		 if(nameval==""){
			 iname.addClass("txtWarning");
			 return;
		 }else if(urlval==""){
			 iurl.addClass("txtWarning");
			 return;
		 }else if(timeval==""){
			 itime.addClass("txtWarning");
			 return;
		 }else{
			 $.post("dynamic/addHuoju.do",JSON.stringify({
				 releaseTime : timeval,
				 title : nameval,
				 url : urlval
			 }),function(obj){
				 obj = JSON.parse(obj);
				 if(obj.code=="200"){
					 $modal.modal('close');
					 getData();
				 }else{
					 
				 }
			 });
		 }
	});
	
	//添加

});

function getData(){
	$.post("dynamic/getHouju.do",function(obj){
		obj = JSON.parse(obj);
		var length = obj.data.length;
		var listCon = $("tbody","#example-r");
		listCon.html("");
		for(var i = 0;i<length;i++){
			$("<tr class='gradeX' key='"+ obj.data[i].id +"'><td>"+ obj.data[i].title +"</td><td>"+ obj.data[i].url +"</td><td>"+ (obj.data[i].auth ? obj.data[i].auth : "admin") +"</td><td>"+ obj.data[i].releaseTime +"</td><td><div class='tpl-table-black-operation'><a  style='margin: 0 3px' href='javascript:;'><i  style='margin: 0 3px' class='am-icon-pencil'></i>编辑</a><a class='tpl-table-black-operation-del'><i style='margin: 0 3px' class='am-icon-trash'></i>删除</a></div></td></tr>").appendTo(listCon);
		}
		//删除按钮事件绑定
		$('.tpl-table-black-operation-del').click(function(){
			var id = $(this).parents(".gradeX").attr("key");
			 var $confirm = $('#my-confirm');
			 var $confirmBtn = $confirm.find('[data-am-modal-confirm]');
			  var $cancelBtn = $confirm.find('[data-am-modal-cancel]');
			  var $confirm = $('#my-confirm');
			  $confirm.modal("open"); 
			  var $confirmBtn = $confirm.find('[data-am-modal-confirm]');
			  var $cancelBtn = $confirm.find('[data-am-modal-cancel]');
			  $confirmBtn.off('click.confirm.modal.amui').on('click', function() {
	        	  $.post("dynamic/delHuoju.do",JSON.stringify({
	        		  idList : [id]
	        	  }),function(obj){
	        		  obj = JSON.parse(obj);
	 				 if(obj.code=="200"){
	 					getData();
					 }else{
						 
					 }
	        	  });
			  });
			  $cancelBtn.off('click.cancel.modal.amui').on('click', function() {
					
			  });
		});
	})
}