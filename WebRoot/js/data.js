function editInfo(obj) {
	var id = $(obj).attr("id");
	var stuNo = document.getElementById("table").rows[id].cells[0].innerText;
	$.ajax({
		type : "post",
		url : "updatebefore.do",
		data : "studentno=" + stuNo,
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(result) {
			result = eval(result);
			$("#stuno").val(result[0]["password"]);
		}
	});
}
function delInfo(obj) {
	if (confirm("确认要删除？")) {
		var id = $(obj).attr("id");
		var stuNo = document.getElementById("table").rows[id].cells[0].innerText;
		$.ajax({
			type : "post",
			url : "del.do",
			data : "studentno=" + stuNo,
			dataType : 'html',
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(result) {
				$(".table tr:eq(" + id + ")").remove();
			}
		});
	}
}