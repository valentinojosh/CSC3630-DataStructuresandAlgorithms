import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String userInput = "";
        while(!userInput.equals("END")){
            System.out.printf("\nEnter string or END to quit:");
            userInput = sc.nextLine();
            if(userInput.length() > 60){
                System.out.printf("Input cannot be greater than 60 characters");
            }else if(!userInput.equals("END")){
                uncompressString(userInput);
            }
        }

    }

    private static void uncompressString(String userInput) {
        char[] chars = userInput.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chars.length; i++){
            if(Character.isDigit(chars[i]) && !Character.isDigit(chars[i+1])){
                int nChar = Integer.parseInt(String.valueOf(chars[i]));
                sb.append(String.valueOf(chars[i + 1]).repeat(Math.max(0, nChar-1)));
            }
            else if(Character.isDigit(chars[i]) && Character.isDigit(chars[i+1])){
                String sChar = String.valueOf(chars[i]).concat(String.valueOf(chars[i+1]));
                int nChar = Integer.parseInt(sChar);
                sb.append(String.valueOf(chars[i + 2]).repeat(Math.max(0, nChar-1)));
                i++;
            }
            else{
                sb.append(chars[i]);
            }
        }
        for(int i = 0; i < sb.length(); i++){
            System.out.printf(String.valueOf(sb.charAt(i)));
            if(i%40 == 0 && i > 0){
                System.out.println();
            }
        }
    }
}
