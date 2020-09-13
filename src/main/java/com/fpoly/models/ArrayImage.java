package com.fpoly.models;

import javax.persistence.*;

@Entity
@Table(name = "arrayImage")
public class ArrayImage {

    @Id
    private int id;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "frameId")
    private Frame frame;

    public ArrayImage() {
    }

    public ArrayImage(int id, String imageUrl, Frame frame) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.frame = frame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
