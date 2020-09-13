package com.fpoly.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "frames")
public class Frame {

    @Id
    private int id;
    private String text;
    private String audio;

    @OneToMany(mappedBy = "frame", cascade = CascadeType.ALL)
    private List<ArrayImage> imageList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "collectionId")
    private Collection collection;

    public Frame() {
    }

    public Frame(int id, String text, String audio, List<ArrayImage> imageList, Collection collection) {
        this.id = id;
        this.text = text;
        this.audio = audio;
        this.imageList = imageList;
        this.collection = collection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public List<ArrayImage> getListImage() {
        return imageList;
    }

    public void setListImage(List<ArrayImage> imageList) {
        this.imageList = imageList;
    }

    public Collection getCollectionId() {
        return collection;
    }

    public void setCollectionId(Collection collection) {
        this.collection = collection;
    }
}
