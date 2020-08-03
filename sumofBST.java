class sumofBST{

    private static class Node{
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

    public static int sumofBST(Node node){
        if(node == null){
            return 0;
        }

        int lsum = sumofBST(node.left);
        int rsum = sumofBST(node.right);

        int osum = lsum + rsum + node.data;

        return osum;
    }

    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};
        Node root = constructor(arr, 0, arr.length-1);
        int sum = sumofBST(root);
        System.out.println(sum);
    }
}