package cn.seeyourface.bootvue.controller;

import cn.seeyourface.bootvue.entity.Hero;
import cn.seeyourface.bootvue.service.impl.HeroServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: HeroController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/31 14:04
 * @Version: V1.0
 */
@RestController
public class HeroController {
    Log log = LogFactory.getLog(HeroController.class);

    @Autowired
    HeroServiceImpl service;

    /**
    * @Description restFul业务接口
    **/
    @GetMapping("/heroes")
    public PageInfo<Hero> list(@RequestParam(value = "start", defaultValue = "1") int start,
           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start, size, "id desc");
        List<Hero> list = service.list();
        log.info("Hero Size is:" + list.size());
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        PageInfo<Hero> page = new PageInfo<>(list, 5);
        return page;
    }

    @GetMapping("/heroes/{id}")
    public Hero get(@PathVariable("id") int id) throws Exception{
        log.info("GET --- Hero id is:" + id);
        Hero hero = service.get(id);
        log.info("Hero info is:" + hero);
        return hero;
    }

    @DeleteMapping("/heroes/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        log.info("DELETE --- Hero id is:" + id);
        service.delete(id);
        return "SUCCESS";
    }

    @PostMapping("/heroes")
    public String add(@RequestBody Hero h) throws Exception{
        log.error("POST --- Hero info is:" + h);
        service.add(h);
        return "SUCCESS";
    }

    @PutMapping("/heroes")
    public String update(@RequestBody Hero h) throws Exception{
        log.info("PUT --- Hero info is:" + h);
        service.update(h);
        return "SUCCESS";
    }

    /**
    * @Description 页面跳转
    **/
    @RequestMapping(value = "/listHero", method = RequestMethod.GET)
    public ModelAndView listHero() throws Exception{
        ModelAndView mv = new ModelAndView("listHero");
        return mv;
    }

    @RequestMapping(value = "/editHero", method = RequestMethod.GET)
    public ModelAndView editHero() throws Exception{
        ModelAndView mv = new ModelAndView("editHero");
        return mv;
    }
}
