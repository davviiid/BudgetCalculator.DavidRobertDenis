package ro.fasttrackit.project.BudgetCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BudgetCalculator {
    private static final Scanner keyboard;
    private static final DecimalFormat df;

    public BudgetCalculator() {
    }

    private static double income() {
        System.out.println("Income");
        System.out.println("Please enter the of income you receive from your job, if you have one");
        return keyboard.nextDouble();
    }

    private static double essentialOutgoing() {
        System.out.println("Essential Costs");
        System.out.println("Please enter the amount of rent you will pay per week");
        double rent = keyboard.nextDouble();
        System.out.println("Please enter the amount you expect to spend on utility bills per week. This would include gas, electric, oil, etc. Per week");
        double utilityBills = keyboard.nextDouble();
        System.out.println("Please enter how much you expect to spend on groceries per week");
        double food = keyboard.nextDouble();
        return rent + food + utilityBills;
    }

    private static double otherCosts() {
        System.out.println("OTHER COSTS");
        System.out.println("Please enter how much you would like to spend on clothing per week");
        return keyboard.nextDouble();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the budget calculator!");
        System.out.println("If any of the questions you do not receive anything, please enter 0");
        double theTotalIncome = income();
        System.out.println("Your income for the year is £" + df.format(theTotalIncome));
        System.out.println("You have £" + df.format(theTotalIncome) + " to spend");
        double theTotalEssentialOutgoing = essentialOutgoing();
        double budget1 = theTotalIncome - theTotalEssentialOutgoing;
        System.out.println("You have spent £" + df.format(theTotalEssentialOutgoing));
        System.out.println("The amount left after the essentials £" + df.format(budget1));
        double theTotalOtherCosts = otherCosts();
        double budget2 = budget1 - theTotalOtherCosts;
        System.out.println("You have spent £" + df.format(theTotalOtherCosts) + " for other costs");
        System.out.println("You have £" + df.format(budget2) + " at the end of the week");
    }

    static {
        keyboard = new Scanner(System.in);
        df = new DecimalFormat("##.#");
    }
}