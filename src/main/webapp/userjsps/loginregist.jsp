<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>登录页面</title>
	   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
	   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
		
		
  </head>
  
  <body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									
								</h1>
								<h4 class="blue" id="id-company-text">&copy; <a href="<c:url value='/showSnacks.html?page=1'/>">小吃货零食商店</a></h4>
							</div>
							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												请输入您的信息
											</h4>

											<div class="space-6"></div>

											<form action="<c:url value='/user/login.html'/>" method="post">
											
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="phone" value="${cookie.cookiePhone.value }"  class="form-control" placeholder="手机号码" required/>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" class="form-control" placeholder="密码" required/>
															<span style="color: red">${loginMsg }</span>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="verifycode" class="form-control" placeholder="验证码" required />
															<img id="image" src="<c:url value='/user/verifyCode.html'/>"/><a href="javascript:void(0)" onclick="verifycode_change('<c:url value='/user/verifyCode.html'/>')">看不清楚</a>
															<span style="color: red">${verifycodeMsg }</span>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" name="checkbox" checked="checked"/>
															<span class="lbl"> 记住手机号</span>
														</label>

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">登录</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													忘记密码(重置)
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													注册
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i>
												找回密码
											</h4>

											<div class="space-6"></div>
											<p>
												输入您的电子邮件和接收指令
											</p>
											<span style="color: red" id="emailMsg"></span>
											<form action="<c:url value='/user/email.html'/>" method="post">
												<fieldset>
												<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="ephone"  name="phone" class="form-control" placeholder="手机号码" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email"  id="pemail"  name="email" class="form-control" placeholder="邮箱"  onblur="return phoneMatchEmail()"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="submit" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="ace-icon fa fa-lightbulb-o"></i>
															<span class="bigger-110">发送邮件</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												返回登录
												<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												用户注册
											</h4>

											<div class="space-6"></div>
											<p>填写信息: </p>

											<form action="<c:url value='/user/regist.html'/>" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="phone" id="phone" class="form-control" placeholder="手机号码" required onblur="return checkUserForRegist()"/>
															<span style="color: red" id="phoneMsg"></span>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" class="form-control" placeholder="用户名" required/>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="registPasswrod"  name="password" class="form-control" placeholder="密码" required/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="confirmPassword" class="form-control" placeholder="确认密码" required onblur="checkPassword()"/>
															<span style="color: red" id="passwordMsg"></span>
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" name="email"  class="form-control" placeholder="邮箱(密码找回)" required />
															<span style="color: red" id="phoneMsg"></span>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
														<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="verifycode" type="text" name="verifycode" class="form-control" placeholder="验证码" required onblur="return check_verifycode('<c:url value='/user/regist_check_verifycode.html'/>')"/>
															<img id="registimage" src="<c:url value='/user/verifyCode.html'/>"/><a href="javascript:void(0)" onclick="regist_verifycode_change('<c:url value='/user/verifyCode.html'/>')">看不清楚</a>
															<span style="color: red" id="regist_verifycodeMsg"></span>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">重置</span>
														</button>

														<button type="submit" class="width-65 pull-right btn btn-sm btn-success" onclick="return check_verifycode('<c:url value='/user/regist_check_verifycode.html'/>')">
															<span class="bigger-110">注册</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												返回登录
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative -->

							<div class="navbar-fixed-top align-right">
								<br />
								&nbsp;
								<a id="btn-login-dark" href="#">Dark</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-blur" href="#">Blur</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-light" href="#">Light</a>
								&nbsp; &nbsp; &nbsp;
							</div>
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<script src="${pageContext.request.contextPath}/assets/js/jquery.2.1.1.min.js"></script>


		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>


		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/loginregist.js"></script>
		<input type="hidden" id="phoneUrl" value="<c:url value='/user/checkUserForRegist.html'/>"/>
		<input type="hidden" id="phoneMatchEmailurl" value="<c:url value='/user/phoneMatchEmail.html'/>"/>
		
		<script type="text/javascript">
	    function verifycode_change(url) {
	  
		$("#image").attr('src',url+"?a=" + new Date().getTime()); 	
		
	}
	
	 function regist_verifycode_change(url) {
	  
		$("#registimage").attr('src',url+"?a=" + new Date().getTime()); 	
		
	}
	
	function check_verifycode(url) {
		var verifycode = $("#verifycode").val();
		$.ajax({
			type:"get",
			url:url + "?verifycode=" + verifycode,
			dataType:"text",
            success: function(data) {
		       $("#regist_verifycodeMsg").text(data);
				return false;
			  }
		
		});
	}
		
	</script>
	</body>
</html>
