//package linear.stack;
////栈--后进先出
////数组实现栈--顺序栈
//public class ArrayStack {
//    private int MaxSize;
//    private int[] arr;
//    private int top=-1;
//    public ArrayStack(int maxsize){
//        this.MaxSize=maxsize;
//        arr=new int[MaxSize];
//    }
//    public boolean isFull(){
//        return top==MaxSize-1;
//    }
//    public boolean isEmpty(){
//        return top==-1;
//    }
//    private void push(int val){
//        if (isFull()){
//            System.out.println("栈已经满了");
//            return;
//        }
//        top++;
//        arr[top]=val;
//    }
//    private int pop(){
//        if (isEmpty()){
//            throw new RuntimeException(("栈为空，无法出栈"));
//        }
//        int val=arr[top];
//        top--;
//        return val;
//    }
//    public void show(){
//        if (isEmpty()){
//            System.out.println("没有数据");
//            return;
//        }
//        for (int i = top; i >=0 ; i--) {
//            System.out.println(arr[i]+"\t");
//        }
//    }
//
//    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(5);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//    }
//}
