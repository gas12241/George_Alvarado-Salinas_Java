package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreederTest {
    private Breeder breeder = new Breeder();
    private Dog dog1 = new Dog();
    private Dog dog2 = new Dog();

    @Before
    public void setUp() throws Exception {
        dog1.setAge(5);
        dog1.setColor("Green");
        dog1.setFavToy("Nunchucks");

        dog2.setAge(4);
        dog2.setColor("Pink");
        dog2.setFavToy("Trampoline");
    }

    @Test
    public void testBreeder() {
        Dog newdog1 = new Dog();
        newdog1.setFavToy("Nunchucks");
        newdog1.setAge(0);
        newdog1.setColor("GreenPink");

        Dog newdog2 = new Dog();
        newdog2.setFavToy("Trampoline");
        newdog2.setColor("PinkGreen");
        newdog2.setAge(0);
        assertEquals(newdog1, breeder.breedDogs(dog1, dog2));
        assertEquals(newdog2, breeder.breedDogs(dog2, dog1));
    }
}