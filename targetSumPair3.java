 // space complexity = logn
 // time complexity = n;
import java.util.Stack;
class targetSumPair3{

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

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
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

    public static void targetSumPair3(Node node, int tar){
        Stack<Pair> ls = new Stack<>();
        Stack<Pair> rs = new Stack<>();

        ls.push(new Pair(node, 1));
        rs.push(new Pair(node, 1));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);
        
        while(left.data< right.data){
            if(left.data + right.data > tar){
                right = getNextFromReverseInorder(rs);
            }else if(left.data + right.data < tar){
                left = getNextFromNormalInorder(ls);
            }else{
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
                
            }
        }
    }

    public static Node getNextFromNormalInorder(Stack<Pair> st){
        while(st.size() >0){
            Pair top = st.peek();
            if(top.state == 1){
                if(top.node.left != null){
                    st.push(new Pair(top.node.left, 1));
                }
                top.state++;
            }else if(top.state == 2){
                if(top.node.right != null){
                    st.push(new Pair(top.node.right, 1));
                }
                top.state++;
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;
    }

    public static Node getNextFromReverseInorder(Stack<Pair> st){
        while(st.size() >0){
            Pair top = st.peek();
            if(top.state == 1){
                if(top.node.right != null){
                    st.push(new Pair(top.node.right, 1));
                }
                top.state++;
            }else if(top.state == 2){
                if(top.node.left != null){
                    st.push(new Pair(top.node.left, 1));
                }
                top.state++;
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] arr = {12,25,40,50,60,75,87}; // sorted array
        Node root = constructor(arr, 0, arr.length-1);
        targetSumPair3(root, 100);
        
    }
}