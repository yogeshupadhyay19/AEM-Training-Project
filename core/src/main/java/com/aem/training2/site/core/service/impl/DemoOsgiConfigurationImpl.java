package com.aem.training2.site.core.service.impl;

import com.aem.training2.site.core.config.DemoCustomConfig;
import com.aem.training2.site.core.interfaces.DemoOsgiInterface;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;

@Component(service = DemoOsgiInterface.class, immediate = true)
@Designate(ocd = DemoCustomConfig.class)
public class DemoOsgiConfigurationImpl implements DemoOsgiInterface {

    private String serviceName;
    private String[] countries;
    private String runModes;

    @Activate
    protected void activate(DemoCustomConfig serviceConfig) {
        serviceName = serviceConfig.serviceName();
        countries = serviceConfig.getCountries();
        runModes = serviceConfig.getRunMode();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String[] getCountries() {
        return countries;
    }

    @Override
    public String getRunModes() {
        return runModes;
    }
}

