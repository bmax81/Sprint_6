package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", feline);
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Мясо"), lion.getFood());
    }

    @Test
    public void getFoodCallsGetFoodWithPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void constructorWithInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестно", feline);
    }

    @Test(expected = Exception.class)
    public void constructorWithNullSexThrowsException() throws Exception {
        new Lion(null, feline);
    }
}