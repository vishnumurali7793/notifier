package com.vaccine.notifier.vaccinenotifier.service;

import com.vaccine.notifier.vaccinenotifier.entities.CenterResponse;
import com.vaccine.notifier.vaccinenotifier.entities.SessionResponse;

import org.springframework.http.HttpEntity;

public interface SessionService {

    CenterResponse getWeeklySessionsResponseFromAPI(String url, HttpEntity<String> httpEntity, Integer districtId, String date);

    SessionResponse getDailySessionsResponseFromAPI(String url, HttpEntity<String> httpEntity, Integer districtId, String date);
    
}
