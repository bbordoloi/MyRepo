package models;

import org.springframework.stereotype.Component;

import controllers.AppConfig;
import play.api.libs.json.JsValue;

@Component
public class RouteServiceImpl implements RouteService {

    @Override
    public JsValue getRoutes() {
        
        RestClient client = null;
        try {
            client = AppConfig.getControllerInstance(RestClient.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return client.getRoutes();
    }

}
