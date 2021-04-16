class constructBSTFromPostorder{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int idx;
    public static Node buildTree(int[] postorder, int lr, int rr){
        if(idx <  0 || preorder[idx] < lr || preorder[idx] > rr){
            return null;
        }

        Node node = new Node(preorder[idx--], null, null);
        
        node.right = buildTree(preorder, node.data, rr);
        node.left = buildTree(preorder, lr, node.data);

        return node;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = node.left != null ? node.left.data + "" : ".";
        str += " <- " + node.data + " -> ";
        str += node.right != null ? node.right.data + "" : ".";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args){
        int[] postorder = {1, 2, 6, 7, 5, 3};
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;
        idx = postorder.length-1
        Node root = buildTree(postorder, lr, rr);
        display(root);
    }
}
