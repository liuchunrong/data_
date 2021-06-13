import java.math.BigInteger;

public class recursion {
    public static int factor(int n){
        if (n==0){
            return 1;
        }else {
            return n*factor(n-1);
        }
    }

    public static BigInteger factor2(int n){
        if (n==0){
            return BigInteger.ONE;
        }else {
            return BigInteger.valueOf(n).multiply(factor2(n-1));
        }
    }

    public static void main(String[] args) {
        int factor1=factor(100);
        BigInteger factor2=factor2(100);
        System.out.println(factor1);
        System.out.println(factor2);
    }
}
