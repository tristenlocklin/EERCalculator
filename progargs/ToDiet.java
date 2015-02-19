package progargs;

import conversions.Calculations;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class ToDiet {

    public static int updateEER;


    public static void proceedDiet(int toDiet){

        if (toDiet == 2){
            ToDiet.updateEER = Calculations.EER - 500;
        }else if (toDiet == 1){
            ToDiet.updateEER = Calculations.EER + 500;
        }else{
            ToDiet.updateEER = Calculations.EER;
        }

    }
}
