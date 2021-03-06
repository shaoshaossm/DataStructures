package com.ssm.tenAlgorithms;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2021/10/16 16:35
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4;
        int n = val.length;
        //最大价值
        int[][] v = new int[n + 1][m + 1];
        //商品放入情况
        int[][] path = new int[n + 1][m + 1];
        //初始化第一行和列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                //公式
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    // 记录商品放入情况
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }

        }
        //输出
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println(
            );
        }
        int i = path.length-1; //行的最大下标
        int j = path[0].length-1; //列的最大下标
        while (i>0&&j>0){ //从最后遍历
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j-=w[i-1]; // 剩余的容量
            }
            i--;
        }
    }


}
