package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import play.api.libs.json.*;

@Component(value="RestClient")
public class RestClientImpl implements RestClient {

    private HttpClient client;
    
    public JsValue getRoutes() {
        
        client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(play.Configuration.root().getString("rss.routeService.url"));
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
    
    private JsValue getJsonResponse(final HttpResponse response) throws UnsupportedEncodingException, IllegalStateException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        for (String line = null; (line = reader.readLine()) != null;) {
            builder.append(line).append("\n");
        }
        JsValue value = Json.parse(builder.toString());
        return value;
    }
}
