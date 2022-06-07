package com.sergdalm.week4.practice;


import com.sergdalm.week4.practice.hero.Archer;
import com.sergdalm.week4.practice.hero.Hero;
import com.sergdalm.week4.practice.hero.Warrior;
import com.sergdalm.week4.practice.weapon.Bow;
import com.sergdalm.week4.practice.weapon.Sword;
import com.sergdalm.week4.practice.weapon.Weapon;

public class WeaponRunner {

    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("Леголас", 10);
        archer.setWeapon(new Bow());

        printWeaponDamage(archer);
        printWeaponDamage(archer);

        setWeapon(archer);
        getWeapon(archer);

        Warrior<Sword> warrior = new Warrior<>("Боромир", 15);
        warrior.setWeapon(new Sword());
    }

    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }

    public static void printWeaponDamage2(Hero<? extends Weapon> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }

    public static void setWeapon(Hero<? super Bow> hero) {
        hero.setWeapon(new Bow());
    }

    public static void getWeapon(Hero<? extends Bow> hero) {
        Bow weapon = hero.getWeapon();
        System.out.println(hero.getWeapon().getDamage());
    }
}

