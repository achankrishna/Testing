package com.services.convertorservice;

import java.util.HashMap;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyConvertorService {

	public String callCurrConvertorApi(HashMap inputData) throws IOException{
		double currAmount = (Double)inputData.get("EXEAMOUNT");
		String exeCurr = (String)inputData.get("CURRCODE");
		String baseCurr = (String)inputData.get("BASECURR");
		String result = null;
		/*String requestURL = new String("https://openexchangerates.org/api/convert/");
		//String requestURL = new String("https://openexchangerates.org/api/");
		requestURL+=(currAmount);
		requestURL+=("/");
		requestURL+=(baseCurr);
		requestURL+=("/");
		requestURL+=(exeCurr);
		requestURL+=("?app_id=62dcb89286e64c3ba57d38667b94658b");*/
		//requestURL+=("?app_id=62dcb89286e64c3ba57d38667b94658b");
		String requestURL = "https://openexchangerates.org/api/latest.json?app_id=62dcb89286e64c3ba57d38667b94658b";
		System.out.println(requestURL);
		URL url;
		try {
			url = new URL(requestURL);
		
		HttpURLConnection con =  (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("user-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = br.readLine()) !=null){
			response.append(inputLine);
		}
		System.out.println(response.toString());
		JSONObject json = new JSONObject();
		/*json.append("response", "27673.975864");
		JSONObject jobj = new JSONObject(json.toString());
		String str = json.toString();*/
		System.out.println(json.toString());
		//System.out.println(jobj.getString("response"));
		br.close();
		System.out.println("response.toString():::"+response.toString());
		
		JSONObject myResponse = new JSONObject(response.toString());
		JSONObject ratesObj = new JSONObject(myResponse.get("rates").toString());
		System.out.println("response.get(rates):::"+myResponse.get("rates"));
		System.out.println("response.get(rates) string:::"+ratesObj.get("FJD"));
		result = (String)ratesObj.get("FJD");
		//System.out.println(myResponse.getString("FJD"));
		System.out.println(myResponse);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		CurrencyConvertorService c = new CurrencyConvertorService();
		HashMap h = new HashMap();
		h.put("EXEAMOUNT", 5234.90);
		h.put("CURRCODE", "INR");
		h.put("BASECURR", "SGD");
		c.callCurrConvertorApi(h);
	}
}
