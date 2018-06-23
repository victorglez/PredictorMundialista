package com.magister.unab.predictormundialista;

public class CountryDO {
        private String name;
        private int count;
        private double percentage;

        public int getCount(){
            return this.count;
        }

        public void setCount(int count){
            this.count = count;
        }

        public int getName(){
            return this.count;
        }

        public void setName(String name){
            this.name = name;
        }

        public double getPercentage(){
            return this.percentage;
        }

        public void setPercentage(double percentage){
            this.percentage = percentage;
        }

}
