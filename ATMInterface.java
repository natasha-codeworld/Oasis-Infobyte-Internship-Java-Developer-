import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.text.SimpleDateFormat;  
import java.util.Date; 
public class ATMInterface{
    private static String FILE_NAME = "transactionDetails.txt";
    private static void displayMenu(){
        System.out.println("ATM Interface");
        System.out.println("------------------------");
        System.out.println("1.Transaction History");
        System.out.println("2.Withdraw");
        System.out.println("3.Deposit");
        System.out.println("4.Transfer");
        System.out.println("5.Exit");
        System.out.println("------------------------");

    }
    private static void transactionHistory(){
      
      boolean first = true ;
      try {
         BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
         String line= reader.readLine();
         while((line= reader.readLine()) != null) {
            if (first) {
               first = false;
            }
            else{
               String[] transactions = line.split(",");
               System.out.println("Transaction id: " + transactions[0]);
               System.out.println("Account Number: " + transactions[1]);
               System.out.println("Transaction amount:" + transactions[2]);
               System.out.println("Date:" + transactions[3]);
               //System.out.println("Time:" + transactions[4]);
               System.out.println("----------------------");
            }
         }
         reader.close();
         } 
         catch (IOException e) {
         System.out.println("Error occurred while displaying account details.");
         }
    }
    private static void withdrawMoney(){
        System.out.println("withdraw");
    }
    private static void depositMoney(){
       System.out.println("deposit");
    }
    private static void transferMoney(){
      try{
         PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME,true));
         StringBuilder fileContents = new StringBuilder();
         BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
         //FileWriter writer = new FileWriter(FILE_NAME);
         Scanner sc = new Scanner(System.in);
         UUID transactionid = UUID.randomUUID();
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
         Date date = new Date();  
         System.out.print("Enter account number for transfer: ");
         String accountNumber = sc.nextLine();
         System.out.print("Enter amount to be transfered: ");
         float amount = sc.nextFloat();
         String line = reader.readLine();
         String[] details = line.split(",");
         float currBalance = Float.parseFloat(details[3]);
         if(amount <= currBalance){
               currBalance -= amount;
               details[3] = String.valueOf(currBalance);
               fileContents.append(String.join(",", details)).append("\n");
         }
         else{
              System.out.println("Not enough balance!");
         }
         writer.println(transactionid+","+accountNumber+",-Rs"+amount+","+formatter.format(date));
         System.out.println("Amount successfully transfered");
         writer.close();
      }
     catch(IOException e){
         e.getMessage();
     }

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int choice;
        do{
            displayMenu();
            System.out.println("enter your choice:");
            choice = s.nextInt();
            switch(choice){
                case 1: 
                   transactionHistory();
                   break;
                case 2:
                   withdrawMoney();
                   break;
                case 3:
                   depositMoney();
                   break;
                case 4:
                   transferMoney();
                   break;
                case 5:
                   System.out.println("Exit");
                   break;
                default:
                   System.out.println("Invalid Choice"); 
                   break;            
            }
        }while(choice != 5);
    }

}