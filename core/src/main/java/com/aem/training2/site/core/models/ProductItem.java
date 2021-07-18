package com.aem.training2.site.core.models;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

public class ProductItem {

    private String summary;
    private String title;
    private String rating;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }






}
