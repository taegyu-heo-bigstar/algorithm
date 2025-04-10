public class ShellSort extends AbstractSort{
    //generally usde h-sequence
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
    
    //user define h-sequence
    public static void sort(Comparable[] a, int[] h_seq){
        if (h_seq[0] != 1) return;
        
        int N = a.length;    if (h_seq[N-1] > N) return;
        int idx = h_seq.length;
        int h = h_seq[idx];
        
        while(true){
            for (int i = 0; i < N; i++){
                for (int j = i; j > h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            if (idx == 0) break;
            h = h_seq[--idx];
        }            
    }
}
