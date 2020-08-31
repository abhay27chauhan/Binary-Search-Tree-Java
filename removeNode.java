class removeNode{

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

    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }else{
            return node.data;
        }
    }

    public static Node removeNode(Node node, int val){
        if(node == null){
            return null;
        }
        
        if(val < node.data){
            node.left = removeNode(node.left, val);
        }else if(val> node.data){
            node.right = removeNode(node.right, val);
        }else{
            if(node.left != null && node.right != null){
                int lmax = max(node.left);
                node.data = lmax;
                node.left = removeNode(node.left, lmax);
                return node;
            }else if(node.left != null){
                return node.left;
            }else if(node.right != null){
                return node.right;
            }else{
                return null;
            }
        }
        return node;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.left == null ? "." : node.left.data);
        System.out.print(" <- " + node.data + " -> ");
        System.out.print(node.right == null ? "." : node.right.data);

        System.out.println();
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87}; // sorted array
        Node root = constructor(arr, 0, arr.length-1);
        display(root);
        System.out.println();
        removeNode(root, 25);
        display(root);
    } 
}