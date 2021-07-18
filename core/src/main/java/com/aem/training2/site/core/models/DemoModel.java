package com.aem.training2.site.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoModel {

    private static final Logger Log = LoggerFactory.getLogger(DemoModel.class);

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String path;

    @SlingObject
    ResourceResolver resolver;

    private List<ProductItem> list = new ArrayList<>();

    @PostConstruct
    protected void init() {
        Resource res = resolver.getResource(path);
        for (Resource childRes : res.getChildren()) {
            ValueMap map = childRes.getValueMap();
            ProductItem product = new ProductItem();

            product.setTitle(map.get("jcr:title", String.class));
            product.setSummary(map.get("summary", String.class));
            product.setRating(map.get("rating", String.class));

            list.add(product);
            Log.debug("list::{}", list);
        }
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public List<ProductItem> getList() {
        return list;
    }

}
