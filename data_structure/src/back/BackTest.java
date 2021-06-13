package back;

import linear.linked_list.ListNode;
import linear.queue.LinkedListQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//回溯思想，八皇后问题
//
public class BackTest {
    private int[] queen;

    public void backMethod(int n){
//        StringBuilder sb=new StringBuilder();
        //
        int[] arr=new int[n];
        queen=new int[n];
        for (int i=0;i<n;i++){
            queen[i]=-1;
        }
        int k=0;
        while (true){
            queen[k]+=1;
            if (queen[k]>=n){
                if (k>0){
                    queen[k]=-1;
                    k--;
                    continue;
                }else {
                    break;
                }
            }
            if (!isMatch(k)){
                k++;
                if (k>=n){
                    for (int i=0;i<n;i++){
                        System.out.print(queen[i]+"");
//                        sb.append(queen[i]);
                    }
                    System.out.println();
                    k--;
                }
            }
        }
//        System.out.println(sb.toString());
    }
    public boolean isMatch(int k){
        for (int i=k-1;i>-1;i--){
            if (queen[k]==queen[i] || Math.abs(queen[k]-queen[i])==Math.abs(k-i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BackTest backTest = new BackTest();
        backTest.backMethod(4);
    }
}
