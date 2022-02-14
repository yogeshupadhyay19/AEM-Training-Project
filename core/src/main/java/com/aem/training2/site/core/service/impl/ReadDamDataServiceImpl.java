package com.aem.training2.site.core.service.impl;


import com.aem.training2.site.core.service.ProductService;
import com.aem.training2.site.core.service.ReadDamDataService;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;


@Component(service = ReadDamDataService.class, immediate = true)
public class ReadDamDataServiceImpl implements ReadDamDataService {

    private static final Logger Log = LoggerFactory.getLogger(ReadDamDataServiceImpl.class);

    @Reference
    ProductService productService;

    @Override
    public void readPdfFileData(SlingHttpServletRequest slingHttpServletRequest) {
        try {
            Log.debug("DamData");
            ResourceResolver resourceResolver = productService.getResourceResolver("traininguser");
            Resource resource = resourceResolver.getResource("/content/dam/training-batch2/yogesh.xlsx/jcr:content/renditions/original");
            Log.debug("Resource name::{}", resource.getName());
            Log.debug("Resource path::{}", resource.getPath());
            CSVReader csvReader = null;
            try {
                csvReader = new CSVReader(new FileReader(resource.getPath()));
                String[] value;
                while ((value = csvReader.readNext()) != null) {
                    System.out.println(value[0] + " " + value[1] + " " + value[2]);
                    Log.debug("Excel file value::{}", value[0] + " " + value[1] + " " + value[2]);
                }
            } catch (IOException e) {
                System.out.println(e);
            } catch (CsvValidationException e) {
                e.printStackTrace();
            }

        } catch (LoginException e) {
            Log.debug("Exception::{}", e);
        }


    }


}







