package cc.fyp.algorithm.edit.distance;

import java.util.Arrays;

/**
 *
 * 实现编辑距离算法
 *
 * 1.了解动态规划原理，数学定义。
 * 2.了解编辑距离算法公式
 * 3.如何使用数组实现编辑距离
 * 4.用途有哪些？
 *
 * @author von
 * @description:
 * @date 2020/12/29 15:19
 */
public class EditDistance {


    private  static  int dp(String orign,String target){

        //构造数组
        int [][] table = new int[orign.length() + 1][target.length() + 1];
        char [] oa = orign.toCharArray();
        char [] ta = target.toCharArray();


        for (int i = 0; i < oa.length+1; i++) {
            for (int j = 0; j < ta.length+1; j++) {

                //初始化数组
                if (i == 0){
                    table[i][j] = j;
                    continue;
                }
                if (j == 0){
                    table[i][j] = i;
                    continue;
                }

                //实现算法
                int x = i - 1;
                int y = j - 1;

                //计算增加，删除，编辑，的最短距离
                int add = table[i-1][j] + 1;
                int del = table[i][j-1] + 1;
                int cha = table[i-1][j-1] + (oa[x] == ta[y] ? 0 : 1);

                int min = Math.min(Math.min(add, del), cha);
                table[i][j] = min;
            }
        }

        System.out.println("编辑矩阵为：");
        printArrays(table);

        System.out.println("编辑距离最小是：" + table[orign.length()][target.length()]);
        return 0;
    }

    private static void printArrays(int [][] table){

        for (int i = 0; i < table.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table[0].length; j++) {
                sb.append(table[i][j]);
                sb.append(",");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        dp("sailn","failing");
    }
}
