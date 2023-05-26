package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class parsedynamicjson {
	//How to parse Dynamic json
	//How to parse nested json	
	
	public static void parseObject(JSONObject json, String key)
	{
		System.out.println(json.has(key));
		System.out.println(json.get(key));
	}
	
	public static void getKey(JSONObject json, String key)
	{
		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;
		
		if(!exists)
		{
			keys = json.keys();
			while(keys.hasNext())
			{
				nextKeys = (String) keys.next();
				try
				{	
					if(json.get(nextKeys) instanceof JSONObject)
					{
						if(exists =false)
						{
							getKey(json.getJSONObject(nextKeys),key);
						}
						
					}
					else if(json.get(nextKeys) instanceof JSONArray)
					{
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for(int i=0;i<jsonarray.length();i++)
						{
							String jsonArrayString =jsonarray.get(i).toString();
							
							JSONObject innerjson = new JSONObject(jsonArrayString);
							if(exists == false)
							{
								getKey(innerjson,key);
							}
						}
					}
					
				}catch(Exception e)
				{
					
				}
			}
			
		}
		else
		{
			parseObject(json,key);
		}
	}
	
	public static void main(String[] args)
	{
		String inputJson = "{\r\n"
				+ "    \"page\": 2,\r\n"
				+ "    \"per_page\": 6,\r\n"
				+ "    \"total\": 12,\r\n"
				+ "    \"total_pages\": 2,\r\n"
				+ "    \"data\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 7,\r\n"
				+ "            \"email\": \"michael.lawson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Michael\",\r\n"
				+ "            \"last_name\": \"Lawson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 8,\r\n"
				+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
				+ "            \"first_name\": \"Lindsay\",\r\n"
				+ "            \"last_name\": \"Ferguson\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 9,\r\n"
				+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
				+ "            \"first_name\": \"Tobias\",\r\n"
				+ "            \"last_name\": \"Funke\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 10,\r\n"
				+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
				+ "            \"first_name\": \"Byron\",\r\n"
				+ "            \"last_name\": \"Fields\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 11,\r\n"
				+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
				+ "            \"first_name\": \"George\",\r\n"
				+ "            \"last_name\": \"Edwards\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 12,\r\n"
				+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
				+ "            \"first_name\": \"Rachel\",\r\n"
				+ "            \"last_name\": \"Howell\",\r\n"
				+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"support\": {\r\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		JSONObject json = new JSONObject(inputJson);
		
		getKey(json,"id");
		getKey(json,"email");
	}

}
