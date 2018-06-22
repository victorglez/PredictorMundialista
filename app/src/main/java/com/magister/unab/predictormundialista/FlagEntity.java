package com.magister.unab.predictormundialista;

@SuppressWarnings("ALL")
public enum FlagEntity {

    None("None", R.drawable.flag_none),
    //Grup A
    Rusia("Rusia", R.drawable.flag_rusia),
    Arabia("Arabia", R.drawable.flag_arabia_saudita),
    Egipto("Egipto", R.drawable.flag_egipto),
    Uruguay("Uruguay", R.drawable.flag_uruguay),
    //Grup B
    Portugal("Portugal", R.drawable.flag_portugal),
    España("España", R.drawable.flag_espana),
    Marruecos("Marruecos", R.drawable.flag_marruecos),
    Iran("Iran", R.drawable.flag_iran),
    //Grup C
    Francia("Francia", R.drawable.flag_francia),
    Australia("Australia", R.drawable.flag_australia),
    Perú("Perú", R.drawable.flag_peru),
    Dinamarca("Dinamarca", R.drawable.flag_dinamarca),
    //Group D
    Argentina("Argentina", R.drawable.flag_argentina),
    Islandia("Islandia", R.drawable.flag_islandia),
    Croacia("Croacia", R.drawable.flag_croacia),
    Nigeria("Nigeria", R.drawable.flag_nigeria),
    //Group E
    Brasil("Brasil", R.drawable.flag_brasil),
    Suiza("Suiza", R.drawable.flag_suiza),
    Costa_Rica("Costa Rica", R.drawable.flag_costa_rica),
    Serbia("Serbia", R.drawable.flag_serbia),
    //Group F
    Alemania("Alemania", R.drawable.flag_alemania),
    México("México", R.drawable.flag_mexico),
    Suecia("Suecia", R.drawable.flag_suecia),
    Corea_del_Sur("Corea del Sur", R.drawable.flag_corea),
    //Group G
    Bélgica("Bélgica", R.drawable.flag_belgica),
    Panamá("Panamá", R.drawable.flag_panama),
    Túnez("Túnez", R.drawable.flag_tunez),
    Inglaterra("Inglaterra", R.drawable.flag_inglaterra),
    //Group H
    Polonia("Polonia", R.drawable.flag_polonia),
    Senegal("Senegal", R.drawable.flag_senegal),
    Colombia("Colombia", R.drawable.flag_colombia),
    Japón("Japón", R.drawable.flag_japon);

    private String mFlagResId;
    private int mDrawableResId;

    /***
     * Constructor
     * @param flagResId
     * @param drawableResId
     */
    FlagEntity(String flagResId, int drawableResId) {
        mFlagResId = flagResId;
        mDrawableResId = drawableResId;
    }

    public String getFlagResId() {
        return mFlagResId;
    }

    public int getDrawableResId() {
        return mDrawableResId;
    }
}