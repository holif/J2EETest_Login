$(function(){
	
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});
	if(getParam("a")=='0')
	{
		$('#switch_login').trigger('click');
	}

	});
	
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  



// 用户注册部分
var reMethod = "post",pwdmin = 6;

$(document).ready(function() {


	$('#reg').click(function() {

		if ($('#studentno').val() == "") {
			$('#studentno').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×学号不能为空</b></font>");
			return false;
		}


		var sstudentno = /^[1-9]{1}[0-9]{9}$/;
		if (!sstudentno.test($('#studentno').val()) || $('#studentno').val().length != 10) {

			$('#studentno').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×学号为10位的数字</b></font>");
			return false;

		}
		/*var dataString = 'studentno=' + encodeURIComponent($("#studentno").val()) + 
						 '&passwd=' + encodeURIComponent($("#passwd").val()) + 
						 '&studentname=' + encodeURIComponent($("#studentname").val()) + 
						 '&sex=' + encodeURIComponent($('input:radio[name="sex"]:checked').val());  
		*/
		 var dataString= "studentno=" + $("#studentno").val() + 
		  				"&passwd=" + $("#passwd").val() + 
		  				"&studentname=" + $("#studentname").val() + 
		  				"&sex=" + $('input:radio[name="sex"]:checked').val();
		$.ajax({
			type: "post",
			url: "register.do",
			data: "studentno=" + $("#studentno").val() + 
				  "&passwd=" + $("#passwd").val() + 
				  "&studentname=" + $("#studentname").val() + 
				  "&sex=" + $('input:radio[name="sex"]:checked').val(),
			dataType: 'html',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			success: function(result) {

				if (result == "fail") {
					$('#studentno').focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});$("#userCue").html(result);
					return false;
				} else {
					$('#studentno').css({
						border: "1px solid #D7D7D7",
						boxShadow: "none"
					});
				}

			}
		});


		if ($('#passwd').val().length < pwdmin) {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
		
		if ($('#studentname').val()== "") {
			$('#studentname').focus();
			$('#userCue').html("<font color='red'><b>×姓名不能为空</b></font>");
			return false;
		}
		
		//var item = $('input[@name=sex][@checked]').val();   
		if ($('input:radio[name="sex"]:checked').val() == null) {
			//$('#sex').focus();
			$('#userCue').html("<font color='red'><b>×请选择性别</b></font>");
			return false;
		}
		
		$('#regUser').submit();
	});
	

});