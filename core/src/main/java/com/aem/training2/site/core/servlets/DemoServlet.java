package com.aem.training2.site.core.servlets;


import com.aem.training2.site.core.models.ProductModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

   @Component(service=Servlet.class,
            property={
                    Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                    "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                    "sling.servlet.paths="+ "/bin/training",
                    "sling.servlet.selectors=" +"logindata"})

    public class DemoServlet extends SlingAllMethodsServlet {

        private static final long serialVersionUID = 1L;
       private static final Logger Log = LoggerFactory.getLogger(DemoServlet.class);
        @Override
        protected void doPost(final SlingHttpServletRequest req,
                             final SlingHttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        Log.debug("username::{}",name);
        Log.debug("password::{}",password);
       resp.getWriter().write("succesfull");


        }
    }


