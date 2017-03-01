package com.senpure.learn.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 寻找最大公共子字符串<br>
 *
 *     矩阵对比，查找对角线。
 */
public class CommonStr {

    public void commonStr(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        int[] mark = new int[maxLen];
        int max = 0;
        List<Integer> index = new ArrayList<>();
        max = mark[0];
      //  String str1 = "abcd";
       // String str2 = "1abc";
        for (int i = 0; i < len1; i++) {
            for (int j = len2-1; j >=0 ; j--) {
                //  System.out.println(str1.charAt(i)+" == "+str2.charAt(j)+"  "+(str1.charAt(i) == str2.charAt(j)));
                if (str1.charAt(i) == str2.charAt(j)) {
                    if ( j == 0) {
                        mark[j] = 1;
                    } else {
                        mark[j] = mark[j - 1] + 1;
                    }

                   // System.out.println( mark[j] +","+j);
                    if (mark[j] > max) {
                        max = mark[j];
                        index.clear();
                        index.add(j);
                    } else if (mark[j] == max) {
                        index.add(j);
                    }

                } else {
                    mark[j] = 0;
                }


            }
        }
        Set<String> strs = new HashSet<>();
        System.out.println(index);
        System.out.println("max=" + max);
        for (int i = 0; i < index.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int cindex = index.get(i);
            for (int startIndex = cindex-max+1; startIndex<=cindex; startIndex++) {
                sb.append(str2.charAt(startIndex));

            }
            strs.add(sb.toString());
        }
        System.out.println(strs);
    }

    public static void main(String[] args) {

        String str1 = "abcdbbbb12345b123458";
        String str2 = "1abcdbc123456bbbb";
        CommonStr commonStr = new CommonStr();
        commonStr.commonStr(str1, str2);
    }
}
