package sort;
//归并排序
import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr){
        if (arr.length<2){
            return arr;
        }
        int mid=arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }
    public static int[] merge(int[] left, int[] right){
        int[] mergeArr=new int[left.length+right.length];
        int lindex=0;
        int rindex=0;
        for (int i=0;i<mergeArr.length;i++){
            if (lindex>=left.length){
                mergeArr[i]=right[rindex++];
            }else if (rindex>=right.length){
                mergeArr[i]=left[lindex++];
            }else if (left[lindex]<right[rindex]){
                mergeArr[i]=left[lindex++];
            }else {
                mergeArr[i]=right[rindex++];
            }
        }
        return mergeArr;
    }

    public static void main(String[] args) {
        int[] arr={0,5,7,1,4,9};
        System.out.println(Arrays.toString(arr));
        int[] sort = mergeSort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
