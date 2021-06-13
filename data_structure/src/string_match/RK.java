package string_match;

public class RK {
    public int rk(String t,String p){
        if (t.length()==0||t==null|p.length()==0||p==null){
            return -1;
        }
        int hash=hash(p,26,31,0,p.length());
        for (int i=0;i<t.length();i++){
            if (hash(p,26,31,0,p.length())==hash&&match(t,p,i)){
                return i;
            }
        }
        return -1;
    }
    private boolean match(String t,String  p,int i){
        for (int j=0;j<p.length();j++){
            if (p.charAt(j)!=t.charAt(j+i)){
                return false;
            }
        }
        return true;
    }
    private int hash(String string,int R,int K,int start,int len){
        int hash=0;
        for (int i=start;i<start+len;i++){
            hash=(R*hash+string.charAt(i)%K);
        }
        return hash;
    }

    public static void main(String[] args) {
        RK rk = new RK();
        int rk1=rk.rk("abcef","e");
        System.out.println(rk1);
    }
}
