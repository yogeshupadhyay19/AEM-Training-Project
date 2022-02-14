package com.aem.training2.site.core.service;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;

public interface ReadDamDataService {
    public void readPdfFileData(SlingHttpServletRequest slingHttpServletRequest) throws LoginException;
}
