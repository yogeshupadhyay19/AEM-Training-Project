package com.aem.training2.site.core.models;

import com.aem.training2.site.core.service.ProductService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductModel {

    private static final Logger Log = LoggerFactory.getLogger(ProductModel.class);

    @ValueMapValue
    private String path;

    @OSGiService
    ProductService service;

    private List<ProductItem> list = new ArrayList<>();

    @PostConstruct
    protected void init() {
        Log.debug("list::{}", list);
        Log.debug("path::{}", path);
        list = service.getProductList(path);
    }
    public String getPath() {
        return path;
    }

    public List<ProductItem> getList() {
        return list;
    }


}
