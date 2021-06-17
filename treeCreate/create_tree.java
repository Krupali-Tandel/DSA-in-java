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
         System.out.print(root.data+"");
         root = root.right ;
     }   
    }
    public static void main(String args[]){
    create_tree tree1 = new create_tree();
    Node root = tree1.create();
    // System.out.println("Inorder traversal with recursion ");
    // tree1.inorder(root);
    System.out.println("Inorder traversal without recursion ");
     tree1.inorder_without_recur(root);
    }
}