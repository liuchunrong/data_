package sort;
//插入排序
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int length=arr.length;
        if (length<=1){
            return;
        }
        for (int i=1;i<length;i++){
//            int preindex=i-1;
//            int current=arr[i];
//            while (preindex>=0 && arr[preindex]>current){
//                arr[preindex+1]=arr[preindex];
//                preindex--;
//            }
//            arr[preindex+1]=current;
            for (int j=i;j>0;j--){
                if (arr[j-1]>arr[j]){
                    int tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={5,2,6,9,0,3};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
