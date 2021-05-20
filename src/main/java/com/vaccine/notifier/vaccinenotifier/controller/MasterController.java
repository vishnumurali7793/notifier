package com.vaccine.notifier.vaccinenotifier.controller;


import java.util.Arrays;

import com.google.gson.Gson;
import com.vaccine.notifier.vaccinenotifier.entities.DistrictResponse;
import com.vaccine.notifier.vaccinenotifier.entities.StateResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MasterController {

    private final Logger logger = LoggerFactory.getLogger(MasterController.class);

    public static final String PRODUCTION_URL = "https://cdn-api.co-vin.in/api";
    public static final String USER_AGENTS = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.56";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;

    @RequestMapping(value = "/check-status", method = RequestMethod.GET)
    public String sayHello() {
        return "app running...";
    }

    @RequestMapping(value = "/master/states", method = RequestMethod.GET)
    public ResponseEntity<StateResponse> getStates() {
        StateResponse stateResponse = null;
        try {
            // BUILDING API URL
            String STATE_URL = new StringBuilder(PRODUCTION_URL).append("/v2/admin/location/states").toString();

            // SETTING HTTP HEADERS
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            httpHeaders.set("Accept-Language", "en_US");
            httpHeaders.set("User-Agent", USER_AGENTS);

            // ADDING HEADER TO HTTP ENTITY
            HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

            // CALLING API AND PARSING THE JSON RESPONSE TO STATE RESPONSE OBJECT
            stateResponse = gson.fromJson(restTemplate.exchange(STATE_URL, HttpMethod.GET, httpEntity, String.class).getBody(), StateResponse.class);
            logger.info("state information successfully received");
            return new ResponseEntity<StateResponse>(stateResponse, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("error occured while retrieving state data", e.getMessage());
            return new ResponseEntity<StateResponse>(new StateResponse(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/master/districts/{stateId}", method = RequestMethod.GET)
    public ResponseEntity<DistrictResponse> getDistricts(@PathVariable Integer stateId) {
        if (stateId != null && stateId > 0) {
            DistrictResponse districtResponse = null;
            try {
                // BUILDING API URL
                String DISTRICT_URL = new StringBuilder(PRODUCTION_URL)
                        .append("/v2/admin/location/districts/" + stateId).toString();

                // SETTING HTTP HEADERS
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                httpHeaders.set("Accept-Language", "en_US");
                httpHeaders.set("User-Agent", USER_AGENTS);

                // ADDING HEADER TO HTTP ENTITY
                HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

                // CALLING API AND PARSING THE JSON RESPONSE TO DISTRICT RESPONSE OBJECT
                districtResponse = gson.fromJson(
                        restTemplate.exchange(DISTRICT_URL, HttpMethod.GET, httpEntity, String.class).getBody(),
                        DistrictResponse.class);
                logger.info("district information successfully received");
                return new ResponseEntity<DistrictResponse>(districtResponse, HttpStatus.OK);
            } catch (Exception e) {
                logger.error("error occured while retrieving district data", e.getMessage());
                return new ResponseEntity<DistrictResponse>(new DistrictResponse(), HttpStatus.BAD_REQUEST);
            }

        } else {
            logger.error("error occured while retrieving district data");
            return new ResponseEntity<DistrictResponse>(new DistrictResponse(), HttpStatus.BAD_REQUEST); 
        }

    }
    
}
