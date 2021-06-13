package dp;
/*
钢管切割问题
 */
public class CutSteelBar {
    public static int cutSteelBar(int[] p,int n){
        if (n==0){
            return 0;
        }
        int q=Integer.MIN_VALUE;
        for (int i=1;i<n;i++){
            q=Math.max(q,p[i-1]+cutSteelBar(p,n-i));
        }
        return q;
    }

}
