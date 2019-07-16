package com.stylefeng.guns.rest.common.persistence.model;

public class Top100 {
    private String filmId;
    private String imgAdress;
    private String filmName;
    private double score;

    @Override
    public String toString() {
        return "Top100{" +
                "filmId='" + filmId + '\'' +
                ", imgAdress='" + imgAdress + '\'' +
                ", filmName='" + filmName + '\'' +
                ", score=" + score +
                '}';
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getImgAdress() {
        return imgAdress;
    }

    public void setImgAdress(String imgAdress) {
        this.imgAdress = imgAdress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
