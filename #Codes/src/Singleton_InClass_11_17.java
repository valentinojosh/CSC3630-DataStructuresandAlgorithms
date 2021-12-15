public class Singleton_InClass_11_17 {
    private static Singleton_InClass_11_17 instance = new Singleton_InClass_11_17();
    private Singleton_InClass_11_17(){
        System.out.printf("Constructing");
    }
    public static Singleton_InClass_11_17 getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.printf("\nHello there from singleton");
    }
}

