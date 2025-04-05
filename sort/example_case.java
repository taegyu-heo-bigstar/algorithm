packeage sort;

public class example_case{

    public class Point<X, Y> {
        public final X x;
        public final Y y;

        public Point(X x, Y y) {
            this.x = x;
            this.y = y;
            }
    }

    public static double cal_dis(Point origin, Point[] Points){
        
    }

    public static void class main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 파일 이름? ");
        String fname = sc.nextLine();
        System.out.println("");
        sc.close();
        
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
                point_arr[i] = new point(num1, num2); 
            }
        }
        catch (IOException e) { System.out.println(e); return; }

        

        System.out.print("k = " + {k} + "일 때의 실행시간 = ");


        
        if (sc != null) sc.close();
        
    }
}
