package binary_search;
//二分查找，序列中不存在重复元素
public class SimpleBinarySearch {
    public static int simpleBinarySearch(int[] arr,int value){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==value){
                return mid;
            }else if (arr[mid]<value){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={8,10,15,16,17,20};
        System.out.println(simpleBinarySearch(arr,16));
    }
}
