package dp;
//自底向上动态规划
public class FbPlus {
    public static int fb(int n){
        if (n<=0){
            return -1;
        }
        int[] memory=new int[n+1];
        memory[0]=0;
        memory[1]=1;
        for (int i=2;i<=n;i++){
            memory[i]=memory[i-1]+memory[i-2];
        }
        return memory[n];
    }

    //改进
    public static int fb2(int n){
        if (n<=0){
            return -1;
        }
        int m0=0;
        int m1=1;
        int m2=1;
        for (int i=2;i<=n;i++){
            m2=m1+m0;
            m0=m1;
            m1=m2;
        }
        return m2;
    }
    public static void main(String[] args) {
        int i=fb(6);
        System.out.println(i);
        System.out.println(FbPlus.fb2(6));
    }
}
