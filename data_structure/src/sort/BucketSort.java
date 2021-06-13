package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//桶排序
public class BucketSort {
    public static List<Integer> bucketSort(List<Integer> arr, int bucketSize){
        if (arr==null || arr.size()<2 || bucketSize<1){
            return arr;
        }
        int max=arr.get(0);
        int min=arr.get(0);
        for (int i=0;i<arr.size();i++){
            if (max<arr.get(i)){
                max=arr.get(i);
            }
            if (min>arr.get(i)){
                min=arr.get(i);
            }
        }
        int bucketCount=(max-min)/bucketSize+1;
        List<List<Integer>> bucketList=new ArrayList<>();
        for (int i=0;i<bucketCount;i++){
            List<Integer> bucket=new ArrayList<>();
            bucketList.add(bucket);
        }
        for (int j=0;j<arr.size();j++){
            int bucketIndex=(arr.get(j)-min)/bucketSize;
            bucketList.get(bucketIndex).add(arr.get(j));
        }
        List<Integer> resultList=new ArrayList<>();
        for (int j=0;j<bucketList.size();j++){
            List<Integer> bucket=bucketList.get(j);
            if (bucket.size()>0){
                if (bucketCount==1){
                    bucketSize--;
                }
                List<Integer> temp=bucketSort(bucket,bucketSize);
                for (int i=0;i<temp.size();i++){
                    resultList.add(temp.get(i));
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(2);
        arr.add(6);
        arr.add(9);
        arr.add(0);
        arr.add(3);
        arr.add(4);
        List<Integer> result = bucketSort(arr, 2);
        System.out.println(result);
    }
}
