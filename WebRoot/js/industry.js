$(function(){
	//获取行业动态数据
	getData();
});
function getData(){
	$.post("dynamic/getIndustry.do",function(obj){
		obj = JSON.parse(obj);
		var length = obj.data.length;
		var listCon = $("tbody","#example-r");
		for(var i = 0;i<length;i++){
			/*$("<tr class='gradeX'><td>"+ obj.data[i].title +"</td><td>"+ obj.data[i].auth ? obj.data[i].auth : "admin" +"</td><td>"+ obj.data[i].releaseTime +"</td><td><div class='tpl-table-black-operation'><a ><i class='am-icon-pencil'></i>编辑</a><a class='tpl-table-black-operation-del'><i class='am-icon-trash'></i>删除</a></div></td></tr>").appendTo(listCon);*/
			$("<tr class='gradeX'><td>"+ obj.data[i].title +"</td><td>"+ (obj.data[i].auth ? obj.data[i].auth : "admin") +"</td><td>"+ obj.data[i].releaseTime +"</td><td><div class='tpl-table-black-operation'><a  style='margin: 0 3px' href='javascript:;'><i  style='margin: 0 3px' class='am-icon-pencil'></i>编辑</a><a class='tpl-table-black-operation-del'><i style='margin: 0 3px' class='am-icon-trash'></i>删除</a></div></td></tr>").appendTo(listCon);
		}
	})
}