package com.services.conversions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.services.controller.CurrencyConvController;
import com.services.data.CurrConvertorData;
import com.services.utilities.Constants;

public class CurrencyConvertors {
	
	
	CurrencyConvertors convertors;
	CurrencyConvController currConvController;
	CurrConvertorData currConvertorData;
	Constants constants;
	
	
	public static void main(String[] args) throws IOException {
		String result = null;
		Scanner sc = new Scanner(System.in).useDelimiter("\\s");
		System.out.println("Please enter the Currency Code:: ");
		//sc.nextLine();
		System.out.println("Please enter the Amount:: ");
		//sc.nextInt();
		System.out.println("Exchnge rate for "+sc.nextLine()+" is::"+sc.nextInt());
		
		CurrencyConvertors convertors =  new CurrencyConvertors();
		result = convertors.currConvert(sc.nextLine(), sc.nextInt());
		System.out.println("Result ::"+result);
	}
	
	public String currConvert(String currCode, double exeAmount) throws IOException{
		
		currConvertorData.setAmount(exeAmount);
		currConvertorData.setCurrCode(currCode);
		String result = null;
		if(!"".equalsIgnoreCase(currCode)){
			HashMap inputData = new HashMap();
			inputData.put("BASECURR", constants.BASE_CURR);
			inputData.put("CURRCODE", currCode);
			inputData.put("EXEAMOUNT", exeAmount);
			result = currConvController.currConvertor(inputData);
		}
		return result;
	}
	

}
