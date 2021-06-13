package linear.linked_list;

import java.util.Iterator;

//顺序表API设计
//java中的ArrayList就是基于数组实现
public class SequenceList<T> implements Iterable<T>{
    private T[] eles;
    private int N;
    public SequenceList(int capacity){
        eles= (T[]) new Object[capacity];
        this.N=0;
    }

    public void clear(){
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int length(){
        return N;
    }
    public T get(int i){
        return eles[i];
    }
    public void insert(T t){
        if (N==eles.length){
            resize(2*eles.length);
        }
        eles[N++]=t;
    }
    public void insert(int i,T t){
        if (N==eles.length){
            resize(2*eles.length);
        }
        for (int j=N;j>i;j--){
            eles[i]=eles[i-1];
        }
        eles[i]=t;
        N++;
    }
    public T remove(int i){
        T curr=eles[i];
        for (int j=i;j<N-1;j++){
            eles[i]=eles[i+1];
        }
        N--;
        if (N<eles.length/4){
            resize(eles.length/2);
        }
        return curr;
    }
    public int indexOf(T t){
        for (int i=0;i<N;i++){
            if (eles[i]==t){
                return i;
            }
        }
        return -1;
    }
    //扩容机制
    public void resize(int newSize){
        T[] temp=eles;
        eles= (T[]) new Object[newSize];
        for(int i=0;i<N;i++){
            eles[i]=temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new sIterator();
    }
    private class sIterator implements Iterator{
        private int cusor;
        public sIterator(){
            this.cusor=0;
        }
        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

    public static void main(String[] args) {
        SequenceList<String> list=new SequenceList<String>(2);
        list.insert("t1");
        list.insert("t2");
        list.insert("t3");
//        System.out.println(list.get(1));
        for (String s:list){
            System.out.println(s);
        }

    }
}
