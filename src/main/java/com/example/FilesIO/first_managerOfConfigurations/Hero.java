package com.example.FilesIO.first_managerOfConfigurations;

import java.io.Serializable;

public class Hero implements Serializable {

    private String name;
    private int health;
    private int level;
    private String weapon;

    public Hero(String name, int health, int level, String weapon) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", level=" + level +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
