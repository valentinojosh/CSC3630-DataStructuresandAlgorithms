//Author: Josh Valentino
//Date: 10/03/2021
//Course: CSC 3630 w/ Professor David Lash

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TruckManagerDequeMidChange {
    public static void main(String[] args) {
        System.out.println();
        ArrayList<String> rows = getRowsFromFile();
        Deque<truckManagerObject> truckOrderDeque = getRowsAsObjectsDeque(rows);
        printTruckOrder(truckOrderDeque);
        System.out.println();
        Scanner s = new Scanner(System.in);
        boolean search = true;
        while (search){
            System.out.printf("Enter zipcode for search:");
            String userZip = s.nextLine();

            while(!isNumber(userZip)){
                System.out.printf("That input appears to be invalid");
                System.out.printf("\nEnter zipcode for search:");
                userZip = s.nextLine();
            }

            int userZipInt = Integer.parseInt(userZip);
            while( !areThereMatches(userZipInt, truckOrderDeque) ){
                System.out.printf("No trucks match that zipcode");
                System.out.printf("\nEnter zipcode for search:");
                userZip = s.nextLine();
                while(!isNumber(userZip)){
                    System.out.printf("That input appears to be invalid");
                    System.out.printf("\nEnter zipcode for search:");
                    userZip = s.nextLine();
                }
                userZipInt = Integer.parseInt(userZip);
            }

            showTrucksMatchingZip(userZipInt, truckOrderDeque);

            System.out.printf("\nWould you like to remove the first truck for zip: %s (Enter Y or N)", userZip);
            String userRemoveChoice = s.nextLine().toUpperCase();

            while((!userRemoveChoice.equals("Y") && !userRemoveChoice.equals("N"))){
                System.out.printf("Invalid Input, enter again:");
                userRemoveChoice = s.nextLine().toUpperCase();
            }
            if(userRemoveChoice.equals("Y")){
                truckOrderDeque = removeFirstTruckInZip(truckOrderDeque, userZipInt);
            }

            reOrderDeque(truckOrderDeque);
            printUpdatedTruckOrder(truckOrderDeque);

            System.out.printf("\nWould you like to search again (Enter Y or N):");
            String inputAgain = s.nextLine().toUpperCase();
            while((!inputAgain.equals("Y") && !inputAgain.equals("N"))){
                System.out.printf("Invalid Input, enter again:");
                inputAgain = s.nextLine().toUpperCase();
            }
            if(inputAgain.equals("N")){
                search = false;
            }
        }
    }

    private static void printUpdatedTruckOrder(Deque<truckManagerObject> truckOrderDeque) {
        System.out.printf("\n-----Showing Truck List-----");
        for(truckManagerObject y : truckOrderDeque){
            System.out.printf("\nTruck:%s with %s packages for zipcode:%s is in position:%s", y.getTruckID(), y.getNumPackages(), y.getZip(), y.getPosition());
        }
    }

    private static void reOrderDeque(Deque<truckManagerObject> truckOrderDeque) {
        int i = 1;
        for(truckManagerObject o : truckOrderDeque){
            o.setPosition(i);
            i++;
        }
    }

    private static Deque<truckManagerObject> removeFirstTruckInZip(Deque<truckManagerObject> truckOrderDeque, int userZipInt) {
        Deque<truckManagerObject> tempList = new LinkedList<>();
        Deque<truckManagerObject> tempDeque = new LinkedList<>(truckOrderDeque);

        for(truckManagerObject o : truckOrderDeque){
            if(o.getZip() == userZipInt){
                System.out.printf("---- REMOVING truckID:%s zip:%s nPack:%s pos:%s", o.getTruckID(), o.getZip(), o.getNumPackages(), o.getPosition());
                tempDeque.pop();
                for(truckManagerObject o2 : tempList){
                    tempDeque.push(o2);
                }
                break;
            }
            tempList.push(tempDeque.pop());
            System.out.printf("Need to move truckID:%s zip:%s nPack:%s pos:%s", o.getTruckID(), o.getZip(), o.getNumPackages(), o.getPosition());
            System.out.println();
        }
        return tempDeque;
    }

    static boolean areThereMatches(int in, Deque<truckManagerObject> truckOrder)
    {
        int count = 0;
        for(truckManagerObject o : truckOrder){
            if(o.getZip() == in){
                count++;
            }
        }
        return count >= 1;
    }

    static boolean isNumber(String in)
    {
        try
        {
            Integer.parseInt(in);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }

    private static void showTrucksMatchingZip(int userZip, Deque<truckManagerObject> truckOrder) {
        System.out.printf("Matching Trucks:");
        for(truckManagerObject o : truckOrder){
            if(o.getZip() == userZip){
                System.out.printf("\n----Truck:%s with %s packages for zipcode:%s is in position:%s", o.getTruckID(), o.getNumPackages(), o.getZip(), o.getPosition());
            }
        }
    }

    private static void printTruckOrder(Deque<truckManagerObject> truckOrder) {
        System.out.printf("Here is the truck order ----");
        for(truckManagerObject o : truckOrder){
            System.out.printf("\n----pos:%s truckID:%s zipcode:%s number packages:%s", o.getPosition(), o.getTruckID(), o.getZip(), o.getNumPackages());
        }
    }

    public static ArrayList<String> getRowsFromFile(){
        String fName = "input/truckOrder.txt";
        FileIOManagerTruckManager fIO = new FileIOManagerTruckManager(fName);
        try {
            fIO.setFileData();
        } catch( FileNotFoundException e) {
            System.out.printf("\n File not found fName:%s message:%s",
                    fName, e.getMessage());
        }
        return fIO.getFileData();
    }

    public static Deque<truckManagerObject> getRowsAsObjectsDeque(ArrayList<String> rows) {
        Deque<truckManagerObject> myItems = new LinkedList<>();
        for(int i = 0; i < rows.size(); i++){
            String[] toks = rows.get(i).split(",");
            int truckID = Integer.parseInt(toks[0]);
            int zip = Integer.parseInt(toks[1]);
            int numPackages = Integer.parseInt(toks[2]);
            truckManagerObject item = new truckManagerObject( i+1, truckID, zip, numPackages);
            myItems.add( item );
        }
        return myItems;
    }
}
