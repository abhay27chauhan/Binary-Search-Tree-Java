class targetSumPair{

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

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data> data){
            return find(node.left, data);
        }else if(node.data< data){
            return find(node.right, data);
        }else{
            return true;
        }
    }

    public static void targetSumPair(Node root, Node node, int tar){
        if(node == null){
            return;
        }

        targetSumPair(root, node.left, tar);
        int comp = tar - node.data;
        if(node.data< comp){
            if(find(root, comp) == true){
                System.out.println(node.data + " " + comp); 
            }
        }
        targetSumPair(root, node.right, tar);
    }

    public static void main(String[] args){
        int[] arr = {12,25,40,50,60,75,87}; // sorted array
        Node root = constructor(arr, 0, arr.length-1);
        targetSumPair(root, root, 100);
    }
}