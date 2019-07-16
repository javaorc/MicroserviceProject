package com.stylefeng.guns.rest.common.persistence.model;

public class ExpectRanking {
    private String filmId;
    private String imgAdress;
    private String filmName;
    private int expectNum;

    @Override
    public String toString() {
        return "BoxRanking{" +
                "filmId='" + filmId + '\'' +
                ", imgAdress='" + imgAdress + '\'' +
                ", filmName='" + filmName + '\'' +
                ", boxNum=" + expectNum +
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

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }
}
