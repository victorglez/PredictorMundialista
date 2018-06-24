package com.magister.unab.predictormundialista.helpers;

import android.view.View;
import android.widget.Button;
import com.magister.unab.predictormundialista.CountryDO;
import java.util.Arrays;
import java.util.List;

public class GroupHelper {

    /**
     * Get the Number of the Group
     * @param view View
     * @return Group Number
     */
    public static int getNumGroupSelect (View view)
    {
        Button boton = (Button) view;
        String grupo = boton.getTag().toString();

        return grupo.charAt(0)-'A';
    }

    /**
     * Get All Country For Group
     * @param groupNumber Group Number
     * @return List of Country of the Group
     */
    public static List <CountryDO> GetAllCountryForGroup (int groupNumber)
    {
        switch (groupNumber)
        {
            case 0:
                return Arrays.asList(
                    new CountryDO ("Rusia"),
                    new CountryDO ("Arabia"),
                    new CountryDO ("Egipto"),
                    new CountryDO ("Uruguay"));

            case 1:
                return Arrays.asList(
                        new CountryDO ("Portugal"),
                        new CountryDO ("España"),
                        new CountryDO ("Marruecos"),
                        new CountryDO ("Iran"));

            case 2:
                return Arrays.asList(
                        new CountryDO ("Francia"),
                        new CountryDO ("Australia"),
                        new CountryDO ("Perú"),
                        new CountryDO ("Dinamarca"));

            case 3:
                return Arrays.asList(
                        new CountryDO ("Argentina"),
                        new CountryDO ("Islandia"),
                        new CountryDO ("Croacia"),
                        new CountryDO ("Nigeria"));

            case 4:
                return Arrays.asList(
                        new CountryDO ("Brasil"),
                        new CountryDO ("Suiza"),
                        new CountryDO ("Costa Rica"),
                        new CountryDO ("Serbia"));

            case 5:
                return Arrays.asList(
                        new CountryDO ("Alemania"),
                        new CountryDO ("México"),
                        new CountryDO ("Suecia"),
                        new CountryDO ("Corea del Sur"));

            case 6:
                return Arrays.asList(
                        new CountryDO ("Bélgica"),
                        new CountryDO ("Panamá"),
                        new CountryDO ("Túnez"),
                        new CountryDO ("Inglaterra"));

            default:
                return Arrays.asList(
                        new CountryDO ("Polonia"),
                        new CountryDO ("Senegal"),
                        new CountryDO ("Colombia"),
                        new CountryDO ("Japón"));
        }
    }
}
