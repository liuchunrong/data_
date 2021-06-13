package sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {

    public static void sort(int[] arr){
        if (arr.length<=1){
            return;
        }

        int h=1;
        while (h<arr.length/2){
            h=2*h+1;
        }

        while (h>=1){
            for (int i=h;i<arr.length;i++){
                for (int j=i;j>=h;j-=h){
                    if (arr[j-h]>arr[j]){
                        int tmp=arr[j-h];
                        arr[j-h]=arr[j];
                        arr[j]=tmp;
                    }else {
                        break;
                    }
                }
            }
            h=h/2;
        }
    }

    public static void main(String[] args) {
        int[] arr={5,0,2,6,2,7,4,9,8};
        System.out.println(Arrays.toString(arr));
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
