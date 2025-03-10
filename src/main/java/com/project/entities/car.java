package com.project.entities;

public class car {
    private Integer id;
    private String name;
    private String description;
    private String urlPhoto;
    private String urlVideo;
    private String latitude;
    private String logitude ;
    private String type;
    public car(){};

    public car(Integer id, String name, String description, String urlPhoto, String urlVideo, String latitude, String logitude, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlPhoto = urlPhoto;
        this.urlVideo = urlVideo;
        this.latitude = latitude;
        this.logitude = logitude;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = description;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlFoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogitude() {
        return logitude;
    }

    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", nome='" + name+ '\'' +
                ", desc='" + description + '\'' +
                ", tipo='" + type + '\'' +
                '}';
    }
}
