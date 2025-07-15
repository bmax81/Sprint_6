package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundShouldReturnMeow() {
        String errorMessage = "Метод getSound() должен возвращать 'Мяу'";
        assertEquals(errorMessage, "Мяу", cat.getSound());
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        // Подготовка тестовых данных
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        // Выполнение тестируемого метода
        List<String> actualFood = cat.getFood();

        // Проверка результата
        String errorMessage = "Метод getFood() должен возвращать список еды для хищника";
        assertEquals(errorMessage, expectedFood, actualFood);
    }

}