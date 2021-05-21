package com.vaccine.notifier.vaccinenotifier.controller;

import java.util.Date;

import com.vaccine.notifier.vaccinenotifier.entities.CenterResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    /**
     * SCHEDULER FOR FETCHING SLOT DETAILS -WEEKLY SLOT DETAILS FROM THE GIVEN TIME
     * @param 1 - districtId - Integer
     * @param 2 - date - String
     * SCHEDULER RUNS IN EVERY ONE MINUTE INTERVAL
     */
    //@Scheduled(cron = "0 */1 * * * *")
    public void schedulerForWeekWiseSlotCheck() {
        ResponseEntity<CenterResponse> responseEntity = null;
        SessionController sessionController = new SessionController();
        responseEntity = sessionController.getSessionDetailsByDistrictAndDateForWeek(303, "18-05-2021");
        if (responseEntity.getBody() != null) {
            System.out.println(responseEntity.getBody());
        }
        logger.info("Logger is running. Current time is: " + new Date());

    }
    
}
