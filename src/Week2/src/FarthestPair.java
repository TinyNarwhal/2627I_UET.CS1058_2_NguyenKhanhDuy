package Week2.src;

public class FarthestPair {

    public static void findFarthestPair(double[] a) {
        if (a == null || a.length < 2) {
            System.out.println("Mảng cần có ít nhất 2 phần tử");
            return;
        }

        double min = a[0];
        double max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        double maxDiff = Math.abs(max - min);
        System.out.println("Cặp xa nhất là: (" + min + ", " + max + ")");
        System.out.println("Hiệu lớn nhất là: " + maxDiff);
    }
}