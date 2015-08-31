package models;


import java.util.List;

//import play.api.libs.json.JsValue;

public interface RestClient {
   
    public <T> List<Route> get(final String url);

}
