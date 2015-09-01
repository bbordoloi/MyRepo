package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import controllers.AppConfig;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public List<Schedule> getSchedules() {
        
        RestClient client = null;
        try {
            client = AppConfig.getControllerInstance(RestClient.class);
            final String json = client.getJson(play.Configuration.root().getString("rss.routeService.url"));
            final List<Schedule> schedules = fromJSON(new TypeReference<List<Schedule>>() {}, json);
            if (schedules == null) {
            	play.Logger.error("schedules == null");
            }
        } catch (Exception e) {
            play.Logger.error(e.getMessage());
        }
        return new ArrayList<Schedule>();
    }
    
    private static <T> T fromJSON(final TypeReference<T> type, final String jsonPacket) {
  	   T data = null;

  	   try {
  	      data = new ObjectMapper().readValue(jsonPacket, type);
  	   } catch (Exception e) {
  		   play.Logger.error("exception in fromJSON = " + e.getMessage());
  	   }
  	   return data;
  	}

}
