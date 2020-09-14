package com.fpoly.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentDto {
    @NotBlank
    private String comment;
    @NotNull
    private int collectionId;

    public String getComment() {
        return comment;
    }

    public int getCollectionId() {
        return collectionId;
    }
}
