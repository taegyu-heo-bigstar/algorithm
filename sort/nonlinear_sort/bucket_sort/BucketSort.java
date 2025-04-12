/*
    have a variable version
    1. just delivered integer array
    2. delivered integer array and the number of buckets
    3. just delivered real number array
    4. delivered real number array and the number of buckets
    5. etc
*/

public class BucketSort{
    public static void sort(int[] arr) {
        int n = arr.length;
        int bucketCount = n;

        int[][] buckets = new int[bucketCount][n];
        int[] bucketSizes = new int[bucketCount];

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)((arr[i] - min) * bucketCount / (max - min + 1));
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = arr[i]
        }

        for (int i = 0; i < bucketCount; i++){
            my_sort(buckets[i]);    //not implementted...
        }

        int idx = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (int j = 0; j < bucketSizes[i]; j++) {
                arr[idx++] = buckets[i][j];
            }
        }
    }

    public static void sort(int[] arr, int bc) {
        int n = arr.length;
        int bucketCount = bc;

        int[][] buckets = new int[bucketCount][n];
        int[] bucketSizes = new int[bucketCount];

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)((arr[i] - min) * bucketCount / (max - min + 1));
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = arr[i]
        }

        for (int i = 0; i < bucketCount; i++){
            my_sort(buckets[i]);    //not implimentted...
        }

        int idx = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (int j = 0; j < bucketSizes[i]; j++) {
                arr[idx++] = buckets[i][j];
            }
        }
    }

    public static void my_sort(int[] arr){
        //choose a sorting algorithm
        return;
    }


    public static void sort(int[] arr, int bc) {
        int bucketCount = bc;
        List<int> buckets = new ArrayList<int>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Point p : points) {
            int index = (int) ((p.distance / 1000.0) * (bucketCount - 1));  // 0 ~ bucketCount-1
            buckets.get(index).add(p);
        }

        for (List<Point> bucket : buckets) {
            Shell.sort(bucket);
        }

        int idx = 0;
        for (List<Point> bucket : buckets) {
            for (Point p : bucket) {
                points[idx++] = p;
            }
        }
    }
}


