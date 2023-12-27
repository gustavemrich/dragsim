package com.github.dragsim.player;
public class Stat{
    private int value;
    private String name;
    private String color;
    private String symbol;

    public Stat(int value, String name, String color, String symbol){
        this.value = value;
        this.name = name;
        this.color = color;
        this.symbol = symbol;

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
}
