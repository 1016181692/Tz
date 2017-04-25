package com.tz.Servlet;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * 图像上传工具类
 * @version 1.0
 * @author navy
 *
 */

public class UploadFilesUtil {
	
/**
 * 文件上传工具类
 * @author navy
 * @param <HttpServletRequest>
 * @param <HttpServletResponse>
 * @param request
 * @param response
 * @return
 */
	public static String  uploadFiles(HttpServletRequest request,HttpServletResponse response){
	
		String fileName = null;
		Iterator items = null;
			
		try {
			request.setCharacterEncoding("UTF-8");
			boolean bol = ServletFileUpload.isMultipartContent(request);
			if(bol) {
				//构建文件上传对象
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				//创建文件迭代器
				items = upload.parseRequest(request).iterator();
				while (items.hasNext()){
					FileItem item = (FileItem) items.next();
					//判断
				boolean	ite = item.isFormField();
				if(!ite){
					//文件名
					fileName = item.getName();
					//定义上传目录
					String filePath = request.getRealPath("upload");
					File file = new File(filePath);
					if(!file.exists()){
						file.mkdirs();
					}
					File uploadFile = new File(filePath+"\\"+fileName);
					item.write(uploadFile);
				}
			}
		}
			System.out.println(fileName);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{}
	}

	
	
	
	
	public static void main(String[] args)
	{
		System.out.println("早上好！");
	}

}
