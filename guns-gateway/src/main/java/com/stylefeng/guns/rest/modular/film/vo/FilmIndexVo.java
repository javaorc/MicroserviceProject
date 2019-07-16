package com.stylefeng.guns.rest.modular.film.vo;

import java.util.List;

public class FilmIndexVo {
    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;

    @Override
    public String toString() {
        return "FilmIndexVo{" +
                "banners=" + banners +
                ", hotFilms=" + hotFilms +
                ", soonFilms=" + soonFilms +
                ", boxRanking=" + boxRanking +
                ", expectRanking=" + expectRanking +
                ", top100=" + top100 +
                '}';
    }

    public List<BannerVO> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerVO> banners) {
        this.banners = banners;
    }

    public FilmVO getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(FilmVO hotFilms) {
        this.hotFilms = hotFilms;
    }

    public FilmVO getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(FilmVO soonFilms) {
        this.soonFilms = soonFilms;
    }

    public List<FilmInfo> getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(List<FilmInfo> boxRanking) {
        this.boxRanking = boxRanking;
    }

    public List<FilmInfo> getExpectRanking() {
        return expectRanking;
    }

    public void setExpectRanking(List<FilmInfo> expectRanking) {
        this.expectRanking = expectRanking;
    }

    public List<FilmInfo> getTop100() {
        return top100;
    }

    public void setTop100(List<FilmInfo> top100) {
        this.top100 = top100;
    }
}
