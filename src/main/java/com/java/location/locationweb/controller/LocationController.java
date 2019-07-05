package com.java.location.locationweb.controller;

import com.java.location.locationweb.entites.Location;
import com.java.location.locationweb.service.LocationService;
import com.java.location.locationweb.util.EmailService;
import com.java.location.locationweb.util.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private ServletContext sc;

    @RequestMapping("/showCreate")
    public String showCreate() {
        System.out.println("I am trigger");
        return "createlocation";
    }

    @PostMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location save successfully with Id : " + location.getId();
        modelMap.addAttribute("msg", msg);
        emailService.sendEmail("sameernewar666@gmail.com", "Location Saved", msg);
        return "createlocation";
    }

    @PostMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        locationService.updateLocation(location);

        List<Location> locations = locationService.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @GetMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @GetMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);

        List<Location> locations = locationService.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Location> optionalLocation = locationService.getLocationById(id);
        modelMap.addAttribute("location", optionalLocation.get());
        return "editLocation";
    }

    @GetMapping("/generateReport")
    public String getnerateReport() {
        String path = sc.getRealPath("/");
        List<Object[]> objects = locationService
                .findTypeAndTypeCount();
        reportService.generatePieChart(path, objects);
        return "report";
    }

}
