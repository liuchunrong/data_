package binary_search;

public class BinarySearch {
    //二分查找,序列中存在重复元素，找出给定值第一次出现的下标
    public static int binarySearch(int[] arr, int value){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==value){
                if (mid==0 || arr[mid-1]!=value){
                    return mid;
                }else {
                    high=mid-1;
                }
            }else if (arr[mid]<value){
                low=mid+1;
            }else if (arr[mid]>value){
                high=mid-1;
            }
        }
        return -1;
    }

    //二分查找,序列中存在重复元素，找出给定值最后一次出现的下标
    public static int binarySearch2(int[] arr,int value){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==value){
                if (mid==arr.length-1 || arr[mid+1]!=value){
                    return mid;
                }else {
                    low=mid+1;
                }
            }else if (arr[mid]<value){
                low=mid+1;
            }else if (arr[mid]>value){
                high=mid-1;
            }
        }
        return -1;
    }
    //二分查找,序列中存在重复元素，找出第一个大于等于给定值的元素
    public static int binarySearch3(int[] arr,int value){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]>=value){
                if (mid==0 || arr[mid-1]<value){
                    return mid;
                }else {
                    high=mid-1;
                }
            }else {
                low=mid+1;
            }
        }
        return -1;
    }
    //二分查找,序列中存在重复元素，找出最后一个小于等于给定值的元素
    public static int binarySearch4(int arr[],int value){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]<=value){
                if (mid==arr.length-1 || arr[mid+1]>value){
                    return mid;
                }else {
                    low=mid+1;
                }
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={12,15,19,24,26,29,29,29,97};
        System.out.println(binarySearch(arr,29));
        System.out.println(binarySearch2(arr,29));
        System.out.println(binarySearch3(arr,28));
        System.out.println(binarySearch4(arr,30));
    }

}
