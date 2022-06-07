package com.sergdalm.week3.practice.innerclass;

public class Person {
    static int count;
    private int id;
    private String name;
    private Gender gender;
    Pet pet;
    Brain brain;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.id = count++;
        pet = new Pet("puppy", "wof");
        brain = new Brain(100);
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public int getBrainCellAmount() {
        return brain.getBrainCell();
    }

    private char getFirstLetterOfName() {
        return name.charAt(0);
    }

    class Pet {
        private String name;
        private String voice;

        public Pet(String name, String voice) {
            this.name = name;
            this.voice = voice;
        }

        public void say() {
            System.out.println(voice);
        }

        public void callOwner() {
            System.out.println(getFirstLetterOfName());
            System.out.println(gender);
            System.out.println(Person.this.name);
        }
    }

    public void sayGender() {
        this.gender.sayGender();
    }

    static class Brain {
        int brainCell;

        public Brain(int brainCell) {
            this.brainCell = brainCell;
            System.out.println(Person.count);
        }

        public void study() {
            brainCell++;
        }

        public int getBrainCell() {
            System.out.println();
            return brainCell;
        }
    }

    public enum Gender {
        MALE {
            @Override
            public void sayGender() {
                System.out.println("I'm male");
            }
        },
        FEMALE {
            @Override
            public void sayGender() {
                System.out.println("I'm female");
            }
        };

        public abstract void sayGender();
    }
}

