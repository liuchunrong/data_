package sort;

import java.util.Arrays;

//快速排序
public class QuickSort {
    public static void quickSort(int[] arr,int begin,int end){
        if (arr.length<=1 || begin>=end){
            return;
        }
        int pivotIndex=partition(arr,begin,end);
        quickSort(arr,0,pivotIndex-1);
        quickSort(arr,pivotIndex+1,end);
    }

    public static int partition(int[] arr,int begin,int end){
//        int pivot = arr[end];
//        int pivotIndex=begin;
//        for (int i=begin;i<arr.length;i++){
//            if (arr[i]<pivot){
//                if (i>pivotIndex){
//                    swap(arr,i,pivotIndex);
//                }
//                pivotIndex++;
//            }
//            swap(arr,pivotIndex,end);
//        }
//        return pivotIndex;

        int key=arr[begin];//把最左边的元素当做基准值
        int left=begin;//定义一个左侧指针，初始指向最左边的元素
        int right=end+1;//定义一个右侧指针，初始指向左右侧的元素下一个位置
        //进行切分
        while(true){
            //先从右往左扫描，找到一个比基准值小的元素
            while(key<arr[--right]){//循环停止，证明找到了一个比基准值小的元素
                if (right==begin){
                    break;//已经扫描到最左边了，无需继续扫描
                }
            }

            //再从左往右扫描，找一个比基准值大的元素
            while(arr[++left]<key){//循环停止，证明找到了一个比基准值大的元素
                if (left==end){
                    break;//已经扫描到了最右边了，无需继续扫描
                }
            }

            if (left>=right){
                //扫描完了所有元素，结束循环
                break;
            }else{
                //交换left和right索引处的元素
                swap(arr,left,right);
            }
        }

        //交换最后rigth索引处和基准值所在的索引处的值
        swap(arr,begin,right);
        return right;//right就是切分的界限
    }
    public static void swap(int[] arr, int i, int j){
        int tem=arr[i];
        arr[i]=arr[j];
        arr[j]=tem;
    }

    public static void main(String[] args) {
        int[] arr={0,6,3,8,1,5};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
