package com.magister.unab.predictormundialista;

import java.math.BigInteger;

public class CountryDO {

    private String name;
    private int fistOnGroupCount;
    private int secondGroupCount;
    private int percentage;

    /**
     * Constructor
     * @param name Country Name
     */
    public CountryDO (String name)
    {
        this.name = name;
        this.fistOnGroupCount = 0;
        this.secondGroupCount = 0;
        this.percentage = 0;
    }

    public int getCount(){
        return this.fistOnGroupCount + this.secondGroupCount;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPercentage(){
        return this.percentage;
    }

    public void setPercentage(int percentage){
        this.percentage = percentage;
    }

    public int getFistOnGroupCount() {
        return fistOnGroupCount;
    }

    public void setFistOnGroupCount(int fistOnGroupCount) {
        this.fistOnGroupCount = fistOnGroupCount;
    }

    public int getSecondGroupCount() {
        return secondGroupCount;
    }

    public void setSecondGroupCount(int secondGroupCount) {
        this.secondGroupCount = secondGroupCount;
    }
}
