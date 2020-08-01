<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<style type="text/css">
	body{
	
		background-color:#d0e4fe;
		background-image: url(pic/123.jpg);
	}
	.text{
		margin:10px;
		width: 100px;
		
	}
	.button{
		width:45px; 
		text-align: center;
	}
	#maindiv{
		margin:auto;
		margin-top:100px;
		text-align:center;
	}
	
</style>
<script type="text/javascript">
	$(document).ready(function(){
	  $(".button").click(function(){
	    $(this).hide();
	  });
	});
	function submit(){
		 
		 window.location.reload();
	}
</script>
</head>
<body>
<div id="maindiv">
	<input type="text" class="text"/></br>
	<input type="text" class="text"/></br>
	<input type="button" class="button" value="reset"/>
</div>
	<a href="#" >aaa</a>
</body>
</html>