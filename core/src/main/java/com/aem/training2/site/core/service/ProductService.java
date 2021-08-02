package com.aem.training2.site.core.service;

import com.aem.training2.site.core.models.ProductItem;

import java.util.List;

public interface ProductService {
    public List<ProductItem> getProductList (String path);
}
