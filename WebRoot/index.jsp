<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>后台登陆</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>

<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>后台登陆<sup>V2016</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    

            <!--ç»å½-->
            <div class="web_login" id="web_login">
               
               
            <div class="login-box">
    
            
			<div class="login_form">
						<form action="login.do" name="loginform" accept-charset="utf-8"
							id="login_form" class="loginForm" method="post">
							<input type="hidden" name="did" value="0" /> <input type="hidden"
								name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">学号</label>
								<div class="inputOuter" id="uArea">

									<input type="text" id="u" name="studentno" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="password"
										class="inputstyle" />
									<input type="hidden" name="cur" value="1" />
								</div>
							</div>

							<div style="padding-left:50px;margin-top:20px;">
								<input type="submit" value="登 录" style="width:150px;"
									class="button_blue" />
							</div>

						</form>
					</div>
           
            	</div>
               
            </div>
            <!--login end-->
  </div>

  <!--register start-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login">
	<form name="form2" id="regUser" accept-charset="utf-8"  action="" method="post">
	    <input type="hidden" name="to" value="reg"/>
		<input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册请注意格式</div>
                <li>
                	
                    <label for="user"  class="input-tips2">学号</label>
                    <div class="inputOuter2">
                        <input type="text" id="studentno" name="studentno" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="passwd" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                <li>
                <label for="user" class="input-tips2">姓名</label>
                    <div class="inputOuter2">
                        <input type="text" id="studentname" name="" maxlength="16" class="inputstyle2" />
                    </div>
                    
                </li>
                
                <li>
                <label for="sex" class="input-tips2">性别</label>
                <div class="inputOuter2">	
                    <input type="radio" id="sex" value="男" name="sex"  class="radiostyle"/><span>男</span>
					<input type="radio" id="sex" value="女" name="sex"  class="radiostyle"/><span>女</span>
                </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="    确认并注册    "/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
           
    
    </div>
   
    
    </div>
    <!--register end-->
</div>
<div class="jianyi">*建议使用Chrome内核浏览器访问本站</div>
</body></html>