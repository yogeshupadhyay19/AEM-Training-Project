package com.aem.training2.site.core.service;

import com.aem.training2.site.core.models.ProductItem;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.List;

public interface ProductService {
    public List<ProductItem> getProductList (String path);
    public ResourceResolver getResourceResolver(String username) throws LoginException;
}
