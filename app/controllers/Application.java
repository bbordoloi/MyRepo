package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.Schedule;
import models.ScheduleService;
import play.mvc.*;
import views.html.*;
//import play.modules.spring.Spring;

@Component
public class Application extends Controller {
 
    @Autowired
    private ScheduleService scheduleService;
    private int pageSize = play.Configuration.root().getInt("rss.routeService.ui.pageSize");
    public Result schedules(final int page ) {
    	
        try {
        scheduleService = AppConfig.getControllerInstance(ScheduleService.class);
        } catch( Exception e) {
            return Results.internalServerError(e.toString());
        }

        final List<Schedule> schedules = scheduleService.getSchedules();
        play.Logger.info("#schedules: " + schedules.size());
		return ok(index.render(schedules, schedules.get(0).routeDate, page, (int)Math.ceil(((double)schedules.size()) / pageSize), pageSize));
    }

}
