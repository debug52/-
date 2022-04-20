package com.test.ALG;

/** 爬楼梯
 * @author jwl
 * @date 2022年04月20日 16:24
 *
 * 亚洲微软研究院所在的希格玛大厦一共有6部电梯。在高峰时间，每层都有人上下，电梯每层都停。实习生小飞常常会被每层都停的电梯弄的很不耐烦，
 * 于是他提出了这样一个办法：由于楼层并不算太高，那么在繁忙的上下班时间，每次电梯从一层往上走时，我们只允许电梯停在其中的某一层。
 * 所有乘客从一楼上电梯，到达某层后，电梯停下来，所有乘客再从这里爬楼梯到自己的目的层。在一楼的时候，每个乘客选择自己的目的层，
 * 电梯则计算出应停的楼层。问：电梯停在哪一层楼，能够保证这次乘坐电梯的所有乘客爬楼梯的层数之和最少？
 */
public class ClimbStairs {

    private int nPerson[];  //nPerson[i]表示到第i层的乘客数目
    private int nFloor;  //电梯的总层数
    //构造函数
    public ClimbStairs(int[] nPerson, int nFloor){
        this.nPerson = nPerson;
        this.nFloor = nFloor;
    }

    /**
     * 计算目标层
     * @return 目标层
     */
    public int getTargetFloor(){
        int minFloor = 0; //记录爬楼梯总和的最小值
        int targetFloor = -1;  //电梯停的目标层，初始为-1
        int i;
        int N1; //第i层以下的乘客数目
        int N2; //第i层的乘客数目
        int N3; //第i层以上的乘客数目
        //计算第一层的N1,N2,N3值
        N1 = 0;
        N2 = nPerson[0];
        for(N3=0,i=1;i<nFloor;i++){
            N3 += nPerson[i];
            minFloor += nPerson[i]*i;
        }
        //判断是否需要改变i值
        for(i=2;i<=nFloor;i++){
            if(N1+N2<N3){
                targetFloor = i;
                minFloor += N1+N2-N3;
                N1 += N2;;
                N2 = nPerson[i-1];
                N3 -= nPerson[i-1];
            }else{
                break;
            }
        }
        System.out.println("爬楼梯层数的最小值为："+minFloor);
        return targetFloor;
    }
    public static void main(String[] args) {
        int nPerson[] = {0,1,3,3,4,6,8,4};
        ClimbStairs es = new ClimbStairs(nPerson, 8);
        System.out.println("电梯的目标层应为："+es.getTargetFloor());
    }
}
