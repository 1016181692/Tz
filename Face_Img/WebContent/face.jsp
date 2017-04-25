<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
			<meta  http-equiv="Context-Type"  content="text/html"  charset="UTF-8">
			<title> Java开发人工智能扫一扫人脸识别系统--刘大帅</title>
			<meta name="Keywords" content="">
			<meta name="Description" content="">

			<style type="text/css">
				*{margin:0;padding:0;}
				body{background:#E6E6E6;font-size:12px;font-family:"微软雅黑";color:#666;}
				
				/* h1 start*/
				h1{line-height:80px;text-align:center;font-weight:300;color:#000000;}
				/*end   h1*/

				/*banner start*/
				.banner{width:100%;height:230px;background:url("img/001.jpg") top center;background-size:cover;}
				/*end banner*/

				/*upload start*/
				.upload{width:180px;height:36px;display:block;margin:30px auto;text-align:center;line-height:36px;text-decoration:none;font-size:16px;border-radius:20px;border:1px solid #00b4ff;color:00b4ff;}
 				.upload:hover{background:#00b4ff;color:#ffffff;}
				/*end  upload*/

				/*photo start*/
				.photo{width:800px;height:460px;margin:0 auto;}
				.photo .p_box{width:505px;height:460px;background:#ffcc99;float:left;position:relative;}
				.photo .p_value{width:290px;height:460px;background:#ffffff;float:right;}
				.photo .p_value h2{font-size:24px;font-weight:500;text-align:center;line-height:120px;}
				.photo .p_value  .p_info{font-size:16px;padding-left:35px;line-height:50px;}
				/*end  photo*/

				@-webkit-keyframes renlian {
						from {height:5px;}
						10% {height: 50px;}
						40% {height:100px;}
						50% {height:150px;}
						60% {height:250px;}
						80% {height:460px;}
						60% {height: 250px;}
						50% {height: 150px;}
						40% {height: 100px;}
						10% {height: 50px;}
						to {height: 0px;}
				}
				.scale{animation: renlian 1.5s  infinite ease; -webkit-animation:renlian 1.5s infinite ease;}
				.bs{position:absolute;background:green;width:505px;height:460px;top:0px ;left:0px;font-size:36px;text-align:center;line-height:400px;color:#fff;opacity:0.3}
				#file,#filename{display:none;}
		</style>
 </head>
 <body>
				<h1>Java开发人工智能扫一扫人脸识别系统</h1>

				<div class="banner"></div>

				<form action="upload.jsp"  method="post"  enctype="multipart/form-data"  id="arrayForm">
						<a href="javascript:;"  class="upload"  id="upload_btn">上传照片</a>
						<input  type="file"  id="file"  name="file"   onchange="saveFile();" />
						<input type="text"   id="filename" />
				</form>

				<div class="photo">
					<div class="p_box">
						<img src="${empty fileName ? 'img/002.jpg' : fileName}"  id="path"   alt="刘大帅"   width="505">
						<div class="bs  scale"></div>
				</div>
				<div class="p_value">
				<h2>人脸识别扫描结果：</h2>
				<p class="p_info"  id="p_message">
				<!-- 年龄：31岁(误差范围12岁)<br />
				性别：Male(正确率:99.99999%)<br />
				种族：White(正确率:78.4343%)<br />
				正在笑： 2.54574%-->
				</p> 
		</div>
</div>
<!---end photo-->

<script  type="text/javascript"  src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		//点击上传按钮 
		$("#upload_btn").click(function(){
			var ie = navigator.appName == "Microsoft Internet Explorer" ? true:false;
			if(ie){
				document.getElementById("file").click();
				document.getElementById("filename").value = document.getElementById("file").value;
			} else {
				var a= document.createEvent("MouseEvents");
				a.initEvent("click",true,true);
				document.getElementById("file").dispatchEvent(a);
				
			}
		});
		//执行人脸识别
		faceDo();
	});
	
	//上传图像
	function saveFile(){
		document.getElementById("arrayForm").submit();
	}
	
	//人脸识别
	function faceDo(){
		var msg = $("#path").attr("src");
		$.ajax({
			type:"post",	
			url:"faceData.jsp",
			data:{"path":msg},
			success:function(data){
				$("#p_message").prepend(data);
				$(".bs").removeClass().empty();
				
			}
		});
	}
</script>
  
 </body>
</html>