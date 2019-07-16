package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

public class FilmInfo implements Serializable {
    private String filmId;
    private int filmType;
    private String imgAdress;
    private String filmName;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;

    @Override
    public String toString() {
        return "FilmInfo{" +
                "filmId='" + filmId + '\'' +
                ", filmType=" + filmType +
                ", imgAdress='" + imgAdress + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmScore='" + filmScore + '\'' +
                ", expectNum=" + expectNum +
                ", showTime='" + showTime + '\'' +
                ", boxNum=" + boxNum +
                ", score='" + score + '\'' +
                '}';
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public int getFilmType() {
        return filmType;
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
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

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
