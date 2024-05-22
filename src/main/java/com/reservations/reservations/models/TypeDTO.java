package com.reservations.reservations.models;

public class TypeDTO {
    private String type;

    public TypeDTO(Type type){
        this.type = type.getType();
    }
    public TypeDTO() { }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
