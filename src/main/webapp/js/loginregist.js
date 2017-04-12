         $(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');
				
				e.preventDefault();
			 });
			 
			});
			
			
			function checkUserForRegist(){
				var phone=$("#phone").val();
				var regex = new RegExp("1(3|4|5|7|8)\\d{9}");
	
				if(!regex.test(phone)) {
	                  $("#phoneMsg").text("手机号码格式有误");
	                  return false;
                }
                var phoneUrl=$("#phoneUrl").val();
                $.ajax({
                	type:"post",
                	url:phoneUrl,
                	data:"phone="+phone,
                	dataType:"text",
                	success: function(data) {
						$("#phoneMsg").text(data);
			    	}
                
                });
                
                return true;
			}
			
			function checkPassword() {
			var password = $("#registPasswrod").val();

			if(password.length < 6) { 

				$("#passwordMsg").text("密码长度大于等于6");
				return false;
			} 
			
			var confirmPassword = $("#confirmPassword").val();

			if(password != confirmPassword) {
				$("#passwordMsg").text("两次输入密码不一致");
				return false;
			}else{
				return true;
			}
			
		}
		
		
		function phoneMatchEmail(){
				var email=$("#pemail").val();
				var phone=$("#ephone").val();
                var phoneMatchEmailurl=$("#phoneMatchEmailurl").val();
                $.ajax({
                	type:"post",
                	url:phoneMatchEmailurl,
                	data:"phone="+phone+"&email="+email,
                	dataType:"text",
                	success: function(data) {
						$("#emailMsg").text(data);
						return false;
			    	}
                
                });    
			}
		