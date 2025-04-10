public class SelectionSort extends AbstractSort
    {
        public static void sort(Comparable[] a)
        {
            int N = a.length;

            for (int i = 0; i < N; i++)
            {
                int min_idx = i;
                for (int j = i; j < N; j++)
                {
                    if (less(a[j], a[min_idx]))
                        min_idx = j;
                }
                exch(a, i, min_idx);
            }
            assert isSorted(a);
        }
    }
