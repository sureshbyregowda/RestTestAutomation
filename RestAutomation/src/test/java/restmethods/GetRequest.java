package restmethods;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetRequest {
	
	@Test(priority=-1)
	public void getRequestautomation()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Response rep11 = RestAssured.given().param("page",2).when().get();
		Response rep11 = RestAssured.given().when().get();
		//System.out.println("Response code "+rep.getStatusCode());
		//System.out.println("Response body "+rep.getBody().asString());
		//System.out.println("Content type "+rep.contentType());
		
		//System.out.println("Pretty print "+rep.prettyPrint());
		
		//JsonPath path = rep11.jsonPath();
		/*
		System.out.println(path.getString("total"));
		System.out.println(path.getString("data.id"));
		System.out.println(path.getString("data.email"));
		System.out.println(path.getString("data.first_name"));
		System.out.println(path.getString("data.last_name"));11
		
		List<Integer> ids = path.getList("data.id");
		//System.out.println("Ids from the response "+ids);
		 * 
		 * 
		*/
		
		System.out.println(rep11.jsonPath().getString("support.url"));
		Map<String,Object> mp = rep11.jsonPath().getMap("support");

		for(String k: mp.keySet())
		{
			System.out.println(k +"   it's value "+ mp.get(k));
		}
		
		for(Map.Entry<String, Object> entry : mp.entrySet())
		{
			System.out.println(entry.getKey() + "  "+ entry.getValue());
		}
		
		List<Map<String, Object>> ls2 = rep11.jsonPath().getList("data");		
		for(int j=0;j<ls2.size();j++)
		{
			if(ls2.get(j).containsValue("Weaver"))
			{
				System.out.println(ls2.get(j));
				System.out.println(ls2.get(j).get("last_name"));
				System.out.println(ls2.get(j).get("avatar"));
			}
		}
	}
	
	
	@Test(priority=0)
	public void getRequest()
	{
		
		RestAssured.baseURI="https://api.publicapis.org/entries";
		Response rep = RestAssured.given().when().get();
		
		Assert.assertEquals(rep.getStatusCode(), 200);
		//System.out.println("Response code "+rep.getStatusCode());
		//System.out.println("Response body "+rep.getBody().asString());
		
		System.out.println(rep.jsonPath().getInt("count"));
		
		
		//Get all links
		List<String> links = rep.jsonPath().getList("entries.Link");		
	//	System.out.println(links);
		
		//Get all Cors
		List<String> cors = rep.jsonPath().getList("entries.Cors");
		//System.out.println(cors);
		
		Iterator<String> itr = cors.iterator();
		for(String it: cors)
		{
			if(it.equalsIgnoreCase("yes"))
			{
				//System.out.println(it);
			}
		}
		
		List<Map<String,Object>> ls = rep.jsonPath().getList("entries");
		
		//System.out.println(ls);			
		
		for(int i=0;i<ls.size();i++)
		{
			if(ls.get(i).containsValue("yes"))
			{
				System.out.println(ls.get(i).get("Cors"));
				System.out.println(ls.get(i).get("Link"));
			}
		}
	}
	

/*	
{
	"count":1425,
	"entries":[
		{"API":"AdoptAPet","Description":"Resource to help get pets adopted","Auth":"apiKey","HTTPS":true,"Cors":"yes","Link":"https://www.adoptapet.com/public/apis/pet_list.html",Category":"Animals"},
		{"API":"Axolotl","Description":"Collection of axolotl pictures and facts","Auth":"","HTTPS":true,"Cors":"no","Link":"https://theaxolotlapi.netlify.app/","Category":"Animals"},	
	]
}
*/
}
