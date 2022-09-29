public class BinaryTree { 
    
public class Node {
    	
        char key;
        Node left, right;
 
        public Node(char m) {
            key = m;
            left = null;
            right = null;
        }
    }

    Node root;
    BinaryTree() {
    	
        root = null;
    }
    void insert(char key)
    {
        root = insert(root, key);
    }

    Node insert(Node root, char key) {
    	
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        if (key < root.key)
            root.left = insert(root.left, key);
        
        else if (key > root.key)
            root.right = insert(root.right, key);
 
        return root;
    }
    
    void sortorder(Node root) {
        if (root != null)
        {
            sortorder(root.left);
            System.out.print(root.key + " ");
            sortorder(root.right);
        }
    }
    void treeins(char arr[]) {
    	
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }   
    }
    
    void preorder(Node n) {
		if(n==null)
			return;
		
		System.out.print(n.key+" ");
		preorder(n.left);
		preorder(n.right);
	}
    
	void postorder(Node n) {
			if(n==null)
				return;
			
		postorder(n.left);
		postorder(n.right);
		System.out.print(n.key+" ");
	}

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        char arr[] = {'y', 'f', 'k', 'm','s','d' };
        tree.treeins(arr);
        
        System.out.println("Sorted Order:");
        tree.sortorder(tree.root);
        
        System.out.println("\nPreorder:");
	    tree.preorder(tree.root);
	    
	    System.out.println("\nPostorder:");
	    tree.postorder(tree.root);
    }
}