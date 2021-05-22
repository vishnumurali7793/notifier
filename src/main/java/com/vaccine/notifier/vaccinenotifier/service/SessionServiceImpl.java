package com.vaccine.notifier.vaccinenotifier.service;

import com.google.gson.Gson;
import com.vaccine.notifier.vaccinenotifier.entities.CenterResponse;
import com.vaccine.notifier.vaccinenotifier.entities.SessionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Gson gson;

    @Override
    public CenterResponse getWeeklySessionsResponseFromAPI(String url, HttpEntity<String> httpEntity, Integer districtId, String date) {
        String getUrl = "";
        if (districtId != null && districtId > 0 && !date.equals("") && date.length() > 0) {
            getUrl = new StringBuilder("https://cdn-api.co-vin.in/api")
                    .append("/v2/appointment/sessions/public/calendarByDistrict?district_id=").append(districtId)
                    .append("&date=").append(date).toString();
        } else {
            getUrl = url;
        }
        CenterResponse centerResponse = gson.fromJson(
                restTemplate.exchange(getUrl, HttpMethod.GET, httpEntity, String.class).getBody(),
                CenterResponse.class);
        return centerResponse;
    }

    @Override
    public SessionResponse getDailySessionsResponseFromAPI(String url, HttpEntity<String> httpEntity, Integer districtId, String date) {
        String getUrl = "";
        if (districtId != null && districtId > 0 && !date.equals("") && date.length() > 0) {
            getUrl = new StringBuilder("https://cdn-api.co-vin.in/api")
                    .append("/v2/appointment/sessions/public/findByDistrict?district_id=").append(districtId)
                    .append("&date=").append(date).toString();
        } else {
            getUrl = url;
        }
        SessionResponse sessionResponse = gson.fromJson(
                restTemplate.exchange(getUrl, HttpMethod.GET, httpEntity, String.class).getBody(),
                SessionResponse.class);
        return sessionResponse;
    }
    
}
