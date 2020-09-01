class printInRange{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node constructor(int[] arr, int lo, int hi){
        if(lo>hi){
            return null;
        }

        int mid = (lo+hi)/2;
        int data = arr[mid];

        Node lc = constructor(arr, lo, mid-1);
        Node rc = constructor(arr, mid+1, hi);

        Node node = new Node(data, lc, rc);

        return node;
    }

    public static void printInRange(Node node, int d1, int d2){
        if(node == null){
            return;
        }

        if(node.data> d1 && node.data >d2){
            printInRange(node.left, d1, d2);
        }else if(node.data< d1 && node.data<d2){
            printInRange(node.right, d1, d2);
        }else{
            printInRange(node.left, d1, d2);
            System.out.println(node.data);
            printInRange(node.right, d1, d2);
        }
    }

    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87}; // sorted array
        Node root = constructor(arr, 0, arr.length-1);
        printInRange(root, 27, 70);
    }
}