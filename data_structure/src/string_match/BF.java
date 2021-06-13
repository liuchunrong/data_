package string_match;

public class BF {
    public int bf(String t,String p){
        if (t.length()==0 || t==null || p.length()==0 || p==null || t.length()<p.length()){
            return -1;
        }
        char[] t_array=t.toCharArray();
        char[] p_array=p.toCharArray();
        int pos=match(t_array,p_array);
        return pos;
    }
    private int match(char[] t,char[] p){
        int i=0;
        int j=0;
        int pos=0;
        while (i<t.length&&j<p.length){
            if (t[i]==p[j]){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if (i<=t.length){
            pos=i-p.length;
        }else {
            pos=-1;
        }
        return pos;
    }

    public static void main(String[] args) {
        BF bf = new BF();
        int bf1 = bf.bf("abcd", "cd");
        System.out.println(bf1);
    }
}
