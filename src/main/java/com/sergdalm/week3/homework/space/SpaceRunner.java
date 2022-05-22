package com.sergdalm.week3.homework.space;

/**
 * Создать иерархию классов, описывающих объекты в космосе.
 * Например, планета, спутник, звезда, астероид и т.д.
 * У каждого есть набор методов и характеристик-свойств, как общих (масса),
 * так и присущих только этому типу космического объекта.
 * <p>
 * Необходимо учесть следующее:
 * <li>В иерархии должно быть минимум 10 классов/интерфейсов</li>
 * <li>Обязательно использовать наследование (достаточно 1-2 уровней)</li>
 * <li>Использовать полиморфизм и продемонстрировать переопределение методов в иерархии</li>
 * <li>Продемонстрировать добавление собственных методов в классах-наследниках (можно с помощью интерфейсов)</li>
 * <li>При разработке иерархии держать в уме принцип инкапсуляции,
 * выбирать корректные имена классов, их полей и методов, пользоваться преимуществами полиморфизма</li>
 * <li>Отдавайте предпочтение интерфейсам, а не абстрактным классам</li>
 * <li>При переопределении методов обязательно использовать аннотацию @Override</li>
 * <li>Не создавать лишних классов в системе (полностью дублирующих или не содержащих назначения)</li>
 * <li>Каждый класс должен выполнять своё назначение</li>
 * <li>Для каждого не абстрактного класса переопределить метод toString()
 * класса для представления информации о классах в строковой форме</li>
 * <li>Создать общие методы:
 * <li> - Рассчитывающие диаметр космического объекта</li>
 * <li> - Сравнивающий массы 2 космических объектов (метод не статический!)</li>
 * </li>
 * <p>
 * Создать утилитный класс* SpaceUtils со следующими статическими методами:
 * <li>Принимающий 2 космический объекта и определяющий силу гравитации между ними
 * (можно придумать любую формула на основании расстоянии между объектами и т.д.)</li>
 * <li> Принимающий космический объект и определяющий, является ли он звездой или нет</li>
 * <p>
 * Создать класс SpaceRunner, где протестировать написанный функционал
 */
public class SpaceRunner {

    public static void main(String[] args) {
        SpaceObject sun = SpaceObject.builder()
                .setName("Sun")
                .setMass(1.989 * Math.pow(10, 30))
                .setDistanceFromCentralObject(0)
                .setTemperature(5505)
                .setRadius(696340)
                .build();
        SpaceObject earth = SpaceObject.builder()
                .setName("Earth")
                .setMass(5.972 * Math.pow(10, 24))
                .setCentralObject(sun)
                .setDistanceFromCentralObject(151450000)
                .setRadius(6371)
                .build();
        SpaceObject moon = SpaceObject.builder()
                .setName("Moon")
                .setMass(7.34767309 * Math.pow(10, 22))
                .setCentralObject(earth)
                .setDistanceFromCentralObject(384400)
                .setRadius(1737)
                .build();
        SpaceObject mars = SpaceObject.builder()
                .setName("Mars")
                .setMass(6.39 * Math.pow(10, 23))
                .setCentralObject(sun)
                .setDistanceFromCentralObject(208820000)
                .hasRing(true)
                .setRadius(3389)
                .build();
        SpaceObject phobos = SpaceObject.builder()
                .setName("Phobos")
                .setMass(10.6 * Math.pow(10, 15))
                .setCentralObject(mars)
                .setDistanceFromCentralObject(3700)
                .setRadius(11)
                .build();
        SpaceObject deimos = SpaceObject.builder()
                .setName("Deimos")
                .setMass(1.8 * Math.pow(10, 15))
                .setCentralObject(mars)
                .setDistanceFromCentralObject(77790000)
                .setRadius(6)
                .build();
        ArtificialSatellite am103 = (ArtificialSatellite) SpaceObject.builder()
                .setName("AM103")
                .setMass(20)
                .setCentralObject(earth)
                .setDistanceFromCentralObject(300)
                .setRadius(2)
                .isArtificial(true)
                .setCreator(earth)
                .setCreationYear(2003)
                .build();

        System.out.println(sun + "\n");
        System.out.println(earth + "\n");
        System.out.println(mars + "\n");
        System.out.println(phobos + "\n");
        System.out.println(deimos + "\n");
        System.out.println(am103 + "\n");
        sun.printSatellites();
        am103.sendStatistics();

        if (SpaceUtils.isStar(sun)) {
            System.out.println("Sun is a star");
        } else {
            System.out.println("Sun is not a star");
        }

        if (SpaceUtils.isStar(earth)) {
            System.out.println("Earth is a star");
        } else {
            System.out.println("Earth is not a star");
        }

        double gravitation = SpaceUtils.calculateGravitationalForce(sun, earth);
        System.out.println("Gravitation force between Sun and Earth " + gravitation);

        earth.isBiggerThan(mars);
        System.out.println("Diameter of Mars: " + mars.calculateDiameter());
    }
}
