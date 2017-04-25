package com.tz.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;




/**
 * ���֤ʶ�𹤾���
 * @author navy
 *
 */

public class IdQuery extends HttpServlet{
	
	/**
	 * 
	 * 
	 */
	/*public static final String APP_ID = "9526760";
	public static final String API_KEY ="EeARnZVNUK8mMxx3FupCYR8j";
	public static final String 	SECRET_KEY ="o1CooOgPhuzzaq2I4oMx5GjBGrg0D72H";*/
	
	public static final String APP_ID = "9389343";
	public static final String API_KEY ="9FfcAkwQ9pBWgYO4vmfdOf31";
	public static final String 	SECRET_KEY ="XQMyp7ZYp1D99XCrzPxB7bTjPEOSGYwr";
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) {
		
		String path = request.getParameter("path");
		String realpath = request.getRealPath(path);
		System.out.println(realpath);
		String result = getResult(realpath);
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
		
		public static String getResult(String imagePath){
			
			AipOcr client = new AipOcr(APP_ID,API_KEY,SECRET_KEY);
			boolean isFront = true;
			HashMap<String,String> options = new HashMap<String,String>();
			
			JSONObject result = client.idcard(imagePath, isFront, options);
			System.out.println(result);
			return result.toString();
		}
		
		public static void main(String[] args) {
			System.out.println(getResult("E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\ID\\img\\002.png"));
		}
		
		/*String getAccessTokenUrl = authHost
                // 1. grant_typeΪ�̶�����
                + "grant_type=client_credentials"
                // 2. ������ȡ�� API Key
                + "&client_id=" + clientId
                // 3. ������ȡ�� Secret Key
                + "&client_secret=" + clientSecret;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // �򿪺�URL֮�������
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // ��ȡ������Ӧͷ�ֶ�
            Map<String, List<String>> map = connection.getHeaderFields();
            // �������е���Ӧͷ�ֶ�
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // ���� BufferedReader����������ȡURL����Ӧ
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            *//**
             * ���ؽ��ʾ��
             *//*
            System.out.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.out.printf("��ȡtokenʧ�ܣ�");
            e.printStackTrace();
        }
        return null;
    }*/
}
