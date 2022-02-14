package com.aem.training2.site.core.servlets;


import com.aem.training2.site.core.service.ReadDamDataService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

    @Component(service= Servlet.class,
            property={
                    Constants.SERVICE_DESCRIPTION + "=Dam Servlet",
                    "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                    "sling.servlet.paths="+ "/bin/dam/training"})

    public class DamServlet extends SlingAllMethodsServlet {

        @Reference
        ReadDamDataService readDamDataService;

        private static final long serialVersionUID = 1L;
        private static final Logger Log = LoggerFactory.getLogger(com.aem.training2.site.core.servlets.DamServlet.class);
        @Override
        protected void doGet(final SlingHttpServletRequest req,
                              final SlingHttpServletResponse resp) throws ServletException, IOException {


            resp.getWriter().write("Dam servlet succesfull");
            try {
                readDamDataService.readPdfFileData(req);
            } catch ( LoginException e) {
                e.printStackTrace();
            }


        }
    }

