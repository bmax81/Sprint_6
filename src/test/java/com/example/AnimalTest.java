package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {
    private final Animal animal = new Animal();

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"),
                animal.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"),
                animal.getFood("Хищник"));
    }

    @Test
    public void testGetFoodForUnknownType() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Всеядное");
        });
        assertTrue(exception.getMessage()
                .contains("Неизвестный вид животного"));
    }

    @Test
    public void testGetFoodWithNullInput() {
        assertThrows(Exception.class, () -> animal.getFood(null));
    }

    @Test
    public void testGetFamily() {
        assertTrue(animal.getFamily()
                .contains("несколько семейств"));
    }
}
