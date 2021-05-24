package com.yanglei.leetcode.pkg05;

/**
 * @ClassName: MaxPQ
 * @Description: TODO 实现堆排序 以最大堆为例（父节点大于两个子节点）
 * @Author: Yanglei
 * @Date: 2021/5/24 14:27
 * @Version: V1.0
 */
public class MaxPQ<Key extends Comparable<Key>> {
    //存储元素的数组
    private Key[] pq;
    //当前Priority Queue中元素的个数
    private int N;

    public MaxPQ(int captain){
        //索引 0 不用，多分配一个
        pq = (Key[]) new Comparable[captain + 1];
    }

    //父节点索引
    public int parent(int root){
        return root/2;
    }

    //左孩子索引
    public int left(int root){
        return root * 2;
    }

    //右孩子索引
    public int right(int root){
        return root * 2 + 1;
    }

    /*返回当前节点中的最大元素*/
    public Key max(){
        //最大的一定是父节点
        return pq[1];
    }

    /*插入元素，插入到堆尾，然后上浮*/
    public void insert(Key e){
        N++;
        pq[N] = e;
        swim(N);
    }

    /*删除并返回当前队列中最大元素，将堆顶元素A与堆尾元素B互换，然后删除A，B下沉*/
    public Key delMax(){
        Key max = pq[1];
        exchange(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /*上浮第 k 个元素，以维护最大堆特性*/
    public void swim(int k){
        //如果上浮到堆顶则停止上浮
        while (k > 1 && less(parent(k), k)){
            exchange(parent(k), k);
            k = parent(k);
        }
    }

    /*下沉第 k 个元素，以维护最大堆特性*/
    public void sink(int k){
        //沉到堆底不再下沉
        while (left(k) <= N){
            //假设左子节点比较大
            int older = left(k);
            //如果右子节点存在，比较一下大小
            if (right(k) <= N && less(older, right(k)))
                older = right(k);
            //如果比左右节点都大，不用下沉
            if (less(older, k)) break;
            exchange(k, older);
            k = older;
        }
    }

    /*交换两个元素*/
    public void exchange(int i, int j){
        Key cur = pq[i];
        pq[i] = pq[j];
        pq[j] = cur;
    }

    /*pq[i] 是否比 pq[j]小*/
    public boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
}
