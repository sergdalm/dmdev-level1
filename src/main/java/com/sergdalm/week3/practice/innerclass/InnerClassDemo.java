package com.sergdalm.week3.practice.innerclass;

import static com.sergdalm.week3.practice.innerclass.Person.*;

public class InnerClassDemo {

    public static void main(String[] args) {
        Person petya = new Person("Petya", Gender.FEMALE);
        Person.Pet pet = petya.new Pet("pet", "voice");
        Brain brain = new Brain(100);
        brain.study();
        System.out.println(brain.getBrainCell());
        System.out.println(petya.getBrainCellAmount());
        System.out.println(count);
        petya.sayGender();
    }
}
