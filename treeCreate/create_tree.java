import java.util.Scanner;
import java.util.Stack;
class Node {
    int data ;
    Node left ;
    Node right ;

    //constructor 
    Node(int data ){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class create_tree{
    Node create(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value(-1 or no node): ");
        int x = scanner.nextInt();
        if(x == -1 ){
            return null;
        }
        else {
            Node p = new Node(x);
            System.out.println("Enter the left child of "+ x);
            p.left = create();
            System.out.println("Enter the right child of "+x);
            p.right = create();
            return p;
        }

    }

    void inorder(Node root){
        if(root == null){
            return ;
        }
        else {
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
            
        }
    }
    void inorder_without_recur(Node root ){
      Stack<Node> st = new Stack<Node>();
        while(true){
         while(root != null){
             st.push(root);
             root = root.left ;
         }
         if(st.isEmpty()){
             break;
         }
         root = st.pop();
         System.out.print(root.data+" ");
         root = root.right ;
     }   
    }
    void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void preoder_without_recur(Node root){
        Stack<Node> pt = new Stack<Node>();
        while(true ){
            //traverse the left subtree and insert into the stack 
            while(root != null){
                System.out.print(root.data);
                pt.push(root);
                root = root.left;
            }
            if(pt.isEmpty()){
                break;
            }
            root =  pt.pop();
            root = root.right ;

        }
    }
    void postorder(Node root){
        if(root == null){
            return ;
        }
        postorder(root.left);
        postorder(root.right );
        System.out.print(root.data);
    }
    void postorder_without_recur(Node root ){
        Stack<Node> st1 =new Stack<Node>();
        Stack <Node> st2 = new Stack<Node>();
        if (root == null){
            return ;
        }
        st1.push(root);
        while(!st1.isEmpty()){
         Node x = st1.pop();
         st2.push(x);
         if(x.left != null){
             st1.push(root.left);
         }
         if(x.right != null){
             st1.push(root.right);
         }
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop()+"");
        }
    }
    public static void main(String args[]){
    create_tree tree1 = new create_tree();
    Node root = tree1.create();
    // System.out.println("Inorder traversal with recursion ");
    // tree1.inorder(root);
    // System.out.println("preorder traversal without recursion ");
    //  tree1.inorder_without_recur(root);
    // tree1.preorder(root);
    // System.out.println("preorder without recursion ");
    // tree1.preoder_without_recur(root);
    // System.out.println("postorder");
    // tree1.postorder(root);
    // System.out.println("postorder without recursion ");
    // tree1.postorder_without_recur(root);
    }
}