package com.stylefeng.guns.rest.common.persistence.dao;


import com.stylefeng.guns.rest.modular.film.vo.BannerVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmInfo;

import java.util.List;

public interface FilmMapper  {

    List<BannerVO> bannersSelect();

    int hotFilmSelectCount();

    List<FilmInfo> hotFimlsSelect();

    List<FilmInfo> boxRankingSelect();

    List<FilmInfo> expectRankingSelect();

    List<FilmInfo> top100Select();

    int soonFilmSelectCount();

    List<FilmInfo> soonFimlsSelect();

}
