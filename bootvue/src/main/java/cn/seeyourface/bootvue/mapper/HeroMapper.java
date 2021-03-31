package cn.seeyourface.bootvue.mapper;

import cn.seeyourface.bootvue.entity.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: HeroMapper
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/31 11:59
 * @Version: V1.0
 */
@Mapper
public interface HeroMapper {
    public int add(Hero hero);

    public void delete(int id);

    public Hero get(int id);

    public int update(Hero hero);

    public List<Hero> list();
}
