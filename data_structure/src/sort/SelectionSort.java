package sort;

import java.util.Arrays;

//选择排序
public class SelectionSort {
    public static void selectionSort(int[] arr){
        int length=arr.length;
        if (length<=1){
            return;
        }
        for (int i=0;i<length-1;i++){
            int minindex=i;
            for (int j=i+1;j<length;j++){
                if (arr[minindex]>arr[j]){
                    minindex=j;
                }
            }
            int tem=arr[i];
            arr[i]=arr[minindex];
            arr[minindex]=tem;
        }
    }

    public static void main(String[] args) {
        int[] arr={5,0,2,1,6};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
