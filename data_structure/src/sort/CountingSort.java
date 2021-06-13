package sort;

import java.util.Arrays;

//计数排序
public class CountingSort {
    public static void countingSort(int[] arr){
        int max=arr[0];
        for (int i=0;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }
        int bucketSize=max+1;
        int[] bucket=new int[bucketSize];
        for (int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        int[] temp=new int[arr.length];
        int sortedIndex=0;
        for (int j=0;j<bucketSize;j++){
            while (bucket[j]>0){
                temp[sortedIndex++]=j;
                bucket[j]--;
            }
        }
        for (int k=0;k<temp.length;k++){
            arr[k]=temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr={1,0,5,2,8,0};
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
