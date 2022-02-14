package com.aem.training2.site.core.models;

import com.aem.training2.site.core.interfaces.DemoOsgiInterface;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OsgiConfigurationModel {

    private static final Logger Log = LoggerFactory.getLogger(OsgiConfigurationModel.class);

    @OSGiService
    DemoOsgiInterface demoOsgi;

    private String serviceName;

    private String[] countriesName;

    private String runModesChoose;

    public String getServiceName() {
        return serviceName = demoOsgi.getServiceName();
    }

    public String[] getCountriesName() {
        return countriesName = demoOsgi.getCountries();
    }

    public String getRunModesChoose() {
        return runModesChoose = demoOsgi.getRunModes();
    }

}
