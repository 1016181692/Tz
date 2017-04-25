package com.tz.util;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.facepp.error.FaceppParseException;

/**
 * 人脸识别工具类
 * @author navy
 *
 */
public class FaceMessageUtil {
	
	/**
	 * 图像人脸识别工具类
	 * 
	 * @author navy
	 * @param path文件路径
	 * @return 人脸信息
	 */

	public static String getFaceMessage(String path){
		
		StringBuffer buffer = new StringBuffer();
		try {
			//HttpRequests hrs = new HttpRequests("QjBbSKKraEf8vZ2qBp6P4N9SJze1GiPk","LTPi7QCxn-HW8hR7FP4jX2pg59iL_fSw");
			  HttpRequests hrs = new HttpRequests("231d813cda45f3f7a2db224b1eaa3b60","zwZcxwme8uXpw9EaUulCeK5PJFxjiEtV");

			//传入参数
			PostParameters pps = new PostParameters();
			pps = pps.setImg(new File(path));
		
			//传入参数解析
			JSONObject json = hrs.detectionDetect(pps);
			JSONArray array = json.getJSONArray("face");
			
			
			for(int i= 0;i< array.length();i++){
				JSONObject jo = array.getJSONObject(i);
				
				JSONObject attrJson = jo.getJSONObject("attribute");
				
				//年龄
				JSONObject jsonAge = attrJson.getJSONObject("age");
				int range = jsonAge.getInt("range");
				int value = jsonAge.getInt("value");
				buffer.append("年龄："+value+"岁(误差范围："+range+"岁)<br />");
				
				//性别
				String genderStr = attrJson.getJSONObject("gender").getString("value");
				int confidence = ((int)(attrJson.getJSONObject("gender").getDouble("confidence")*100))/100;
				buffer.append("性别："+genderStr+"(正确率："+confidence+"%)<br />");
				
				//种族
				String ethnicity = attrJson.getJSONObject("race").getString("value");
				int confidencer = ((int)(attrJson.getJSONObject("race").getDouble("confidence")*100))/100;
				buffer.append("种族："+ethnicity+"(正确率："+confidencer+"%)<br />");
				
				//笑
				int smile = ((int)(attrJson.getJSONObject("smiling").getDouble("value")*100))/100;;
				buffer.append("正在笑：" + smile+"%<br />");
				
			}
		
			} catch(Exception e){
				e.printStackTrace();
			}
		
		return buffer.toString();
	}
	
	
	
}
