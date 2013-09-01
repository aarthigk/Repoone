package com.mask.servicetest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonParser {
	
/*	public static void main (String args[]) throws JSONException, MalformedURLException
	{
		JsonParser j= new JsonParser();
		j.Jsondata();
		
	}*/

	public List<String> Jsondata() throws JSONException, MalformedURLException
	{
		List <String> jdata = new ArrayList<String>();

		String jsonData="";
		BufferedReader br=null;
		try
		{
			String line;
			br= new BufferedReader(new FileReader("C:\\FirsrLevelRequestResponse.txt"));
			while ((line =br.readLine()) !=null)
			{
				jsonData += line + "\n";
				
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		JSONObject obk = new JSONObject(jsonData);
	//	System.out.println("Id"+""+"" + obk.getString("id"));
	//	System.out.println("Solution number"+""+""+ obk.getString("solutionNumber"));
		
		
	
		
		jdata.add(obk.getString("id"));
		jdata.add(obk.getString("customerName"));
	
	//	System.out.println(jdata);
		return jdata;
	}
	

	
}
