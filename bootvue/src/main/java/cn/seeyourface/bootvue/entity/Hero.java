package cn.seeyourface.bootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: Hero
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/31 11:31
 * @Version: V1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Hero {
    private int id;
    private String name;
    private String hp;
}
