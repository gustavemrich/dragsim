package com.github.dragsim.player;
public class DPlayerStat {
    private int value;
    private String name;
    private String color;
    private String symbol;
    private int baseValue;

    public DPlayerStat(int baseValue, String name, String color, String symbol){
        this.value = 0;
        this.name = name;
        this.color = color;
        this.symbol = symbol;
        this.baseValue = baseValue;


    }

    public void add(int number) {
        value += number;
    }

    public void set(int number) {
        value = number;
    }
    public void remove(int number) {
        if (!(number> value)){
            value -= number;
        }
    }
    public int getValue(){
        return value;
    }

    public int getBaseValue() {
        return baseValue;
    }
}
