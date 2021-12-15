public class BST_preorder_practice {
    public static void main(String[] args) {
        BST_Tree_11_2 theTree = new BST_Tree_11_2();
        theTree.addNode(50, "The Boss");
        theTree.addNode(25, "VP");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(70, "Sales Manager");
        theTree.addNode(85, "SalesPersion");
        //preOrderTraverse( theTree.root );
        postOrderTraverse( theTree.root );
    }

    private static void postOrderTraverse(BSTNode_11_2 focusNode) {
        if ( focusNode != null ) {
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.printf("\n Key:%s val:%s", focusNode.key, focusNode.name);
        }
    }

    private static void preOrderTraverse(BSTNode_11_2 focusNode ) {
         if ( focusNode != null ) {
             System.out.printf("\n Key:%s val:%s", focusNode.key, focusNode.name);
             preOrderTraverse(focusNode.leftChild);
             preOrderTraverse(focusNode.rightChild);
         }
    }
}
