package heap;

import java.lang.reflect.Array;
import java.util.Arrays;

//堆的APi实现
public class Heapb<T extends Comparable<T>> {
    private T[] items;
    private int N;
    public Heapb(int capacity){
        this.items= (T[]) new Comparable[capacity+1];
        this.N=0;
    }
    private boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    private void exch(Comparable[] heap,int i,int j){
        Comparable tmp=heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }
    public void insert(T t){
        items[++N]=t;
        swim(items,N);
    }
    public T delMax(){
        T max=items[1];
        exch(items,1,N);
        items[N]=null;
        N--;
        sink(items,1,N);
        return max;
    }
    //上浮算法
    private void swim(Comparable[] heap,int k){
        while (k>1){
            if (less(heap,k/2,k)){
                exch(heap,k/2,k);
            }
            k=k/2;
        }
    }
//    下沉算法
    private void sink(Comparable[] heap,int target,int range){
        while (2*target<=range){
            int max=2*target;
            if (2*target+1<=range){
                if (less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }else {
                    max=2*target;
                }
            }else {
                max=2*target;
            }
            if (!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);
            target=max;
        }
    }
    public void sort(Comparable[] source){
        Comparable[] heap=new Comparable[source.length+1];
        createHeap(source,heap);
        int N=heap.length-1;
        while (N!=1){
            exch(heap,1,N);
            N--;
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,source.length);
    }
    private void createHeap(Comparable[] source,Comparable[] heap){
        System.arraycopy(source,0,heap,1,source.length);
        for (int i=(heap.length-1)/2;i>1;i--){
            sink(heap,i,heap.length-1);
        }
    }

    public static void main(String[] args) {
        Heapb<String> heap=new Heapb<String>(20);
//        heap.insert("S");
//        heap.insert("G");
//        heap.insert("I");
//        heap.insert("E");
//        heap.insert("N");
//        heap.insert("H");
//        heap.insert("O");
//        heap.insert("A");
//        heap.insert("T");
//        heap.insert("P");
//        heap.insert("R");
//
//        String del;
//        while ((del=heap.delMax())!=null){
//            System.out.print(del+",");
//        }

        String[] arr={"S","O","R","T","E","X","A","M","P","L","E"};
        heap.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
