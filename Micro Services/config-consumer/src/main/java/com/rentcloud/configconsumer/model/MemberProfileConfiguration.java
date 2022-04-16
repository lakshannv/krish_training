package com.rentcloud.configconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileConfiguration {

    @Autowired
    Environment environment;

    public String getDefautModel(){
        return environment.getProperty("vehicle.default.model");
    }

    public String getMinRentPeriod(){
        return environment.getProperty("member.rent.min");
    }
}
