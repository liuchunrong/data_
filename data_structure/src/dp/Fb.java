package dp;
//自顶向下动态规划思想解决斐波那契重复计算问题
public class Fb {

    public static int fib(int n,int[] memory){
        if (memory[n]!=-1){
            return memory[n];
        }
        if (n<=2){
            memory[n]=1;
        }else {
            memory[n]=fib(n-1,memory)+fib(n-2,memory);
        }
        return memory[n];
    }
    public static int fibnoaci(int n){
        if (n<=0){
            return -1;
        }
        int[] merory=new int[n+1];
        for (int i=0;i<=n;i++){
            merory[i]=-1;
        }
        return fib(n,merory);
    }

    public static void main(String[] args) {
        int i=fibnoaci(7);
        System.out.println(i);
    }
}
