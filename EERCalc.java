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

        StartUp.whoAreYou();

        StartUp.weightAndHeight(StartUp.selectedUnits);

        StartUp.moarInformation();

        ConvertItems.proceedToConvert((int) StartUp.heightInInches, (int)StartUp.weightInLbs);

        print("How active are you?");
        print("(1) Sedentary");
        print("(2) Low Active");
        print("(3) Active");
        print("(4) Very Active");
        int activeLevel = user.nextInt();

        ActiveIndex.index(StartUp.boolGender, StartUp.boolAge, activeLevel);

        Calculations.runEER(StartUp.age, StartUp.selectedUnits, StartUp.boolGender, StartUp.weightInKilos, StartUp.heightInMeters);

        ToDiet.proceedDiet(StartUp.toDiet);

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