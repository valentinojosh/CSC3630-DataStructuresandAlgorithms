import java.util.ArrayList;

//Author: Josh Valentino
//Date: 09/14/2021
//Course: CSC 3630 w/ Professor David Lash

public class SecretCode_HW_Assign {
    public static void main(String[] args) {
        ArrayList<String> inMessages = getStrings();
        ArrayList<StringBuilder> decodedMessages = decodeStrings( inMessages );
        showMessages( inMessages, decodedMessages );
    }


    private static ArrayList<String> getStrings() {
        ArrayList<String> inStrings = new ArrayList<>();
        inStrings.add( "Apple9Wend9aoyn*2tn3ceeee5hyh*4");
        inStrings.add( "asdoxjsdgTuzkjsdftxsdfnkgs");
        inStrings.add( "abmsdfkkjs9f..dkjfozdcc.rz2 sdf9t8hez");
        inStrings.add( "a9Zms9edf1bkkj0razdcc..rZsdftheZ!xlondf");
        inStrings.add( "zapp8l8ohs9w9");
        inStrings.add( "kjsdfxkjdfkjozkjsfdkjuzkjsdfkjnzkjfdfkdx");
        inStrings.add( "kjsdfxkjdfkjozkjsfdkjuzkjsdfkjnzkjfdfkdx");
        inStrings.add( "appleSauce");
        inStrings.add( "z9");
        return inStrings;
    }

    private static ArrayList<StringBuilder> decodeStrings(ArrayList<String> inMessages) {
        ArrayList<StringBuilder> deCoded = new ArrayList<>();
        for(String item: inMessages ){

            StringBuilder deCode = new StringBuilder();

            //Preventing out of bounds error by accounting for strings of length 0 and 1
            if( item.length() == 0 || item.length() == 1 ){
                //deCode = item;
                deCode.append(item);
            }
            else{
                for(int i = 0; i < item.length(); i++){
                    if ( (item.charAt(i) == 'x' || item.charAt(i) == 'z') && (i != 0) ){
                        deCode.append(item.charAt(i-1));
                    }
                    if ( (item.charAt(i) == '0' || item.charAt(i) == '1' || item.charAt(i) == '2' ||
                            item.charAt(i) == '3' || item.charAt(i) == '4' || item.charAt(i) == '5' || item.charAt(i) == '6'
                            || item.charAt(i) == '7' || item.charAt(i) == '8' || item.charAt(i) == '9') && (i != item.length()-1) ){
                        deCode.append(item.charAt(i+1));
                    }
                }

            }
            deCoded.add(new StringBuilder(deCode));
        }

        return deCoded;
    }

    private static void showMessages(ArrayList<String> inMessages, ArrayList<StringBuilder> decodedMessages) {
        for(int i = 0; i < inMessages.size(); i++){
            System.out.printf("\n Coded: %s - Decoded: %s",inMessages.get(i),decodedMessages.get(i));
        }
        System.out.print("\n");
    }
}

