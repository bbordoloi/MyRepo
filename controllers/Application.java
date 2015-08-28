package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.RouteService;
import play.*;
import play.mvc.*;

import views.html.*;
//import play.modules.spring.Spring;

@Component
public class Application extends Controller {

   
    @Autowired
    RouteService routeService;
    
    public Result index() {
        try {
        routeService = AppConfig.getControllerInstance(RouteService.class);
        } catch( Exception e) {
            return Results.internalServerError(e.toString());
        }

        return ok(index.render(routeService.getRoutes().toString()));
    }

}
