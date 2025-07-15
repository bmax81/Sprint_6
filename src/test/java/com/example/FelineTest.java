package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setup() {
        feline = new Feline();
    }

    @Test
    public void getKittensShouldReturnDefaultValueTest() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgumentShouldReturnSameValueTest() {
        int count = feline.getKittens(3);
        assertEquals(3, count);
    }

    @Test
    public void getFamilyShouldReturnFelineFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatShouldReturnPredatorFoodTest() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}