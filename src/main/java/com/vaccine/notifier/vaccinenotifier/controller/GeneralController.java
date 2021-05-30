package com.vaccine.notifier.vaccinenotifier.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.vaccine.notifier.vaccinenotifier.entities.District;
import com.vaccine.notifier.vaccinenotifier.entities.SessionResponse;
import com.vaccine.notifier.vaccinenotifier.entities.State;
import com.vaccine.notifier.vaccinenotifier.service.MasterService;
import com.vaccine.notifier.vaccinenotifier.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    @Autowired
    MasterService masterService;
    @Autowired
    SessionService sessionService;

    static final String USER_AGENTS = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.56";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");



    @RequestMapping("/")
    public String test() {
        return "app running...";
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        String url = "https://cdn-api.co-vin.in/api/v2/admin/location/states";
        ModelAndView modelAndView = new ModelAndView();

        // SETTING HTTP HEADERS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("Accept-Language", "en_US");
        httpHeaders.set("User-Agent", USER_AGENTS);
        
        // ADDING HEADER TO HTTP ENTITY
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        
        List<State> states = masterService.getStates(url, httpEntity);
        modelAndView.addObject("states", states);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/district")
    public ModelAndView getDistrictByState(@RequestParam Integer state) {
        String url = "https://cdn-api.co-vin.in/api/v2/admin/location/districts/" + state;
        ModelAndView modelAndView = new ModelAndView();

        // SETTING HTTP HEADERS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("Accept-Language", "en_US");
        httpHeaders.set("User-Agent", USER_AGENTS);

        // ADDING HEADER TO HTTP ENTITY
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

        List<District> districts = masterService.getDistrictsByState(url, httpEntity);
        modelAndView.addObject("districts", districts);
        modelAndView.setViewName("/master/district");
        return modelAndView;
    }

    @RequestMapping("/findSlotByDistrictAndDateDayWise")
    public ModelAndView getCenterResposeByDistrictAndDateDayWise(@RequestParam Integer district) {
        String today = simpleDateFormat.format(new Date());
        ModelAndView modelAndView = new ModelAndView();

        // SETTING HTTP HEADERS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("Accept-Language", "en_US");
        httpHeaders.set("User-Agent", USER_AGENTS);

        // ADDING HEADER TO HTTP ENTITY
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        SessionResponse sessionResponse = sessionService.getDailySessionsResponseFromAPI(null, httpEntity, district, today);
        if (sessionResponse != null && sessionResponse.getSessions().size() > 0) {
            modelAndView.addObject("slots", sessionResponse.getSessions());
        } else {
            modelAndView.addObject("slots", Collections.emptyList());
        }
        modelAndView.setViewName("/master/center");
        return modelAndView;
    }
    
}
