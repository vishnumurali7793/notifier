package com.vaccine.notifier.vaccinenotifier.controller;

import java.util.Arrays;

import com.vaccine.notifier.vaccinenotifier.entities.CenterResponse;
import com.vaccine.notifier.vaccinenotifier.entities.SessionResponse;
import com.vaccine.notifier.vaccinenotifier.service.EmailService;
import com.vaccine.notifier.vaccinenotifier.service.SessionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty( name = "scheduler.enabled", matchIfMissing = true)
public class ScheduledTasks {
    
    @Autowired
    SessionService sessionService;

    @Autowired
    EmailService emailService;

    @Value("${scheduler.districtId}")
    private Integer districtId;

    @Value("${scheduler.date}")
    private String date;

    private final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    public static final String USER_AGENTS = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.56";

    /**
     * SCHEDULER FOR FETCHING SLOT DETAILS -WEEKLY SLOT DETAILS FROM THE GIVEN TIME
     * @param 1 - districtId - Integer - fetching from application.properties file
     * @param 2 - date - String - fetching from application.properties file
     * SCHEDULER RUNS IN EVERY ONE MINUTE INTERVAL
     */

    @Scheduled(cron = "${scheduler.cronJob.week}")
    public void schedulerForWeekWiseSlotCheck() {
        // SETTING HTTP HEADERS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("Accept-Language", "en_US");
        httpHeaders.set("User-Agent", USER_AGENTS);

        // ADDING HEADER TO HTTP ENTITY
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        CenterResponse centerResponse = sessionService.getWeeklySessionsResponseFromAPI(null, httpEntity, districtId, date);

        if (centerResponse != null) {
            logger.info("RESPONSE GOT FROM API (WEEKLY): AVAILABLE CENTERS - " + centerResponse.getCenters().size());
        } else {
            logger.error("THERE IS AN ISSUE WITH THE CONNECTION (WEEKLY)");
        }

    }

    @Scheduled(cron = "${scheduler.cronJob.day}")
    public void schedulerForDailySlotCheck() {
        logger.info("Scheduler has been started for fetching slot details");
        // SETTING HTTP HEADERS
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.set("Accept-Language", "en_US");
        httpHeaders.set("User-Agent", USER_AGENTS);

        // ADDING HEADER TO HTTP ENTITY
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        SessionResponse sessionResponse = sessionService.getDailySessionsResponseFromAPI(null, httpEntity, districtId, date);

        if (sessionResponse != null) {
            logger.info("RESPONSE GOT FROM API (DAILY): AVAILABLE CENTERS - " + sessionResponse.getSessions().size());
            emailService.sendMail("XXXXXXXXXXXXX", "Email Service Test", "Test");
        } else {
            logger.error("THERE IS AN ISSUE WITH THE CONNECTION (DAILY)");
        }

    }
    
}
