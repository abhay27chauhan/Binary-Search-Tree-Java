class constructBSTFromPreorder{
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

    static int idx = 0;
    public static Node buildTree(int[] preorder, int lr, int rr){
        if(idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr){
            return null;
        }

        Node node = new Node(preorder[idx++], null, null);

        node.left = buildTree(preorder, lr, node.data);
        node.right = buildTree(preorder, node.data, rr);

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
        int[] preorder = {3, 2, 1, 6, 5, 7};
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;
        Node root = buildTree(preorder, lr, rr);
        display(root);
    }
}
