package progargs;

import conversions.Calculations;
import libs.P;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class WindDown {

    public static String endValue;

    public static void endding(int selectDiet){

        P.print("According to what you provided, your EER is: " + ToDiet.updateEER + "kcal");

        if (selectDiet == 1){
            WindDown.endValue = " increase your weight.";
        }else if(selectDiet == 2){
            WindDown.endValue = " decrease your weight.";
        }else{
            WindDown.endValue = " sustain your weight.";
        }

        P.print("Meaning, you should be consuming at least " + ToDiet.updateEER + " calories a day to" + WindDown.endValue);
        P.print("You should consume " + Calculations.carbLimit + "g of Carbohydrates a day.");
        P.print("You should consume " + Calculations.fatLimit + "g of Fats a day.");
        P.print("You should consume " + Calculations.proteinLimit + "g of Proteins a day.");
    }
}
