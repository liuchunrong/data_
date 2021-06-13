package linear;
//栈----解决括号匹配问题
public class BracketsMatchTest {
    public static void main(String[] args) {
        String str="上海(长安)())";
        boolean match=isMatch(str);
        System.out.println(str+"中的括号是否匹配:"+match);
    }

    public static boolean isMatch(String str) {
        ListStack<String> stack=new ListStack<>();
        for (int i = 0; i < str.length(); i++) {
            String s=str.charAt(i)+"";
            if (s.equals("(")){
                stack.push(s);
            }else if (s.equals(")")){
                String pop = stack.pop();
                if (pop==null){
                    return false;
                }
            }
        }
        if (stack.size()==0){
            return true;
        }else {
            return false;
        }
    }
}
