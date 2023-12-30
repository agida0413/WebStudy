<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
  width:450px
}
.container{
margin-top:50px;

}

h1{
text-align:center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

<script type="text/javascript">
$(function(){
	$('#loginBtn').click(function(){
		let id=$('#id').val();
		if(id.trim()==""){
			$('#result').text('아이디를 입력하세요')
			let pwd =$('#pwd').val('');
		
			$('#id').focus();
			
			return;
		}
		else{
			let pwd =$('#pwd').val();
			if(pwd.trim()==""){
				$('#result').text('비밀번호를 입력하세요')
			
				$('#pwd').focus();
				return;
			}
			else{
				
			}
			$('#result').text('')
		}
		
		
	})
})
</script>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<div class="row">
		<table class="table">
			<tr>
				<th width=20% class="text-center">ID</th>
				<td width=80%>
					<input type="text" size=15 class="input-sm" id="id">
				</td>
			</tr>
			
			<tr>
				<th width=20% class="text-center">PWD</th>
				<td width=80%>
					<input type="password" size=15 class="input-sm" id="pwd">
				</td>
			</tr>
			
			<tr>
				<td colspan=2 class="text-center">
				<div style="color:red" id="result"></div>
				</td>
			</tr>
			<tr>
				<td colspan=2 class="text-center">
				<input type="button" class="btn-sm btn-danger" value="로그인" id="loginBtn">
				</td>
			</tr>
			
				
		</table>
	</div>
</div>

</body>
</html>