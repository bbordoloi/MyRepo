package models;


import java.util.List;

//import play.api.libs.json.JsValue;

public interface RestClient {
   
    public <T> List<Schedule> get(final String url);

}
