public class BST_11_10 {
    // Actual tree made up of BSTNode_11_10
    BSTNode_11_10 root;
    public void addNode( int key, String name ) {
        BSTNode_11_10 newNode = new BSTNode_11_10( key, name);
        if ( root == null ){
            root = newNode;
            System.out.printf("\n Added as root");
        } else {
            // Tree is not empty
            //  find the place to insert the new nood
            // Keep track of the root
            BSTNode_11_10 focusNode = root;
            BSTNode_11_10 parent;
            //      50
            //      /
            //     25
            //    /
            //   15
            while( true ){
                parent = focusNode;  // 50
                if ( key < focusNode.key ){
                    // go left
                    focusNode = focusNode.leftChild;
                    if ( focusNode == null ){
                        // leftChild has no childer
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    // key > focusNode.key Have to go gith
                    focusNode = focusNode.rightChild;
                    if ( focusNode == null ){
                        // leftChild has no childer
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}
