package com.company;

public class Breeder {
    public Dog breedDogs(Dog dog1, Dog dog2) {
        Dog newDog = new Dog();
        newDog.setAge(0);
        String color1 = dog1.getColor();
        String color2 = dog2.getColor();
        newDog.setColor(color1 + color2);
        newDog.setFavToy(dog1.getFavToy());
        return newDog;
    }

}
