package restmethods;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ComplxeJson {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://run.mocky.io/v3/42b4de6b-e5a3-4611-a037-ab6e0646547d";
		
		Response rp = RestAssured.given().when().get();
		
		System.out.println(rp.asPrettyString());
		
		List<Integer>ids = rp.jsonPath().getList("id");
		System.out.println("IDs are "+ids);		
		
		
		List<String>ls3 = rp.jsonPath().getList("batters");
		System.out.println("List of batters  "+ls3);
		
		Map<String,Object> mp1 = rp.jsonPath().getMap("batters[0]");		
		
		System.out.println("First batters  "+mp1);
		
		List<Map<String,Object>> ls = rp.jsonPath().getList("batters");
		
		System.out.println("List of all batters "+ls);
		
		//List of batters
		List<String> batterslist = rp.jsonPath().getList("batters.batter");
		System.out.println("List of batters "+batterslist);
		
		//List of first batters
		List<String> batters = rp.jsonPath().getList("batters.batter[0]");
		System.out.println("List of first Batters are "+batters);
		
		//List of first batters
		List<String> batters3 = rp.jsonPath().getList("batters.batter[0].id");
		System.out.println("List of first Batters Id's are   "+batters3);		
		
		//
		List<Map<String,Object>> bats = rp.jsonPath().getList("batters.batter[0]");
		for(int i=0;i<bats.size();i++)
		{
			System.out.println("batterr id "+bats.get(i).get("id")+"  and it's type is  "+bats.get(i).get("type"));
		}
		
		List<Map<String,Object>> bats2 = rp.jsonPath().getList("batters.batter[1]");
		for(int i=0;i<bats2.size();i++)
		{
			System.out.println("batterr id "+bats2.get(i).get("id")+"  and it's type is  "+bats2.get(i).get("type"));
		}		

	}

}
