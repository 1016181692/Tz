<%@ page language="java" import="java.util.*,com.tz.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fileName = UploadFilesUtil.uploadFiles(request, response);
	if(null != fileName) {
		session.setAttribute("fileName", "upload/" +fileName);
		response.sendRedirect("face.jsp");
	}

%>
