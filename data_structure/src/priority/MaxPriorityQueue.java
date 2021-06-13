package priority;

import java.util.Comparator;

//最大优先队列----基于大顶堆思想实现
public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;
    public MaxPriorityQueue(int capacity){
        this.items= (T[]) new Comparable[capacity];
        this.N=0;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }
    private void swap(int i,int j){
        T tmp=items[i];
        items[i]=items[j];
        items[j]=tmp;
    }
    public void offer(T t){
        items[++N]=t;
        swim(N);
    }
    public T poll(){
        T max=items[1];
        swap(1,N);
        N--;
        sink(1);
        return max;
    }
    private void swim(int k){
        while (k>1){
            if (less(k/2,k)){
                swap(k/2,k);
            }
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=N){
            int max;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    max=2*k+1;
                }else {
                    max=2*k;
                }
            }else {
                max=2*k;
            }
            if (!less(k,max)){
                break;
            }
            swap(k,max);
            k=max;
        }
    }

    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<String>(20);
        queue.offer("E");
        queue.offer("A");
        queue.offer("G");
        queue.offer("S");
        queue.offer("B");
        queue.offer("Y");

        while (!queue.isEmpty()){
            String res = queue.poll();
            System.out.print(res+" ");
        }
    }
}
