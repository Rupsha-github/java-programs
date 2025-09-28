import java.util.*;
public class MoveZerosToEnd {
    public static int[] func(int[] arr) {
        int res[] = new int[arr.length];
        int left = 0, right = arr.length-1, k = 0;
        while(left <= right) { // k < arr.length
            if(arr[k] != 0) {
                res[left++] = arr[k++];
            } else {
                res[right--] = arr[k++];
            }
        }
        return res;
    }
    public static void main(String args[]) {
    int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the array");
        for (int i = 0 ; i < 5 ; i++) arr[i] = sc.nextInt();
//             int arr[] = {0, 0, 0, 0, 2, 4, 0, 0, 0};
            int res[] = func(arr);
            System.out.println(Arrays.toString(res));
    }
}