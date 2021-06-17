import java.util.Scanner;
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
        scanner.close();
    }
    public static void main(String args[]){
    create_tree tree1 = new create_tree();
    tree1.create();
    }
}