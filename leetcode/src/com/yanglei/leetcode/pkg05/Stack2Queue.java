package com.yanglei.leetcode.pkg05;

import java.util.Stack;

/**
 * @ClassName: Stack2Queue
 * @Description: TODO 用栈的api来实现队列 思想：使用两个栈
 * @Author: Yanglei
 * @Date: 2021/5/22 16:22
 * @Version: V1.0
 */
public class Stack2Queue<E> {
    Stack<E> s1, s2;

    public Stack2Queue(){
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }

    public void push(E v){
        s1.push(v);
    }

    /**
    * @Description TODO 返回队头元素
    * @Date 16:29 2021/5/22
    * @Param []
    * @return E
    **/
    public E peek(){
        if (s2.isEmpty())
            while (!s1.isEmpty())
                s2.push(s1.pop());
        return s2.peek();
    }

    /**
    * @Description TODO 删除队头元素
    * @Date 16:29 2021/5/22
    * @Param []
    * @return E
    **/
    public E pop(){
        //调用一下pop()防止队列为空
        peek();
        return s2.pop();
    }

    /**
    * @Description TODO 判断是否为空
    * @Date 16:30 2021/5/22
    * @Param []
    * @return boolean
    **/
    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
