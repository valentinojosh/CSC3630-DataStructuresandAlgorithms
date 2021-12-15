import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Author: Josh Valentino
//Date: 10/15/2021
//Course: CSC 3630 w/ Professor David Lash

public class AllStarBaseball_Valentino {
    public static int runCount = 0;
    public static int inningCount = 1;

    public static void main(String[] args) {

        Queue<BaseballObject> Players = getThePlayers();
        boolean determinePlay = true;

        while(determinePlay){
            Players = playInning(Players);
            if( !askCont() ){
                determinePlay = false;
            }
            if(inningCount > 9){
                break;
            }
        }

    }

    private static Queue<BaseballObject> playInning(Queue<BaseballObject> players) {
        int outs = 0;
        int hits = 0;
        int inningRuns = 0;
        Queue<BaseballObject> tempQ2 = new LinkedList<>();

        while(outs < 3){

            double percentGenerated = Math.random();

            DecimalFormat df = new DecimalFormat("0.000");
            String printPercentGenerated = df.format(percentGenerated);

            assert players.peek() != null;
            System.out.printf("\n%s is up to bat (Generated%%: %s, %%Hit: %s) --- ", players.peek().getPlayer(), printPercentGenerated, players.peek().getBatAvg());

            assert players.peek() != null;
            if( percentGenerated < players.peek().getBatAvg()){
                System.out.printf("Hit!");
                hits++;
            }
            else{
                outs++;
                System.out.printf("Out! --- Total Outs: %s", outs);
            }

            tempQ2.add(players.remove());
            players.add(tempQ2.remove());
        }
        if(hits >= 4){
            runCount += (hits-3);
            inningRuns += (hits-3);
        }

        System.out.printf("\n3rd out. Inning over.");
        System.out.printf("\nHits this inning: %s - Runs this inning: %s", hits, inningRuns);

        inningCount++;

        return players;
    }

    private static boolean askCont() {
        if(inningCount > 9){
            System.out.printf("\nRuns: %s - 9th Inning Completed. The Game is over", runCount);
            return false;
        }
        else{
            System.out.printf("\nRuns: %s - Upcoming Inning: %s --- Play another inning? (Enter Y or N)", runCount, inningCount);
        }
        Scanner s = new Scanner(System.in);
        String userChoice = s.nextLine().toUpperCase();
        while( (!userChoice.equals("Y")) && (!userChoice.equals("N")) ){
            System.out.printf("\nInput Invalid. Enter again (Y or N):");
            userChoice = s.nextLine().toUpperCase();
        }
        if(userChoice.equals("Y")){
            return true;
        }
        else{
            return false;
        }
    }

    private static Queue<BaseballObject> getThePlayers() {
        Queue<BaseballObject> tempQ = new LinkedList<>();
        tempQ.add(new BaseballObject(1, "Ty Cobb", .366));
        tempQ.add(new BaseballObject(2, "Rogers Hornsby", .359 ));
        tempQ.add(new BaseballObject(3, "Joe Jackson", .356));
        tempQ.add(new BaseballObject(4, "Ted Williams", .344));
        tempQ.add(new BaseballObject(5, "Lefty O'Doul", .349));
        tempQ.add(new BaseballObject(6, "Babe Ruth", .342));
        tempQ.add(new BaseballObject(7, "Lou Gehrig", .340));
        tempQ.add(new BaseballObject(8, "Joe DiMaggio", .323));
        tempQ.add(new BaseballObject(9, "Tony Gwynn", .339));
        return tempQ;
    }

}
