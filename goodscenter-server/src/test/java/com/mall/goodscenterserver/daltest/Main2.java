package com.mall.goodscenterserver.daltest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zheng haijain
 * @createTime 2020-03-25 10:27
 * @description
 */
public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.valid("apple", "a2e"));
    }

    boolean valid(String word, String abbr){
        // 提取abbr中的数字
        Queue<String> queue = new ArrayDeque<>();
        Pattern p = Pattern.compile("\\d{1,}");
        Matcher m = p.matcher(abbr);
        while(m.find()) {
            queue.add(m.group());
        }
        // 提取abbr中的字符
        String regex = "\\d*";
        String[] res = abbr.split(regex);
        // 整合
        List<String> list = new ArrayList<>();
        for (String s : res) {
            if ("".equals(s)) {
                list.add(queue.poll());
            } else {
                list.add(s);
            }
        }
        for (int i = 0, k = 0; i < word.length() && k < abbr.length();){
            String s = String.valueOf(word.charAt(i));
            if (list.get(k).equals(s)){
                i++;
                k++;
                continue;
            } else {
                try {
                    int num = Integer.parseInt(list.get(k));
                    i = i + num;
                    k++;
                } catch (Exception e){
                    return false;
                }
            }
        }
        return true;
    }



}
