package com.vaccine.notifier.vaccinenotifier.service;

import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.vaccine.notifier.vaccinenotifier.entities.District;
import com.vaccine.notifier.vaccinenotifier.entities.DistrictResponse;
import com.vaccine.notifier.vaccinenotifier.entities.State;
import com.vaccine.notifier.vaccinenotifier.entities.StateResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MasterServiceImpl implements MasterService {

    Logger logger = LoggerFactory.getLogger(MasterServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Gson gson;

    @Override
    public List<State> getStates(String url, HttpEntity<String> httpEntity) {
        StateResponse stateResponse = null;
        try {
            stateResponse = gson.fromJson(restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody(), StateResponse.class);
            if (stateResponse != null && stateResponse.getStates().size() > 0) {
                return stateResponse.getStates();
            }
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<District> getDistrictsByState(String url, HttpEntity<String> httpEntity) {
        DistrictResponse districtResponse = null;
        try {
            districtResponse = gson.fromJson(
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody(),
                    DistrictResponse.class);
            if (districtResponse != null && districtResponse.getDistricts().size() > 0) {
                return districtResponse.getDistricts();
            }
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    
}
