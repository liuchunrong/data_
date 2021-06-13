package linear.stack;

import java.util.Arrays;

//数组实现栈--顺序栈（支持动态扩容）
public class ArrayStack {
    private int size;
    private Object[] elements;
    private int DEFAULT_CAPACITY=10;
    private int MAX_ARRAY_SIZE=Integer.MAX_VALUE-8;

    public ArrayStack(){
        elements=new Object[DEFAULT_CAPACITY];
    }
    public ArrayStack(int capacity){
        elements=new Object[capacity];
    }
    public boolean push(Object element){
        checkCapacity(size+1);
        elements[size++]=element;
        return true;
    }
    public void checkCapacity(int minCapacity){
        if (minCapacity-elements.length>0){
            grow(elements.length);
        }
    }
    public void grow(int oldCapacity){
        int newCapacity=oldCapacity+(oldCapacity>>1);
        if (newCapacity-oldCapacity<0){
            newCapacity=DEFAULT_CAPACITY;
        }
        if (newCapacity-MAX_ARRAY_SIZE>0){
            newCapacity=hugeCapacity(newCapacity);
        }
        elements=Arrays.copyOf(elements,newCapacity);
    }
    public int hugeCapacity(int newCapacity){
        return newCapacity>MAX_ARRAY_SIZE?Integer.MAX_VALUE:newCapacity;
    }
    public Object pop(){
        if (size<=0){
            return null;
        }
        Object obj = elements[size - 1];
        elements[--size]=null;
        return obj;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        for (int i=0; i<20; i++) {
            boolean push = stack.push(i);
            System.out.println("第"+(i+1)+"次存储数据为:"+i+",存储结果是: "+push);
        }
        // stack.push(1);
        for (int i=0; i<11; i++) {
            Object pop = stack.pop();
            System.out.println(pop);
        }
    }
}
