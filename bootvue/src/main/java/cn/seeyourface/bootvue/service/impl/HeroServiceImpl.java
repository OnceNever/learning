package cn.seeyourface.bootvue.service.impl;

import cn.seeyourface.bootvue.entity.Hero;
import cn.seeyourface.bootvue.mapper.HeroMapper;
import cn.seeyourface.bootvue.service.interfaces.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: HeroServiceImpl
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/31 12:39
 * @Version: V1.0
 */
@Service
public class HeroServiceImpl implements IHeroService {

    @Autowired
    HeroMapper mapper;

    @Override
    public int add(Hero hero) {
        return mapper.add(hero);
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }

    @Override
    public Hero get(int id) {
        return mapper.get(id);
    }

    @Override
    public int update(Hero hero) {
        return mapper.update(hero);
    }

    @Override
    public List<Hero> list() {
        return mapper.list();
    }
}
