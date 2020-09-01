 // space complexity = n
 // time complexity = n;
import java.util.ArrayList;
class targetSumPair2{

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

    public static void targetSumPair2(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }

        targetSumPair2(node.left, list);
        list.add(node.data);
        targetSumPair2(node.right, list);
        
    }

    public static void main(String[] args){
        int[] arr = {12,25,40,50,60,75,87}; // sorted array
        Node root = constructor(arr, 0, arr.length-1);
        ArrayList<Integer> list = new ArrayList<>();
        targetSumPair2(root, list);
        int tar = 100;
        int left=0;
        int right = list.size()-1;

        while(left < right){
            if(list.get(left) + list.get(right) <tar){
                left++;
            }else if(list.get(left) + list.get(right) >tar){
                right--;
            }else{
                System.out.println(list.get(left) + " " + list.get(right));
                left++;
                right--;
            }
        }
    }
}