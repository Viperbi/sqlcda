package com.adrar.sqlcda.model;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class Task {

    private Integer id;
    private String title;
    private String content;
    private Date createAt;
    private Date endDate;
    private boolean status;
    private User user;
    private List<Category> categories;

    public Task(){}

    public Task(String title, String content, User user){
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
    }
}
