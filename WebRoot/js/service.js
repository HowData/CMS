$(function(){
	//获取行业动态数据
	getData();
});
function getData(){
	$.post("dynamic/getService.do",function(obj){
		obj = JSON.parse(obj);
		var length = obj.data.length;
		var listCon = $("tbody",".am-table-compact");
		for(var i = 0;i<length;i++){
			$("<tr><td><img style='width:10em'src='"+ obj.data[i].imgUrl +"'/></td><td class='am-text-middle'>"+ obj.data[i].name +"</td><td class='am-text-middle'>"+ (obj.data[i].auth ? obj.data[i].auth : "admin") +"</td><td class='am-text-middle'>"+ (obj.data[i].releaseTime ? obj.data[i].releaseTime : "/") +"</td><td class='am-text-middle'><div class='tpl-table-black-operation'><a  style='margin: 0 3px' href='javascript:;'><i  style='margin: 0 3px' class='am-icon-pencil'></i>编辑</a><a class='tpl-table-black-operation-del'><i style='margin: 0 3px' class='am-icon-trash'></i>删除</a></div></td></tr>").appendTo(listCon);
		}
	})
}