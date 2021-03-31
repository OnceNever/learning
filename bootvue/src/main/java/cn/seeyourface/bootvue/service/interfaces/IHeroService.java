package cn.seeyourface.bootvue.service.interfaces;

import cn.seeyourface.bootvue.entity.Hero;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IHeroService
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/31 12:38
 * @Version: V1.0
 */
public interface IHeroService {
    public int add(Hero hero);

    public void delete(int id);

    public Hero get(int id);

    public int update(Hero hero);

    public List<Hero> list();
}
