package xyz.javaee.myapplication.lab9;

import java.io.Serializable;

public class ImgEntity implements Serializable {
    private String img;
    private String message;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ImgEntity(String img, String message) {
        this.img = img;
        this.message = message;
    }

    public ImgEntity() {
    }

    @Override
    public String toString() {
        return "ImgEntity{" +
                "img='" + img + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
