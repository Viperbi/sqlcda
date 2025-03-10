package com.adrar.sqlcda.model;

public class Category {

    private Integer id;
    private String categoryName;

    public Category(){}

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
