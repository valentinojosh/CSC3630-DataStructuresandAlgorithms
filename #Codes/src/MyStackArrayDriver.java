public class MyStackArrayDriver {
    public static void main(String[] args) {
        MyStackArray_9_21 mStack = new MyStackArray_9_21();
        System.out.printf("\nFL1 size: %s usedSpace: %s", mStack.getSize(), mStack.getUsedSize());
        mStack.push("Apples");
        System.out.printf("\nFL1 size: %s usedSpace: %s", mStack.getSize(), mStack.getUsedSize());
        mStack.push("Yeet");
        System.out.printf("\nFL1 size: %s usedSpace: %s", mStack.getSize(), mStack.getUsedSize());
        mStack.push("Doubles");
        System.out.printf("\nFL1 size: %s usedSpace: %s", mStack.getSize(), mStack.getUsedSize());
        mStack.push("dooo");
        System.out.printf("\nFL1 size: %s usedSpace: %s", mStack.getSize(), mStack.getUsedSize());

//        try {
//            String item = mStack.pop();
//        } catch( IllegalAccessException e) {
//            System.out.printf("mesg:%s", e.getMessage() );
//            System.exit(1);
//        }
    }
}
