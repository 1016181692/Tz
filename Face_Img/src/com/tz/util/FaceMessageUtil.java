package com.tz.util;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.facepp.error.FaceppParseException;

/**
 * ����ʶ�𹤾���
 * @author navy
 *
 */
public class FaceMessageUtil {
	
	/**
	 * ͼ������ʶ�𹤾���
	 * 
	 * @author navy
	 * @param path�ļ�·��
	 * @return ������Ϣ
	 */

	public static String getFaceMessage(String path){
		
		StringBuffer buffer = new StringBuffer();
		try {
			//HttpRequests hrs = new HttpRequests("QjBbSKKraEf8vZ2qBp6P4N9SJze1GiPk","LTPi7QCxn-HW8hR7FP4jX2pg59iL_fSw");
			  HttpRequests hrs = new HttpRequests("231d813cda45f3f7a2db224b1eaa3b60","zwZcxwme8uXpw9EaUulCeK5PJFxjiEtV");

			//�������
			PostParameters pps = new PostParameters();
			pps = pps.setImg(new File(path));
		
			//�����������
			JSONObject json = hrs.detectionDetect(pps);
			JSONArray array = json.getJSONArray("face");
			
			
			for(int i= 0;i< array.length();i++){
				JSONObject jo = array.getJSONObject(i);
				
				JSONObject attrJson = jo.getJSONObject("attribute");
				
				//����
				JSONObject jsonAge = attrJson.getJSONObject("age");
				int range = jsonAge.getInt("range");
				int value = jsonAge.getInt("value");
				buffer.append("���䣺"+value+"��(��Χ��"+range+"��)<br />");
				
				//�Ա�
				String genderStr = attrJson.getJSONObject("gender").getString("value");
				int confidence = ((int)(attrJson.getJSONObject("gender").getDouble("confidence")*100))/100;
				buffer.append("�Ա�"+genderStr+"(��ȷ�ʣ�"+confidence+"%)<br />");
				
				//����
				String ethnicity = attrJson.getJSONObject("race").getString("value");
				int confidencer = ((int)(attrJson.getJSONObject("race").getDouble("confidence")*100))/100;
				buffer.append("���壺"+ethnicity+"(��ȷ�ʣ�"+confidencer+"%)<br />");
				
				//Ц
				int smile = ((int)(attrJson.getJSONObject("smiling").getDouble("value")*100))/100;;
				buffer.append("����Ц��" + smile+"%<br />");
				
			}
		
			} catch(Exception e){
				e.printStackTrace();
			}
		
		return buffer.toString();
	}
	
	
	
}
