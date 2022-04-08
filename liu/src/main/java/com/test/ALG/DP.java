package com.test.ALG;

/**
 * @Author nina
 * @Date 2022/4/8 15:39
 * 动态规划算法
 */
public class DP {

    //Q：算法题:小孩爬楼梯,n个台阶,小孩一次可以上1或者2个台阶,计算小孩有多少种上楼梯的方式



    //到达每层台阶的方法数
    public static int[] steps = new int[11];

    public static void main(String[] args) {
        
        steps[10] = calStep(10);
        for (int step : steps) {
            System.out.print(step+" ");
        }
        System.out.println("\nsteps[10]:"+steps[10]);
    }

    //到底第i层台阶的方法数
    private static int calStep(int i) {

        if (i ==1 || i==2){
            return i;
        }

        if (steps[i-1] == 0){
            steps[i-1] = calStep(i-1);
        }
        if (steps[i-2] == 0){
            steps[i-2] = calStep(i-2);
        }
        return  steps[i-1] +steps[i-2];
    }
}
