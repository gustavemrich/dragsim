package com.github.dragsim.player;

public enum DPlayerStatType {
    STRENGTH("STRENGTH"),
    HEALTH("HEALTH"),
    DEFENSE("DEFENSE"),
    CRIT_DAMAGE("CRIT_DAMAGE"),
    CRIT_CHANCE("CRIT_CHANCE"),
    SPEED("SPEED"),
    MANA("MANA"),
    REGEN_MANA("REGEN_MANA"),
    REGEN_HEALTH("REGEN_HEALTH"),
    MAGIC_FIND("MAGIC_FIND");

    private String value;
    private DPlayerStatType(final String v){
        this.value = v;
    }
    public String getValue(){
        return this.value;
    }

    /*public List<StatType> getModifiable(){
        return new ArrayList<>(Arrays.asList(STRENGTH, HEALTH, DEFENSE, CRIT_DAMAGE, CRIT_CHANCE, SPEED, MAGIC_FIND));
    }*/

}


