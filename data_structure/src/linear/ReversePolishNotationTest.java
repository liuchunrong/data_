package linear;
//栈----求逆波兰表达式的值
public class ReversePolishNotationTest {
    public static void main(String[] args) {
//        中缀表达式： 3*(17-15)+18/6
        String[] notation={"3","17","15","-","*","18","6","/","+"};
        int result=caculate(notation);
        System.out.println("逆波兰表达式的结果为："+result);
    }

    public static int caculate(String[] notation) {
        ListStack<Integer> stack = new ListStack<>();
        for (int i = 0; i < notation.length; i++) {
            String curr=notation[i];
            Integer o1;
            Integer o2;
            Integer result;
            switch (curr){
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result=o2+o1;
                    stack.push(result);
                    break;
                case "-":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2-o1;
                    stack.push(result);
                    break;
                case "*":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2*o1;
                    stack.push(result);
                    break;
                case "/":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2/o1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
                    break;
            }
        }
        int result=stack.pop();
        return result;
    }

}
