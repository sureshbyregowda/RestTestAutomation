package restmethods;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Postrequest {
	@Test(priority=2)
	public void postrequest() throws IOException, InterruptedException
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		/*String json ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		*/
		File jsonDatafile = new File("C:\\Users\\Boss\\August\\Automation\\Data\\API\\Input.json");
		RestAssured.given().body(jsonDatafile).when().post().then().log().all().assertThat().statusCode(201);

		/*HttpRequest req =	HttpRequest.newBuilder().GET().build();				
		HttpClient client = HttpClient.newBuilder().build();			
		HttpResponse rep = client.send(req,HttpResponse.BodyHandlers.ofString());
		*/
		
	}
	
	@Test(priority=1)
	public void pingIP() throws IOException
	{
		String ipAddress = "192.168.0.109";
	    InetAddress geek;
		try {
			geek = InetAddress.getByName(ipAddress);
		    System.out.println("Sending Ping Request to " + ipAddress); 
		    if (geek.isReachable(5000)) 
		      System.out.println("Host is reachable"); 
		    else
		      System.out.println("Sorry ! We can't reach to this host");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
