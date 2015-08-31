package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import controllers.AppConfig;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public List<Schedule> getSchedules() {
        
        RestClient client = null;
        try {
            client = AppConfig.getControllerInstance(RestClient.class);
            return client.get(play.Configuration.root().getString("rss.routeService.url"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ArrayList<Schedule>();
    }

}
