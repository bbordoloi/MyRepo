package models;


import play.api.libs.json.JsValue;

public interface RestClient {
    
    public JsValue getRoutes();
}
