package com.mall.goodscenterserver.daltest;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zheng haijain
 * @createTime 2020-03-25 09:38
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] ints = {{1, 3},{4,5}};
        int[][] res = main.merge(ints);
        for(int[] a : res){
            System.out.println(a[0] +"--" + a[1]);
        }

    }

    int[][] merge(int[][] intervals){
        // 1. 校验
        if (intervals.length == 0 || intervals.length == 1){
            return intervals;
        }
        int head = 0;
        int tail = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < intervals.length; i++){
            if (i == intervals.length -1){
                queue.add(intervals[head][0]);
                queue.add(intervals[tail][1]);
                break;
            }
            int[] now = intervals[i];
            int[] next = intervals[i+1];
            if (now[1] >= next[0]) {
                tail++;
            } else {
                queue.add(intervals[head][0]);
                queue.add(intervals[tail][1]);
                tail++;
                head = tail;
            }
        }

        int length = queue.size() / 2;
        int[][] res = new int[length][2];
        for (int i = 0; i < length; i++){
            res[i][0] = queue.poll();
            res[i][1] = queue.poll();
        }
        return res;
    }

}
