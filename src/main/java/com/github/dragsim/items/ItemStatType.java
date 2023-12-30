package com.github.dragsim.items;

public enum ItemStatType {
    DAMAGE("DAMAGE","Damage", ""),
    STRENGTH("STRENGTH","Strength", "❁"),
    HEALTH("HEALTH","Health", "❤"),
    DEFENSE("DEFENSE","Defense", "❈"),
    CRIT_DAMAGE("CRIT_DAMAGE","Crit Damage", "☠"),
    CRIT_CHANCE("CRIT_CHANCE","Crit Chance", "%"),
    SPEED("SPEED","Speed", "✦"),
    MANA("MANA","Mana", "✎"),
    MAGIC_FIND("MAGIC_FIND","Magic Find", "✯");


    private String value;
    private String suffix;
    private String lore;

    private ItemStatType(final String v,final String lore , final String suffix){
        this.value = v;
        this.suffix = suffix;
        this.lore = lore;
    }

    public String getValue(){
        return this.value;
    }

    public String getSuffix(){
        return suffix;
    }

    public String getLore(){
        return lore;
    }
}
