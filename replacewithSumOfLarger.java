class replacewithSumOfLarger{

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

    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null){
            return;
        }

        rwsol(node.right);

        int od = node.data;
        node.data = sum;
        sum += od;

        rwsol(node.left);
    }

    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87}; // sorted array
        Node root = constructor(arr, 0, arr.length-1);
        rwsol(root);
        System.out.println(sum);
    }
}