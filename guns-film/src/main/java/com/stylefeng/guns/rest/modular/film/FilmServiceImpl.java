package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.common.persistence.dao.FilmMapper;
import com.stylefeng.guns.rest.modular.film.vo.BannerVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmInfo;
import com.stylefeng.guns.rest.modular.film.vo.FilmVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmServiceImpl implements FilmService {
@Autowired
FilmMapper filmMapper;
    @Override
    public List<BannerVO> bannersSelect() {
        return filmMapper.bannersSelect();
    }

    @Override
    public FilmVO hotFimlsSelect() {
        FilmVO filmVO=new FilmVO();
        int count=filmMapper.hotFilmSelectCount();
        List<FilmInfo> filmInfo = filmMapper.hotFimlsSelect();
        filmVO.setFilmNum(count);
        filmVO.setFilmInfo(filmInfo);

        return filmVO;
    }

    @Override
    public FilmVO soonFimlsSelect() {
        FilmVO filmVO=new FilmVO();
        int count=filmMapper.soonFilmSelectCount();
        List<FilmInfo> filmInfo = filmMapper.soonFimlsSelect();
        filmVO.setFilmNum(count);
        filmVO.setFilmInfo(filmInfo);
        return filmVO;
    }

    @Override
    public List<FilmInfo> boxRankingSelect() {
        return filmMapper.boxRankingSelect();
    }

    @Override
    public List<FilmInfo> expectRankingSelect() {
        return filmMapper.expectRankingSelect();
    }

    @Override
    public List<FilmInfo> top100Select() {
        return filmMapper.top100Select();
    }
}
