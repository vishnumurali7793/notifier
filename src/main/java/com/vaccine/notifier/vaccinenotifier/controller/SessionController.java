package com.vaccine.notifier.vaccinenotifier.controller;

import java.util.Arrays;

import com.google.gson.Gson;
import com.vaccine.notifier.vaccinenotifier.entities.CenterResponse;
import com.vaccine.notifier.vaccinenotifier.entities.SessionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final Logger logger = LoggerFactory.getLogger(SessionController.class);

    public static final String PRODUCTION_URL = "https://cdn-api.co-vin.in/api";
    public static final String USER_AGENTS = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.56";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;

    @RequestMapping(value = "/findByDateAndDistrict", method = RequestMethod.GET)
    public ResponseEntity<SessionResponse> getSessionDetailsByDistrictAndDate(@RequestParam Integer districtId, @RequestParam String date) {
        if (districtId != null && districtId > 0 && !date.equals("") && date.length() > 0) {
            SessionResponse sessionResponse = null;
            // BUILDING API URL
            String URL = new StringBuilder(PRODUCTION_URL)
                             .append("/v2/appointment/sessions/public/findByDistrict?district_id=")
                             .append(districtId)
                             .append("&date=")
                             .append(date)
                             .toString();

            // SETTING HTTP HEADERS
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            httpHeaders.set("Accept-Language", "en_US");
            httpHeaders.set("User-Agent", USER_AGENTS);

            // ADDING HEADER TO HTTP ENTITY
            HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

            // CALLING API AND PARSING THE JSON RESPONSE TO SESSION RESPONSE OBJECT
            sessionResponse = gson.fromJson(
                        restTemplate.exchange(
                            URL, 
                            HttpMethod.GET, 
                            httpEntity, 
                            String.class
                        ).getBody(), 
                            SessionResponse.class
                    );
            logger.info("session information successfully received");
            return new ResponseEntity<SessionResponse>(sessionResponse, HttpStatus.OK);
            
        } else {
            logger.error("error occured while retrieving session data");
            return new ResponseEntity<SessionResponse>(new SessionResponse(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/findWeeklySlotAvailability", method = RequestMethod.GET)
    public ResponseEntity<CenterResponse> getSessionDetailsByDistrictAndDateForWeek(@RequestParam Integer districtId, @RequestParam String date) {
        if (districtId != null && districtId > 0 && !date.equals("") && date.length() > 0) {
            CenterResponse centerResponse = null;
            // BUILDING API URL
            String URL = new StringBuilder(PRODUCTION_URL)
                             .append("/v2/appointment/sessions/public/calendarByDistrict?district_id=")
                             .append(districtId)
                             .append("&date=")
                             .append(date)
                             .toString();

            // SETTING HTTP HEADERS
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            httpHeaders.set("Accept-Language", "en_US");
            httpHeaders.set("User-Agent", USER_AGENTS);

            // ADDING HEADER TO HTTP ENTITY
            HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

            try {
                // CALLING API AND PARSING THE JSON RESPONSE TO SESSION RESPONSE OBJECT
                centerResponse = gson.fromJson(
                    restTemplate.exchange(
                        URL, 
                        HttpMethod.GET, 
                        httpEntity, 
                        String.class
                    ).getBody(), 
                        CenterResponse.class
                );
                logger.info("session information successfully received");
                return new ResponseEntity<CenterResponse>(centerResponse, HttpStatus.OK);
                
            } catch (Exception e) {
                logger.error("error occured while retrieving session data");
                return new ResponseEntity<CenterResponse>(new CenterResponse(), HttpStatus.BAD_REQUEST);
            }

        } else {
            logger.error("error occured while retrieving session data");
            return new ResponseEntity<CenterResponse>(new CenterResponse(), HttpStatus.BAD_REQUEST);
        }

    }
    
}
