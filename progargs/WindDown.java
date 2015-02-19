package progargs;

import conversions.Calculations;
import libs.P;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class WindDown {

    public static void endding(){

        P.print("According to what you provided, your EER is: " + ToDiet.updateEER + "kcal");
        P.print("Meaning, you should be consuming at least " + ToDiet.updateEER + " calories a day to sustain your weight.");
        P.print("You should consume " + Calculations.carbLimit + "g of Carbohydrates a day.");
        P.print("You should consume " + Calculations.fatLimit + "g of Fats a day.");
        P.print("You should consume " + Calculations.proteinLimit + "g of Proteins a day.");
    }
}
