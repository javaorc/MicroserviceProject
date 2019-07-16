package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.modular.film.vo.BannerVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmConditionListResult;
import com.stylefeng.guns.rest.modular.film.vo.FilmInfo;
import com.stylefeng.guns.rest.modular.film.vo.FilmVO;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Reference
    FilmService filmService;

    @RequestMapping("/getConditionList")
    @ResponseBody
    public FilmConditionListResult getConditionList(int catId, int sourceId, int yearId ){
        List<BannerVO> banners=filmService.bannersSelect();
        FilmVO filmVOh=filmService.hotFimlsSelect();
        FilmVO filmVOs=filmService.soonFimlsSelect();
        List<FilmInfo> boxRankings=filmService.boxRankingSelect();
        List<FilmInfo> expectRankings=filmService.expectRankingSelect();
        List<FilmInfo> top100= filmService.top100Select();
        FilmConditionListResult result=new FilmConditionListResult();
        return null;

    }

}
