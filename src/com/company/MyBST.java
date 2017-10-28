
public class MyBST {


    /**
     * Insert new element int (data) into a tre with root MyNode (root)
     * @param root MyNode element
     * @param data int value
     * @return MyNode - new BST with inserted vaule
     */
    public MyNode insert(MyNode root , int data){
        if (root == null){
            root = new MyNode();
            root.value = data;
        }
        else if (data > root.value){
            root.right = insert(root.right, data);
        }
        else{
            root.left = insert(root.left, data);
        }

        return root;
    }


    /**
     * InOrder traversal through the tree with root MyNode root
     * @param root MyNode element
     * @return String - all elements of tree (InOrder)
     */
    public String inOrderTrav(MyNode root){
        String str = "";

        if (root.left != null)
            str += inOrderTrav(root.left);

        str += root.value + " ";

        if (root.right != null)
            str += inOrderTrav(root.right);

        return str;

    }


    /**
     * Linear search in BST for value toFind
     * @param root MyNode element
     * @param toFind int value
     * @return String - all founded elements with key toFind
     */
    public String findVal(MyNode root, int toFind){
        MyNode curr = root;

        String str = "";

        while(curr != null){
            if (curr.value == toFind)
                str += curr.value + " ";

            if (toFind > curr.value)
                curr = curr.right;
            else
                curr = curr.left;
        }

        if (str == "")
            return null;
        else
            return (str.substring(0, str.length()-1));
    }


    /**
     * Delete element (if it is in tree). Recursive.
     * @param root - element of type MyNode
     * @param toRemove - value must be removed
     * @return MyNode - parsed BST
     */
    public MyNode remove (MyNode root, int toRemove)
    {

        /*
            There are possible 3 cases of deletion:
                1. removable node is leaf;
                2. removable node has only one child;
                3. removable node has both children.
         */

        // if value to remove is not in tree - return initial tree;
        if (root == null)
            return root;


        if (root.value != toRemove) {
            if (toRemove > root.value)
                root.right = remove(root.right, toRemove);
            else
                root.left = remove(root.left, toRemove);
        }
        else {
            root = removeNode(root);
        }



        return root;
    }

    protected MyNode removeNode(MyNode root){
        // first case:
        if (root.left == null && root.right == null) {
            root = null;
            return root;
        }

        // second case:
        else if (((root.left == null && root.right != null) || (root.left != null && root.right == null))) {
            if (root.left != null) {
                return root.left;
            } else
                return root.right;
        }

        // third case:
        else {
            root.value = findMinRight(root.right);
            root.right = remove(root.right, root.value);
            return root;
        }

    }

    // find minimum element in right subtree:
    private int findMinRight(MyNode root){
        if (root.left == null){
            return root.value;
        }
        else
            return findMinRight(root.left);
    }

    public String print(MyNode root, int len){
        MyNode[] arr = new MyNode[len*2+4];
        String str = "";
        if (root != null) {
            arr[0] = root;

            for (int i = 0; i <= len; i++){
                if (arr[i] != null) {
                    arr[i * 2 + 1] = arr[i].left;
                    arr[i * 2 + 2] = arr[i].right;
                }
            }

            for(int i = 0; i <= len; i++){
                if (arr[i] != null){
                    if (arr[i*2+1] != null || arr[i*2+2] != null) {
                        str += arr[i].value + " ";

                        if (arr[i*2+1] != null)
                            str += arr[i*2+1].value + " ";

                        if (arr[i*2+2] != null)
                            str += arr[i*2+2].value + " ";

                        str += "\n";
                    }
                }
            }
        }

        return str;
    }




    public MyNode mirror(MyNode root){
        MyNode swap;

        if (root == null)
            return root;

        swap = root.left;
        root.left = root.right;
        root.right = swap;

        if (root != null) {
            root.right = mirror(root.right);
            root.left = mirror(root.left);
        }

        return root;
    }

}
