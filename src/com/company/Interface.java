
public interface Interface {

    /**
     *  Full method's descriptions in MyAVL class {@link MyAVL}.
     */


    /*
     *  Insert new value into the tree;
     *      Logic like in a BST Tree but with balancing check.
     */
    MyNode insert(MyNode root, int data);

    /*
     *  Also as in Binary Tree, but with additional checking
     *      is Tree is balanced after deletion. Balance it if not.
     */
    MyNode removeAVL(int toRemove, MyNode root);

    /*
     *  Count number of elements, which smaller than special element.
     *  For all elements in a Tree.
     */
    int smallerelements(MyNode root);

    /*
     *  Check is node is balanced, if not - balance it
     *
     */
    MyNode checkBalanced (MyNode root);

    /*
     *  Return current height if this Node
     */
    int height (MyNode root);

    /*
     *  Max height between two Nodes
     */
    int maxHeight (MyNode root);

    /*
     *  Returns the difference between height of two nodes
     */
    int heightDrop (MyNode root);

}
