package restmethods;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class Employee {

	public static void main(String[] args) throws SerializeException, ParseException {
		
		//Serialize - POJO to JSON
		JsonSerializer jsonserializer = JsonSerializer.DEFAULT_READABLE;
		
		String sellerNames[] = {"ABC", "Signigy", "Schneider"};
		
		product product = new product("Macbook", 200, "Blue", sellerNames);
		
	   String json = jsonserializer.serialize(product);
	   
	   System.out.println(json);
	   
	   //Serialize - Pojo to XML
	   XmlSerializer xmlserializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
	   String xml = xmlserializer.serialize(product);
	   System.out.println(xml);

	   //Deserialization -  JSON to POJO
	  JsonParser jsonparser = JsonParser.DEFAULT;
	  String jsonval = "{\r\n"
	  		+ "	\"color\": \"Blue\",\r\n"
	  		+ "	\"name\": \"Macbook\",\r\n"
	  		+ "	\"price\": 200,\r\n"
	  		+ "	\"sellerNames\": [\r\n"
	  		+ "		\"ABC\",\r\n"
	  		+ "		\"Signigy\",\r\n"
	  		+ "		\"Schneider\"\r\n"
	  		+ "	]\r\n"
	  		+ "}\r\n"
	  		+ "}";
	  
	  product pro1 = jsonparser.parse(jsonval, product.class);
	  System.out.println(pro1);
	  
	  
	}

}
