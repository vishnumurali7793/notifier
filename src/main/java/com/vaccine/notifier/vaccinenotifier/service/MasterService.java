package com.vaccine.notifier.vaccinenotifier.service;

import java.util.List;

import com.vaccine.notifier.vaccinenotifier.entities.District;
import com.vaccine.notifier.vaccinenotifier.entities.State;

import org.springframework.http.HttpEntity;

public interface MasterService {

    List<State> getStates(String url, HttpEntity<String> httpEntity);

    List<District> getDistrictsByState(String url, HttpEntity<String> httpEntity);
    
}
