import conversions.ActiveIndex;
import conversions.Calculations;
import conversions.ConvertItems;
import progargs.StartUp;
import progargs.ToDiet;

import java.util.Scanner;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/17/15.
 */
public class EERCalc {

    public static void print(String message){
        System.out.println(message);
    }

    /**
     * TODO: Add the ability to use SI Units -- DONE
     * TODO: Add /healthy/ bulking and dieting options. -- DONE
     * TODO: Give percentages for how much fat, carbohydrates, and proteins you should be consuming. -- DONE
     * TODO: Move shit to its own classes, cause this shit is messy.
     */

    public static void main(String[] args){

        Scanner user = new Scanner(System.in);

        print("EER Calculator v0.2");

        print("Are you (M)Male or (F)Female?");
        String gender = user.nextLine();
        boolean boolGender = gender.toLowerCase().equals("m");

        print("Would you like to use (1)SI Units or (2)Imperial Units?");
        int units = user.nextInt();
        boolean selectedUnits = (units == 1);

        StartUp.weightAndHeight(selectedUnits);

        print("How old are you currently?");
        int age = user.nextInt();

        print("Are you currently trying to (1)Gain some weight, (2)Lose some weight, or (3)Maintain your weight?");
        int toDiet = user.nextInt();

        boolean boolAge = (age <= 17);

        ConvertItems.proceedToConvert((int) StartUp.heightInInches, (int)StartUp.weightInLbs);

        print("How active are you?");
        print("(1) Sedentary");
        print("(2) Low Active");
        print("(3) Active");
        print("(4) Very Active");
        int activeLevel = user.nextInt();

        ActiveIndex.index(boolGender, boolAge, activeLevel);

        Calculations.runEER(age, selectedUnits, boolGender, StartUp.weightInKilos, StartUp.heightInMeters);

        ToDiet.proceedDiet(toDiet);

        int carbLimit = ((ToDiet.updateEER / 2) / 4);
        int fatLimit = (int) ((ToDiet.updateEER * .3F) / 9);
        int proteinLimit = (int) ((ToDiet.updateEER * .2F) / 4);

        print("According to what you provided, your EER is: " + ToDiet.updateEER + "kcal");
        print("Meaning, you should be consuming at least " + ToDiet.updateEER + " calories a day to sustain your weight.");
        print("You should consume " + carbLimit + "g of Carbohydrates a day.");
        print("You should consume " + fatLimit + "g of Fats a day.");
        print("You should consume " + proteinLimit + "g of Proteins a day.");
    }
}