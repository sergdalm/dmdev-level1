package com.sergdalm.week4.practice.hero;

import com.sergdalm.week4.practice.weapon.MagicWeapon;

public class Mage<T extends MagicWeapon> extends Hero<T> {

    public Mage(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " сотворил заклинание на " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
