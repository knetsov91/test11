package com.site.pathfinder2024.web;

import com.site.pathfinder2024.service.RouteService;
import com.site.pathfinder2024.service.dto.RouteShortInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * sa
 */


@Controller
public class  RouteController{


    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * Method to handle listi

     * @return the list route view
     */

    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDTO> routes = routeService.getAllRoutes();
        model.addAttribute("allRoutes", routes);
        return "routes";
    }
}
