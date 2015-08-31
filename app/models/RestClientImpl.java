package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import play.libs.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value="RestClient")
public class RestClientImpl implements RestClient {

    private HttpClient client;
    
    public <T> List<Route> get(final String url) {
        
        client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
        	HttpResponse response = client.execute(request);
            return getJsonResponse(response);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       return null;
    }
    
    private <T> List<Route> getJsonResponse(final HttpResponse response) throws UnsupportedEncodingException, IllegalStateException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        for (String line = null; (line = reader.readLine()) != null;) {
            builder.append(line).append("\n");
        }
        //JsonNode value = Json.parse(builder.toString());
        List<Route> routes = fromJSON(new TypeReference<List<Route>>(){}, builder.toString());
        if (routes == null) {
        	System.out.println("routes == null");
        }
        return routes;
    }
    
    private static <T> T fromJSON(final TypeReference<T> type,
    	      final String jsonPacket) {
    	   T data = null;

    	   try {
    	      data = new ObjectMapper().readValue(jsonPacket, type);
    	   } catch (Exception e) {
    	      // Handle the problem
    		   System.out.println("exception in fromJSON = " + e.getMessage());
    	   }
    	   return data;
    	}
}
