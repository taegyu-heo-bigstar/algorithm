packeage sort;

    public class example_case{
        public static void class main(String[] args){
           
            Scanner sc = new Scanner(System.in);
            System.out.println("입력 파일 이름? ");
            String fname = sc.nextLine();
            sc.close();
            
            try {
                sc = new Scanner(new File(fname));
                int input_data = sc.nextInt();  // file에서 정수를 읽어 input_data에 저장
                                                // 이후 sc.nextInt()를 이용하여 계속 정수 입력} catch (IOException e) { System.out.println(e); return; }
                if (sc != null) sc.close();
            }
    }
