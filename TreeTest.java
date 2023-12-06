package Trees;
import java.util.*;
public class TreeTest {

    public static TreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
        System.out.println("Enter the root data:");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNode.add(root);
        while(! pendingNode.isEmpty()){
            TreeNode<Integer> front = pendingNode.remove();
            System.out.println("Enter the no of children for: " + front.data);
            int numChild = sc.nextInt();
            for(int i=0;i<numChild;i++){
                System.out.println("Enter the  "+i+" th child data"+ front.data);
                int childData= sc.nextInt();
                TreeNode<Integer> childNode= new TreeNode<>(childData);
                front.children.add(childNode);
                pendingNode.add(childNode);
            }
        }
        return root;
    }

    public static int numberOfNodes(TreeNode<Integer> root){
        int count = 1;
        for(int i = 0; i < root.children.size();i++){
            int childNode = numberOfNodes(root.children.get(i));
            count += childNode;
        }
        return count;
    }

    public static void printTree(TreeNode<Integer> root){

        // This is not base case, it is special case.
        if(root == null){
            return;
        }
        System.out.print(root.data+":");
        for(int i = 0; i < root.children.size(); i++){
            System.out.print(root.children.get(i).data+" ");
        }
        System.out.println();
        for(int i = 0; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }
    public static void main(String[] args) {
        /* 
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);
        */
        TreeNode<Integer> root = takeInput();
        printTree(root);
        System.out.println("Number of Nodes in tree are "+ numberOfNodes(root));
    }
}
