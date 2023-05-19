package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {
	public List<HashMap<String, String>> getjsonDataToMap() throws IOException
	{
		String Jsoncontent=FileUtils.readFileToString(new File("C:\\Users\\LENOVO\\eclipse\\framework\\src\\test\\java\\rahulshettyacademy\\data\\purchaseorder.json"), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>>	data=mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}

}
