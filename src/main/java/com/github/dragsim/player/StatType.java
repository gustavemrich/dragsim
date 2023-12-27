package com.github.dragsim.player;

public enum StatType {
    STRENGTH("strength"),
    HEALTH("health"),
    DEFENSE("defense"),
    CRIT_DAMAGE("crit_damage"),
    CRIT_CHANCE("crit_chance"),
    SPEED("speed"),
    MANA("mana"),
    REGEN_MANA("regen_mana"),
    REGEN_HEALTH("regen_health"),
    MAGIC_FIND("magic_find");

    private String value;
    private StatType(final String v){
        this.value = v;
    }
    public String getValue(){
        return this.value;
    }
}

