public class SegmentTree {
    static class Node{
        int data;
        int leftInterval;
        int rightInterval;
        Node left;
        Node right;
        public Node(int leftInterval,int rightInterval){
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
            this.left = null;
            this.right = null;
        }
    }
    public static Node constructTree(int[] arr,int left,int right){
        if(left == right){
            Node node = new Node(left,right);
            node.data = arr[left];
            return node;
        }
        int mid = (left + right) / 2;
        Node newNode = new Node(left,right);
        newNode.left = constructTree(arr,left,mid);
        newNode.right = constructTree(arr,mid+1,right);
        newNode.data = newNode.left.data + newNode.right.data;
        return newNode;
    }
    public static int query(Node root,int l,int r){
        int leftIndex = root.leftInterval;
        int rightIndex = root.rightInterval;
        if(leftIndex >= l && rightIndex <= r){
            return root.data;
        }else if(rightIndex < l || leftIndex > r){
            return 0;
        }else{
            int left = query(root.left,l,r);
            int right = query(root.right,l,r);
            return left + right;
        }
    }
    public static int update(Node root,int idx,int val){
        int leftIndex = root.leftInterval;
        int rightIndex = root.rightInterval;
        if(idx < leftIndex || idx > rightIndex){
            return root.data;
        }else{
            if(leftIndex == idx && rightIndex == idx){
                root.data = val;
                return root.data;
            }else{
                int left = update(root.left,idx,val);
                int right = update(root.right,idx,val);
                root.data = left + right;
                return root.data;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,4,6,7,4};
        Node root = constructTree(arr,0,arr.length-1);
        System.out.println(root.data);
        System.out.println(query(root,6,8));
        System.out.println(update(root,2,5));
        System.out.println(query(root,1,3));
    }
}