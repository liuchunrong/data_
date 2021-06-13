package sort;

import java.util.Arrays;
import java.util.Hashtable;

//冒泡排序
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int length=arr.length;
        if (length<=1){
            return;
        }

        for (int i=0;i<length;i++){
            boolean flag=true;
            for (int j=0;j<length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int tem=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={5,2,3,0,7};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
