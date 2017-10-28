
public class MyAVL extends MyBST implements Interface {


    /**
     * Insert new value into the tree;
     * Logic like in a BST Tree but with balancing check.
     * Thats why this method need to be Overridden
     * @param root MyNode element
     * @param data int value
     * @return MyNode Node - full tre with inserted element
     */
    @Override
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

        root.height = maxHeight(root) + 1;

        root = checkBalanced(root);

        return root;

    }


    /**
     * Also as in Binary Tree, but with additional checking
     *  is Tree is balanced after deletion. Balance it if not.
     * @param toRemove int value to delete from Tree
     * @param root MyNode Node - Tree before deletion
     * @return MyNode Node - Tree after deletion
     */
    public MyNode removeAVL(int toRemove, MyNode root){
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

        root = checkBalanced(root);

        root.height = maxHeight(root) + 1;


        return root;

    }

    /**
     * Check is node is balanced, if not - balance it
     * @param root MyNode Node - before check
     * @return MyNode Node - after check
     */
    public MyNode checkBalanced(MyNode root){
        /*

            There are possible 4 cases of unbalanced issue:

            Left LEft
            Right Right
            Left Right
            Right Left

            All of them need to be rotated in special ways:

         */

        // if height of the left is greater than of the right one by more than 1 (unbalanced)
        if (heightDrop(root) > 1){

            /*                        O
            *  Left Left Rotation:   O
            *                       O
            */
            if (heightDrop(root.left) == 1){
                root = LLRotation(root);
            }
            /*                        O
            *  Left Right Rotation:  O
            *                         O
            */
            else {
                root = LRRotation(root);
            }
        }

        // if height of the left is less than of the right one by more than 1 (unbalanced)
        if (heightDrop(root) < -1){
            /*                        O
            *  Right Right Rotation:   O
            *                           O
            */
            if (heightDrop(root.right) == -1){
                root = RRRotation(root);
            }
            /*                        O
            *  Right Left Rotation:    O
            *                         O
            */
            else {
                root = RLRotation(root);

            }
        }

        return root;
    }

    /**
     * Count number of elements, which smaller than special element.
     * For all elements in a Tree.
     * @param root  MyNode - root of a Tree
     * @return int - number of smallerelements
     */
    public int smallerelements(MyNode root){
        String str;
        String[] strArr;
        int summ = 0;

        str = inOrderTrav(root);
        strArr = str.split(" ");


        for (int i=strArr.length-1; i>0; i--){
            summ += i;
        }

        return summ;
    }


    /**
     * Stupid Left Left Rotation
     * @param root MyNode Node need to be rebalanced
     * @return new (rebalanced) MyNode Node
     */
    private MyNode LLRotation (MyNode root){
        MyNode newNode;

        newNode = root.left;

        root.left = newNode.right;
        newNode.right= root;

        root.height = maxHeight (root) + 1;
        if(root.height > height(newNode.left))
            newNode.height = root.height + 1;
        else
            newNode.height = height(newNode.left) + 1;

        return newNode;
    }

    /**
     * Right Right Rotation
     * @param root MyNode Node need to be rebalanced
     * @return new (rebalanced) MyNode Node
     */
    private MyNode RRRotation (MyNode root){
        MyNode newNode;

        newNode = root.right;

        root.right = newNode.left;
        newNode.left = root;

        root.height = maxHeight (root) + 1;
        if(root.height > height(newNode.right))
            newNode.height = root.height + 1;
        else
            newNode.height = height(newNode.right) + 1;

        return newNode;
    }

    /**
     * Left Right Rotation
     * @param root MyNode Node need to be rebalanced
     * @return new (rebalanced) MyNode Node
     */
    private MyNode LRRotation (MyNode root){
        MyNode newNode;

        root.left = RRRotation(root.left);

        newNode = LLRotation(root);

        return newNode;
    }


    /**
     * Right Left Rotation
     * @param root MyNode Node need to be rebalanced
     * @return new (rebalanced) MyNode Node
     */
    private MyNode RLRotation (MyNode root){
        MyNode newNode;

        root.right = LLRotation(root.right);

        newNode = RRRotation(root);

        return newNode;
    }

    /**
     * Returns the difference between height of two nodes
     * @param root MyNode Node
     * @return int difference
     */
    public int heightDrop(MyNode root){
        if (root == null)
            return 0;
        else
            return (height(root.left) - height(root.right));
    }

    /**
     * Max height between two Nodes
     * @param root MyNode Node
     * @return int max height
     */
    public   int maxHeight(MyNode root){

        if (height(root.left) > height(root.right))
            return height(root.left);
        else
            return height(root.right);

    }


    /**
     * Return current height if this Node
     * @param node MyNode Node
     * @return int height
     */
    public int height(MyNode node){
        if (node != null)
            return node.height;
        else
            return -1;
    }

}
