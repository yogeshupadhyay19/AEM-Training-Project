package com.aem.training2.site.core.service.impl;

import com.aem.training2.site.core.models.ProductItem;
import com.aem.training2.site.core.service.ProductService;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = ProductService.class, immediate = true)

public class ProductServiceImpl implements ProductService {

    private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Reference
    ResourceResolverFactory factory;
    ResourceResolver resolver;

    @Override
    public List<ProductItem> getProductList(String path) {
        List<ProductItem> productList = new ArrayList<>();

        try {
            resolver = getResourceResolver("traininguser");
            Log.debug("Resolver::{}", resolver.getUserID());

            Resource res = resolver.getResource(path);

            Log.debug("resource::{}", res);

            for (Resource childRes : res.getChildren()) {

                ProductItem product = childRes.adaptTo(ProductItem.class);
                productList.add(product);
                Log.debug("Service Product list::{}", productList);
            }
        } catch (LoginException e) {
            e.printStackTrace();
        } finally {
            if (resolver.isLive()) {
                resolver.close();
            }
        }
        return productList;

    }


    public ResourceResolver getResourceResolver(String username) throws LoginException {
        Log.debug("userid1:{}", username);

        final Map<String, Object> authInfo = new HashMap<String, Object>();
        authInfo.put(ResourceResolverFactory.SUBSERVICE, username);
        resolver = factory.getServiceResourceResolver(authInfo);

        return resolver;
    }


}
 