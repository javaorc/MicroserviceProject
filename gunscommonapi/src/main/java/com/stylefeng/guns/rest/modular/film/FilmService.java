package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.modular.film.vo.BannerVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmInfo;
import com.stylefeng.guns.rest.modular.film.vo.FilmVO;

import java.util.List;

public interface FilmService {

    List<BannerVO> bannersSelect();
    FilmVO hotFimlsSelect();
    FilmVO soonFimlsSelect();
    List<FilmInfo> boxRankingSelect();
    List<FilmInfo> expectRankingSelect();
    List<FilmInfo> top100Select();
}
