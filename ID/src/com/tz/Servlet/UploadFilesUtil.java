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
 * ͼ���ϴ�������
 * @version 1.0
 * @author navy
 *
 */

public class UploadFilesUtil {
	
/**
 * �ļ��ϴ�������
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
				//�����ļ��ϴ�����
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				//�����ļ�������
				items = upload.parseRequest(request).iterator();
				while (items.hasNext()){
					FileItem item = (FileItem) items.next();
					//�ж�
				boolean	ite = item.isFormField();
				if(!ite){
					//�ļ���
					fileName = item.getName();
					//�����ϴ�Ŀ¼
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
		System.out.println("���Ϻã�");
	}

}
