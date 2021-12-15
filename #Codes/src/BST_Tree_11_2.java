public class BST_Tree_11_2 {
    BSTNode_11_2 root = null;
    public void addNode( int key, String name){
        BSTNode_11_2 newNode = new BSTNode_11_2( key, name);
        if (  root == null ){
            root = newNode;
        } else {
            // Not an empty
            //  figure out where to put it
            BSTNode_11_2 focusNode = root;
            BSTNode_11_2 parent = null;
            while( true ){
                parent = focusNode; // first time this is root
                if ( key < focusNode.key ) {
                    // then we are going left !
                    focusNode = focusNode.leftChild;
                    if ( focusNode == null ){
                        // focus nod has no childres
                        //  set parent.leftChild to the newNode
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    // then we are going right !
                    focusNode = focusNode.rightChild;
                    if ( focusNode == null ) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }
}
