import conversions.ActiveIndex;
import conversions.Calculations;
import conversions.ConvertItems;
import progargs.StartUp;
import progargs.ToDiet;
import progargs.WindDown;

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
     * TODO: Move shit to its own classes, cause this shit is messy. -- DONE
     */

    public static void main(String[] args){

        print("EER Calculator v0.2");

        StartUp.whoAreYou();

        StartUp.weightAndHeight(StartUp.selectedUnits);

        StartUp.moarInformation();

        ConvertItems.proceedToConvert((int) StartUp.heightInInches, (int)StartUp.weightInLbs);

        ActiveIndex.index(StartUp.boolGender, StartUp.boolAge, StartUp.activeLevel);

        Calculations.runEER(StartUp.age, StartUp.selectedUnits, StartUp.boolGender, StartUp.weightInKilos, StartUp.heightInMeters);

        ToDiet.proceedDiet(StartUp.toDiet);

        Calculations.calcPercent();

        WindDown.endding();
    }
}