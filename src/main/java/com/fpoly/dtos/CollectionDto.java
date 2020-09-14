package com.fpoly.dtos;


import java.util.Date;

public class CollectionDto {

    private Date date;
    private String description;
    private String name;
    private boolean isPublic;


    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }


    public boolean isPublic() {
        return isPublic;
    }

}
