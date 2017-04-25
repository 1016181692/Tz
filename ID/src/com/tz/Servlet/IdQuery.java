package com.tz.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;




/**
 * 身份证识别工具类
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
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + clientId
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + clientSecret;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            *//**
             * 返回结果示例
             *//*
            System.out.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.out.printf("获取token失败！");
            e.printStackTrace();
        }
        return null;
    }*/
}
