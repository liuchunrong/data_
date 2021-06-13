import java.util.*;

public class Test12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int countnumber = input.nextInt();
        int[] number = new int[countnumber];
        for (int i = 0; i < number.length; i++) {
            number[i] = input.nextInt();
        }
        int[][] ll=new int[6][6];

        var arr = new int[countnumber];
        int j = 0;
        for (int i = 0; i < number.length; i++) {
            int a = (int) (Math.sqrt(number[i]) + 0.5);
            arr[j++] = Math.abs(a * a - number[i]);
        }
//        quickSort(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            result += arr[i];
        }

        System.out.print(result);
        input.close();
    }

//    public static void quickSort(int[] arr, int low, int high) {
//        while (low > high) {
//            return;
//        }
//        int i = low;
//        int j = high;
//        int temp = arr[low];
//
//        while (i < j) {
//            while (temp <= arr[j] && i < j) {
//                j--;
//            }
//            while (temp >= arr[i] && i < j) {
//                i++;
//            }
//            int t = arr[i];
//            arr[i] = arr[j];
//            arr[j] = t;
//        }
//        arr[low] = arr[i];
//        arr[i] = temp;
//
//        quickSort(arr, i + 1, high);
//        quickSort(arr, low, i - 1);
//    }
}
