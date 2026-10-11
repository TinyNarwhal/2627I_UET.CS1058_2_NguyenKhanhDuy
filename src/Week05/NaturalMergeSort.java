package Week05;

import java.util.Arrays;

public class NaturalMergeSort {

    public static void naturalMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        int[] temp = new int[n];

        while (true) {
            int left = 0;
            int numMerges = 0;

            while (left < n) {

                int mid = left;
                while (mid + 1 < n && arr[mid] <= arr[mid + 1]) {
                    mid++;
                }

                if (mid + 1 >= n) {
                    break;
                }

                int right = mid + 1;
                while (right + 1 < n && arr[right] <= arr[right + 1]) {
                    right++;
                }

                merge(arr, temp, left, mid, right);
                numMerges++;

                left = right + 1;
            }

            if (numMerges == 0) {
                break;
            }
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 7, 2, 8, 1, 9, 3, 5};

        System.out.println("Mảng ban đầu:  " + Arrays.toString(data));
        naturalMergeSort(data);
        System.out.println("Sau khi sắp xếp: " + Arrays.toString(data));
    }
}