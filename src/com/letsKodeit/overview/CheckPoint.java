package com.letsKodeit.overview;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CheckPoint {
	public static final Logger log = LogManager.getLogger(CheckPoint.class.getName());
	public static HashMap<String, String> resultMap = new HashMap<>();
	private static String PASS ="PASS";
	private static String FAIL ="FAIL";
	public static void clearHashMap(){
		log.info("Clearing results hash map");
		resultMap.clear();
	}
	private static void setStatus(String mapkey, String status){
		resultMap.put(mapkey, status);
		log.info(mapkey +" :-> " +resultMap.get(mapkey));
	}
	public static void mark(String testname, Boolean result, String resultMsg){
		testname = testname.toLowerCase();
		String mapkey = testname + "."+resultMsg;
		try{
			if(result){
				setStatus(mapkey, PASS);
			}else{
				setStatus(mapkey, FAIL);
			}
		}catch(Exception e){
			log.error("Exception occured...");
			setStatus(mapkey, FAIL);
			e.printStackTrace();
		}
	}
	public static void markFinal(String testname, Boolean result, String resultMsg){
		testname = testname.toLowerCase();
		String mapkey = testname + "."+resultMsg;
		try{
			if(result){
				setStatus(mapkey, PASS);
			}else{
				setStatus(mapkey, FAIL);
			}
		}catch(Exception e){
			log.error("Exception occured...");
			setStatus(mapkey, FAIL);
			e.printStackTrace();
		}
		ArrayList<String> resultList = new ArrayList<>();
		for(String key:resultMap.keySet()){
			resultList.add(resultMap.get(key));
		}
		for(int i=0;i<resultList.size();i++){
			if(resultList.contains(FAIL)){
				log.info("Test Method failed");
				Assert.assertTrue(false);
			}else {
				log.info("Test Method passed");
				Assert.assertTrue(true);
			}
		}
	}
}
