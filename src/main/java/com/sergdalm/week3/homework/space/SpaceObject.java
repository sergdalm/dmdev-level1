package com.sergdalm.week3.homework.space;

public abstract class SpaceObject {
    private final SpaceObjectType type;
    private final String name;
    private final double mass;
    private final SpaceObject centralObject;
    private final int distanceFromCentralObject;
    private SpaceObjectList satellites = new SpaceObjectList();
    private final int radius;

    public SpaceObject(SpaceObjectType type, String name, double mass, SpaceObject centralObject, int distanceFromCentralObject, int radius) {
        this.type = type;
        this.name = name;
        this.mass = mass;
        this.centralObject = centralObject;
        this.distanceFromCentralObject = distanceFromCentralObject;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public int getDistanceFromCentralObject() {
        return distanceFromCentralObject;
    }

    public SpaceObject getCentralObject() {
        return centralObject;
    }

    public SpaceObjectList getSatellites() {
        return satellites;
    }

    public static SpaceObjectBuilder builder() {
        return new SpaceObjectBuilder();
    }

    public void printSatellites() {
        System.out.println(satellites);
    }

    public SpaceObject addSatellite(SpaceObject spaceObject) {
        return satellites.addObject(spaceObject);
    }

    public SpaceObjectType getType() {
        return type;
    }

    public int calculateDiameter() {
        return radius * 2;
    }

    public boolean isBiggerThan(SpaceObject otherObject) {
        System.out.println(this.mass > otherObject.mass ?
                this.type + " " + this.name + "'s mass bigger than " + otherObject.name :
                this.type + " " + this.name + "'s mass smaller than " + otherObject.name);
        return this.mass > otherObject.mass;
    }

    @Override
    public String toString() {
        return type + " " + name +
                "\n  mass: " + mass +
                (centralObject != null ? "\n  central object: " + centralObject.type + " " + centralObject.name : "") +
                (centralObject != null ? "\n  distance from " + centralObject.name + ": " + distanceFromCentralObject : "") +
                (!satellites.isEmpty() ? "\n  " + name + " has " + satellites.size() +
                        (satellites.size() == 1 ? " satellite" : " satellites") : "");
    }

    public int getDistanceFromStar() {
        if (SpaceUtils.isStar(this)) {
            return 0;
        }
        int result = distanceFromCentralObject;
        SpaceObject motherObject = centralObject;
        while (!SpaceUtils.isStar(motherObject)) {
            result += motherObject.distanceFromCentralObject;
            motherObject = motherObject.centralObject;
        }
        return result;
    }

    public int getRadius() {
        return radius;
    }

    public static class SpaceObjectBuilder {
        private String name;
        private double mass;
        private SpaceObject centralObject;
        private int distanceFromCentralObject;
        private SpaceObject creator;
        private int creationYear;
        private boolean hasRing;
        private int temperature;
        private int radius;
        private boolean isArtificial;

        private SpaceObjectBuilder() {
        }

        public SpaceObjectBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public SpaceObjectBuilder setMass(double mass) {
            this.mass = mass;
            return this;
        }

        public SpaceObjectBuilder setCentralObject(SpaceObject centralObject) {
            this.centralObject = centralObject;
            return this;
        }

        public SpaceObjectBuilder setDistanceFromCentralObject(int distanceFromCentralObject) {
            this.distanceFromCentralObject = distanceFromCentralObject;
            return this;
        }

        public SpaceObjectBuilder setCreator(SpaceObject motherObject) {
            this.creator = motherObject;
            return this;
        }

        public SpaceObjectBuilder isArtificial(boolean isArtificial) {
            this.isArtificial = isArtificial;
            return this;
        }

        public SpaceObjectBuilder setCreationYear(int creationYear) {
            this.creationYear = creationYear;
            return this;
        }

        public SpaceObjectBuilder hasRing(boolean hasRing) {
            this.hasRing = hasRing;
            return this;
        }

        public SpaceObject build() {
            if (centralObject == null) {
                return new Star(name, mass, temperature, radius);
            } else if (isArtificial) {
                return new ArtificialSatellite(name, mass, centralObject, distanceFromCentralObject, radius, creator, creationYear);
            } else if (SpaceUtils.isStar(centralObject)) {

                return new Planet(name, mass, centralObject, distanceFromCentralObject, radius, hasRing);
            } else {
                return new NaturalSatellite(name, mass, centralObject, distanceFromCentralObject, radius);
            }
        }

        public SpaceObjectBuilder setTemperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public SpaceObjectBuilder setRadius(int radius) {
            this.radius = radius;
            return this;
        }
    }
}
