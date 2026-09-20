package Week2.src;

public class ClosestPair {

    public static void mergeSort(double[] a, double[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        mergeSort(a, aux, low, mid);
        mergeSort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    private static void merge(double[] a, double[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void findClosestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Mảng cần có ít nhất 2 phần tử.");
            return;
        }

        double[] aux = new double[a.length];
        mergeSort(a, aux, 0, a.length - 1);

        double minDiff = Math.abs(a[1] - a[0]);
        double num1 = a[0];
        double num2 = a[1];

        for (int i = 1; i < a.length - 1; i++) {
            double currentDiff = Math.abs(a[i + 1] - a[i]);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                num1 = a[i];
                num2 = a[i + 1];
            }
        }

        System.out.println("Cặp gần nhất: (" + num1 + ", " + num2 + ")");
        System.out.println("Hiệu nhỏ nhất: " + minDiff);
    }
}