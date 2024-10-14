package cracking.sort;

import java.util.Arrays;

public class InterviewQuestions {

    public static void main(String args[]) {
        int[] arr = new int[] {4,5,2,7,6,8,0};
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int[] arr, int begin, int end)
    {
        if(begin<end) {
            int k = partition(arr, begin, end);
            quick_sort(arr, begin, k-1);
            quick_sort(arr, k+1, end);
        }
    }

    public static int partition(int[] arr, int begin, int end) {
        int low = begin;
        int high = end;
        int pivot = arr[begin];
        while(low < high)
        {
            while(arr[high] > pivot) {
                high--;
            }
            swap(arr,high,low);
            while(arr[low] < pivot) {
                low++;
            }
            swap(arr,high,low);
        }
        return low;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


