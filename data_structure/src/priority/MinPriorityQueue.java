package priority;
//最小优先队列----基于小顶堆思想实现
public class MinPriorityQueue<T extends Comparable<T>>{
    private T[] items;
    private int N;
    public MinPriorityQueue(int capacity){
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
        T min=items[1];
        swap(1,N);
        N--;
        sink(1);
        return min;
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2)){
                swap(k,k/2);
            }
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=N){
            int min;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min=2*k;
                }else {
                    min=2*k+1;
                }
            }else {
                min=2*k;
            }
            if (less(k,min)){
                break;
            }
            swap(k,min);
            k=min;
        }
    }

    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(20);
        queue.offer("S");
        queue.offer("O");
        queue.offer("R");
        queue.offer("B");
        queue.offer("P");

        String del;
        while(!queue.isEmpty()){
            del = queue.poll();
            System.out.print(del+",");
        }
    }
}
