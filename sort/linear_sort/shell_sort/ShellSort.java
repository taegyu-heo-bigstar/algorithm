public class ShellSort extends AbstractSort{
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;

        while(h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
    
    //this function is for the test
    public static void sort(Comparable[] a, int[] h_seq){
        if (h_seq[0] != 1) return;
        
        int N = a.length;
        int idx = h_seq.length;
        int h = h_seq[idx];
        
        while(h >= 1){
            for (int i = 0; i < N; i++){
                for (int j = i; j > h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            h = h_seq[--idx];
        }            
    }
}
