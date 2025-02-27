package com.adrar.sqlcda.model;

public class Roles {

    private  Integer id;
    private String rolesName;

    public Roles(){
    }

    public Roles(String rolesName){
        this.rolesName = rolesName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }
}
