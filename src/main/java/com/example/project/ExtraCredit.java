package com.example.project;
import java.util.Scanner;


public class ExtraCredit {


    public static String calculateTip(int people, int percent, double cost, String items) {
        StringBuilder result = new StringBuilder();

        //Finds the exact cost of tip
        double tip = cost * (percent / 100.0);
        
        //Finds the cost of the bill with tip
        double totalCost = cost + tip;
        
        //Finds the total amount that each person needs to pay including bill and tip rounded to the nearest hundredths
        double totalCostPerPerson = totalCost / people;
        totalCostPerPerson = Math.round(totalCostPerPerson * 100);
        totalCostPerPerson /= 100;

        //Rounds the cost of the total bill with tip to the nearest hundredths
        totalCost = Math.round(totalCost * 100);
        totalCost /= 100;

        //Rounds the cost of the tip to the nearest hundredths
        tip = Math.round(tip * 100); //Found out how to use Math.round from here: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/round
        tip /= 100;
        
        //Finds the cost of the bill before tip that each person would need to pay rounded to the nearest hundrdths
        double billCostPerPerson = cost / people; 
        billCostPerPerson = Math.round(billCostPerPerson * 100);
        billCostPerPerson /= 100;

        //Finds the amount of tip each person would need to pay rounded to the nearest hundrdths
        double tipPerPerson = tip / people;
        tipPerPerson = Math.round(tipPerPerson * 100);
        tipPerPerson /= 100;

        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + cost + "\n"); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%\n");
        result.append("Total tip: $" + tip + "\n");
        result.append("Total Bill with tip: $" + totalCost + "\n");
        result.append("Per person cost before tip: $" + billCostPerPerson + "\n");
        result.append("Tip per person: $" + tipPerPerson + "\n");
        result.append("Total cost per person: $" + totalCostPerPerson + "\n");
        result.append("-------------------------------\n");
      
        //the two lines  should go below result.append("-------------------------------\n"); 
        result.append("Items ordered:\n");
        result.append(items);
    
        return result.toString();
    }
            
    public static void main(String[] args) {
        int people = 6;
        int percent = 25;
        double cost = 52.27;
        String items = ""; 

        //Asks users to input item names and then stores them all together in the string "itemName"
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an item name or type '-1' to finish: ");
        String itemName = scan.nextLine();
        while (!itemName.equals("-1")) { //I learned how to use the not equal operator from here: https://ioflood.com/blog/java-notequals-operator/
            items += itemName;
            items += "\n";
            System.out.println("Enter an item name or type '-1' to finish: ");
            itemName = scan.nextLine();
        }
                             
        System.out.println(calculateTip(people,percent,cost,items));
    }
}
