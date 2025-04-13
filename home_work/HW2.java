public class HW2
{
    class Node<K,V> {
        int N; // 자손 노드 + 1 (ordered 연산)
        int aux: // AVL 트리나 RB 트리에 사용
        Node<K,V> parent; // AVL or RB
        
        public Node(K key, V val) {
            this.key = key; this.value = val;
            this.N = 1; 
        }

        public int getAux(){ return aux; }
        public void setAux(int value) { aux = value; }
    }

    class BST<K extends Comparable<K>, V> {
        protected Node<K,V> root;

        protected Node<K,V> treeSearch(K key) {
            Node<K,V> x = root; // BST에 대한 모든 연산은 루트부터 시작
            while (true) {
                int cmp = key.compareTo(x.key);
                if (cmp == 0) return x; // 찾았으면, 순회 종료
                else if (cmp < 0) { // x.key보다 작을 경우, 왼쪽으로
                    if (x.left == null) return x; // 없으면, 순회 종료
                    else x = x.left;
                }       
                else { // x.key보다 클 경우, 오른쪽으로
                    if (x.right == null) return x; // 없으면, 순회 종료
                    else x = x.right;
                }
            }
        }

        public int size() { return (root != null) ? root.N : 0; }

        public V get(K key) {
            if (root == null) return null;
            Node<K,V> x = treeSearch(key);
            if (key.equals(x.key))
                return x.value;
            else
                return null;
        }

        public void put(K key, V val) {
            if (root == null) { root = new Node<K,V>(key, val); return; }
            Node<K,V> x = treeSearch(key);
            int cmp = key.compareTo(x.key);
            if (cmp == 0) x.value = val;
            else {
                if (cmp < 0) x.left = newNode;
                else x.right = newNode;
                newNode.parent = x;
                rebalanceInsert(newNode);

            }
        }

        public Iterable<K> keys() {
            if (root == null) return null;
            ArrayList<K> keyList = new ArrayList<K>(size());
            inorder(root, keyList);
            return keyList;
        }

        private void inorder(Node<K,V> x, ArrayList<K> keyList) {
            if (x != null) {
                inorder(x.left, keyList);
                keyList.add(x.key);
                inorder(x.right, keyList);
            }
        }

        public void delete(K key) {
            if (root == null) return;
                Node<K,V> x, y, p;
            x = treeSearch(key);
            if (!key.equals(x.key))
                return;
            if (x == root || isTwoNode(x)) {
                if (isLeaf(x))
                    { root = null; return; }
                else if (!isTwoNode(x)) {
                    root = (x.right == null) ?
                    x.left : x.right;
                    root.parent = null;
                    return;
                }
                else {
                    relink(p, y.right, y == p.left);
                }
            }
            else {
                p = x.parent;
                if (x.right == null)
                    relink(p, x.left, x == p.left);
                else if (x.left == null)
                    relink(p, x.right, x == p.left);
                rebalanceDelete(p, x);
            }
        }
        
        public boolean contains(K key) {return get(key) != null; }

        public boolean isEmpty() {return root == null; }
           
        protected boolean isLeaf(Node<K,V> x)
        { return x.left == null && x.right == null; }

        protected boolean isTwoNode(Node<K,V> x)
        { return x.left != null && x.right != null; }

        protected void relink(Node<K,V> parent, Node<K,V> child, boolean makeLeft) {
            if (child != null) child.parent = parent;
            if (makeLeft) parent.left = child;
            else parent.right = child;
        }

        protected Node<K,V> min(Node<K,V> x) { while (x.left != null) x = x.left; return x; }
        
        public K min() {
            if (root == null) return null;
            Node<K,V> x = root;
            while (x.left != null)
            x = x.left;
            return x.key;
            }

        public K max() {
            if (root == null) return null;
            Node<K,V> x = root;
            while (x.right != null)
            x = x.right;
            return x.key;
        }

        public K floor(K key) {
            if (root == null || key == null) return null;
            Node<K,V> x = floor(root, key);
            if (x == null) return null;
            else return x.key;
        }

        private Node<K,V> floor(Node<K,V> x, K key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node<K,V> t = floor(x.right, key);
            if (t != null) return t;
            else return x;
        }

        private int size(Node<K,V> x) { return (x != null) ? x.N : 0; }

        public int size(K lo, K hi) {
            if (lo == null || hi == null) return 0;
            if (hi.compareTo(lo) < 0) return 0;
            if (contains(hi)) return rank(hi) - rank(lo) + 1;
            else return rank(hi) - rank(lo);
        }

        public K ceiling(K key) {
            if (root == null || key == null) return null;
            Node<K,V> x = ceiling(root, key);
            return (x != null) ? x.key : null;
        }

        private Node<K,V> ceiling(Node<K,V> x, K key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp > 0) return ceiling(x.right, key);
            Node<K,V> t = ceiling(x.left, key);
            return (t != null) ? t : x;
        }


        public K select(int rank) {
            if (root == null || rank < 0 || rank >= size())
                return null;
            Node<K,V> x = root;
                while (true) {
                int t = size(x.left);
                if (rank < t)
                    x = x.left;
                else if (rank > t) {
                    rank = rank - t - 1;
                    x = x.right;
                }
                else
                    return x.key;
            }
        }

        public int rank(K key) {
            if (root == null || key == null) return 0;
                Node<K,V> x = root;
                int num = 0;
            while (x != null) {
                    int cmp = key.compareTo(x.key);
                if (cmp < 0) x = x.left;
                else if (cmp > 0) {
                    num += 1 + size(x.left);
                    x = x.right;
                }
                else {
                    num += size(x.left); break;
                }
            }
            return num;
        }

        public void deleteMin() { delete(min()); }
        public void deleteMax() { delete(max()); }
        
        public Iterable<K> keys(K lo, K hi) {
            ArrayList<K> list = new ArrayList<>();
            keys(root, list, lo, hi);
            return list;
        }

        private void keys(Node<K,V> x, ArrayList<K> list, K lo, K hi) {
            if (x == null) return;
            int cmpLo = lo.compareTo(x.key);
            int cmpHi = hi.compareTo(x.key);

            if (cmpLo < 0) keys(x.left, list, lo, hi);
            if (cmpLo <= 0 && cmpHi >= 0) list.add(x.key);
            if (cmpHi > 0) keys(x.right, list, lo, hi);
        }

    }

    public void readFile_and_makeBST(BST bst, String fname){
        private String key;
        private int val;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            List<String> tokens = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " \t\n=;,<>()");

                while (st.hasMoreTokens()) {
                    tokens.add(st.nextToken());
                }
            }
            br.close();

            for (int i = 0; i <= tokens.size() - 5; i++) {
                List<String> window = tokens.subList(i, i + 5);
                key = String.join(" ", window);
                if (val = bst.get(key)) {bst.put(key, val + 1);}
                else {bst.put(key, 1)}
            }

        } catch (IOException e) {
            System.out.println("파일을 읽을 수 없습니다: " + e);
        }
    }

    class cheker{
        private int shingle = 0;
        private double similarity = 0.0;

        private static void show(String f_A_name, String f_B_name){
            System.out.println("두 파일에서 공통된 shingle의 수 = " + shingle);
            System.out.println(f_A_name + "과" + f_B_name + "의 유사도 = " + similarity);
        }

        public static void run(BST bst_A, BST bst_B, String f_A_name, String f_B_name){
            ArrayList<String> keys = bst_A.keys();
            if (keys == null) {
                if (bst_B.keys() == null){
                    similarity = 100.0;
                    show(f_A_name, f_B_name);
                }
                else{
                    show(f_A_name, f_B_name);
                }
            }
            else if(bst_B.keys() == null){
                show(f_A_name, f_B_name);
            }

            String key;
            int val_a;
            int val_b;
            for (key : keys){
                val_a = bst_A.get(key);
                val_b = bst_B.get(key);

                if (val_a == null || val_b == null)
                    continue;

                similarity = (Math.min(val_a, val_B) / Math.max(val_a, val_b);)
            }
            similarity /= keys.size();

            show(f_A_name, f_B_name);
        }
    }

    public static void main(string args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("입력 파일 A 이름? ");
        String f_A_name = sc.nextLine();

        System.out.println("입력 파일 B 이름? ");
        String f_B_name = sc.nextLine();

        sc.close();

        BST bst_A = new BST();
        BST bst_B = new BST();

        readFile_and_makeBST(bst_A, f_A_name);
        readFile_and_makeBST(bst_B, f_B_name);

        System.out.println("파일" + f_A_name + "의 Shingle의 수 = " + bst_A.size(););
        System.out.println("파일" + f_B_name + "의 Shingle의 수 = " + bst_B.size(););
    }
}
