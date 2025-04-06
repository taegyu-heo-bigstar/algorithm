packeage sort;

public class example_case{

    public class Point {
        public final double x;
        public final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point other) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            
            return Math.sqrt(dx * dx + dy * dy);
        }
    }


    public static void class main(String[] args){
        
        //input file name
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 파일 이름? ");
        String fname = sc.nextLine();
        System.out.println("");
        sc.close();

        //read file
        //create origin, k, n and another Points
        try {
            sc = new Scanner(new File(fname));

            double num1 = sc.nextDouble();
            double num2 = sc.nextDouble();

            Point origin = new Point(num1, num2);
            int k = sc.nextInt();
            int n = sc.nextInt();

            Point[] point_arr = new Point[n];
            for (int i = 0; i < n; i++){
                while (sc.hasNextDouble()) {
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                }
                point_arr[i] = new Point(num1, num2); 
            }
        }
        catch (IOException e) { System.out.println(e); return; }

        //calculate distance origin from other Point
        double[] dis_arr = new double[n];
        for (int i = 0; i<n; i++){
            dis_arr[i] = origin.distanceTo(point_arr[i])
        }

        long sorting_start = System.currentTimeMillis();
        sort(dia_arr);
        long sorting_end = System.currentTimeMillis();

        System.out.print("k = " + {k} + "일 때의 실행시간 = " + {sorting_end - sorting_start});


        
        if (sc != null) sc.close();
        
    }
}
