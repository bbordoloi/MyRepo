package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.Route;
import models.RouteService;
import play.mvc.*;
import views.html.*;
//import play.modules.spring.Spring;

@Component
public class Application extends Controller {
 
    @Autowired
    private RouteService routeService;
    private int pageSize = play.Configuration.root().getInt("rss.routeService.ui.pageSize");
    public Result routes( final int page ) {
    	
        try {
        routeService = AppConfig.getControllerInstance(RouteService.class);
        } catch( Exception e) {
            return Results.internalServerError(e.toString());
        }

        List<Route> routes = routeService.getRoutes();
        System.out.println("emp#: " + routes.get(0).employeeNumber);
		return ok(index.render(routes, routes.get(0).routeDate, page, Math.ceil(routes.size() / pageSize), pageSize));
    }

}
