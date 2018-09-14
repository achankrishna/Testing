package com.services.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.services.convertorservice.CurrencyConvertorService;


public class CurrencyConvController {
	
	@Autowired
	CurrencyConvertorService CurrencyConvertorService;
	
	public String currConvertor(HashMap inputData) throws IOException{
		String result = null;
		result = CurrencyConvertorService.callCurrConvertorApi(inputData);
		return result;
	}

}
