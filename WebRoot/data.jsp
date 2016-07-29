<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="javax.servlet.http.HttpSession"%>
<%@ page language="java" import="xyz.baal.entity.Student"%>
<%@ page language="java" import="xyz.baal.dao.GetStudentInfoDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>学生信息</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="css/iconfont.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/base64.js"></script>
<style type="text/css">
a{cursor: pointer;}
a:link {color: #37a;text-decoration: none;}
a:visited {color: #666699;text-decoration: none;}
a:hover {color: #FFFFFF;text-decoration: none;background: #37a;}
a:active {color: #FFFFFF;text-decoration: none;background: #FF9933;}
.footer {padding: 20px;border-top: 1px solid #ddd;}
.panel-heading {padding: ;height: 46px;}
.table th {text-align: center;}
.table tbody td {text-align: center;}
thead tr .index {width: 10px;}
thead tr .stuno {width: 20%;}
thead tr .pswd {width: 20%;}
thead tr .name {width: 15%;}
thead tr .sex {width: 10%;}
thead tr .edit {width: 10%;}
thead tr .job {width: 10%;}
.page{text-align:center;}
.page .pagination{margin:0px;  text-align: center;}
</style>
</head>
<body>
	<%
		HttpSession ht = request.getSession();
		Student stu = (Student) ht.getAttribute("student");
		if (stu == null) {
			response.sendRedirect("index.jsp");
			return;
		} else {
			//	List<Student> list = (List<Student>) ht.getAttribute("list");
			//	request.setAttribute("list", list);
		}
	%>
	<div class="container">
		<br>
		<h1>学生信息表格</h1>
		<hr>
		<div class="panel panel-default">
			<div class="panel-heading"></div>
			<div class="panel-body">
				<table
					class="table table-hover table-striped table-bordered table-responsive"
					id="table">
					<thead>
						<tr>
							<th class="index">序号</th>
							<th class="stuno">学号</th>
							<th class="pswd">密码</th>
							<th class="name">姓名</th>
							<th class="sex">性别</th>
							<th class="edit">编辑</th>
							<th class="del">删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.students}" var="info"
							varStatus="vs">
							<tr class="active">
								<td>${info.id}</td>
								<td>${info.studentNo}</td>
								<td>${info.password}</td>
								<td>${info.studentName}</td>
								<td>${info.studentSex}</td>
								<td class="edit"><input data-toggle="modal"
									data-target="#myModal" id="${vs.index+1}"
									class="btn bt-sm btn-success radius" type="button" value="编辑"
									onclick="editInfo(this)" />
								</td>
								<td class="edit"><input id="${vs.index+1}"
									class="btn bt-sm btn-danger radius" type="button" value="删除"
									onclick="delInfo(this)" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="page" >				
					<ul class="pagination">
						<c:if test="${param.cur == 1}">
							<li><a >&laquo;</a></li>
						</c:if>
						<c:if test="${param.cur != 1}">
							<li><a href="login.do?cur=${param.cur - 1}">&laquo;</a></li>
						</c:if>
						<c:forEach var="i" begin="1" end="${requestScope.totalPage}" step="1">   
						  <li ><a  href="login.do?cur=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${param.cur == requestScope.totalPage}">
							<li><a >&raquo;</a></li>
						</c:if>
						<c:if test="${param.cur != requestScope.totalPage}">
							<li ><a href="login.do?cur=${param.cur + 1}">&raquo;</a></li>
						</c:if>
					
					</ul>
				</div>	
	</div>
</div>


		<a href="logout.do" style="float:right;">退出登陆</a>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="update" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改信息</h4>
					</div>
					<div class="modal-body">
						学号：<input type="text" name="stuno" id="stuno" readonly="true" />
						密码：<input type="text" name="pass" id="pass" /> <br />
						姓名：<input type="text" name="stuname" id="stuname" /> 
						性别：<input type="radio" name="sex" class="sex" id="man" value="男" />&nbsp;男&nbsp;&nbsp;&nbsp;
							<input type="radio" name="sex" class="sex" id="women" value="女" />&nbsp;女
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="update()">提交更改</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 模态框（Modal）end -->
	</div>

	<script type="text/javascript">
		function editInfo(obj) {
			var id = $(obj).attr("id");
			var stuno = document.getElementById("table").rows[id].cells[1].innerText;
			var pass = document.getElementById("table").rows[id].cells[2].innerText;
			var name = document.getElementById("table").rows[id].cells[3].innerText;
			var sex = document.getElementById("table").rows[id].cells[4].innerText;
			var b = new Base64();
			pass = b.decode(pass);
			$('#stuno').val(stuno);
			$('#pass').val(pass);
			$('#stuname').val(name);
			if (sex == '女') {
				document.getElementById('women').checked = true;
			} else {
				document.getElementById('man').checked = true;
			}
			$('#update').modal('show');
		}

		function update() {
			var stuno = $('#stuno').val();
			var pass = $('#pass').val();
			var name = $('#stuname').val();
			var sex = $('input:radio[name="sex"]:checked').val();
			$.ajax({
						type : "post",
						url : "update.do",
						data : "stuno=" + stuno + "&pass=" + pass + "&name="
								+ name + "&sex=" + sex,
						dataType : 'html',
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						success : function(result) {
							location.reload();
						}
					});
		}
		function delInfo(obj) {
			if (confirm("确认要删除？")) {
				var id = $(obj).attr("id");
				var stuNo = document.getElementById("table").rows[id].cells[1].innerText;
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
	</script>
</body>
</html>
