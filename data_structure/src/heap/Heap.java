package heap;
//修改
import java.util.Arrays;

public class Heap {
    private int[] data;
    private int size;
    private int count;
    public Heap(int capacity){
        this.data=new int[capacity];
        this.size=capacity;
        this.count=0;
    }
    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }
    public void insert(int value){
        if (count>=size){
            return;
        }
        data[++count]=value;
        heapB2T(data,count);
    }
    public int removeMaxTop(){
        int max=data[1];
        data[1]=data[count--];
        heapT2B(data,1,count);
        return max;
    }
    private void heapB2T(int[] data,int end){
        int i=end;
        while (i/2>0&&data[i/2]<data[end]){
            swap(data,i/2,i);
            i/=2;
        }
    }
    private void heapT2B(int[] data,int begin,int end){
        while (true){
            int maxPos=begin;
            if (2*begin<=end && data[maxPos]<data[begin*2]){
                maxPos=begin*2;
            }
            if (2*begin+1<=end && data[maxPos]<data[begin*2+1]){
                maxPos=begin*2+1;
            }
            if (begin==maxPos){
                break;
            }
            swap(data,begin,maxPos);
            begin=maxPos;
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private void buildHeap(int[] arr,int n){
        for (int i=n/2;i>0;i--){
            heapT2B(arr,i,n);
        }
    }
    private void sort(int[] arr,int n){
        while (n>1){
            swap(arr,1,n);
            heapT2B(arr,1,--n);
        }
    }
    public void heapSort(int[] arr){
        buildHeap(arr,arr.length-1);
        sort(arr,arr.length-1);
    }

    public static void main(String[] args) {
        Heap heap=new Heap(7);
        int[] arr=new int[7];
        arr[1]=2;
        arr[2]=6;
        arr[3]=9;
        arr[4]=0;
        arr[5]=3;
        arr[6]=5;
        System.out.println(Arrays.toString(arr));
        heap.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
