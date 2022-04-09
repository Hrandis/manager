package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFindLastLowerLimitTest {

    Movie firstMovie = new Movie(1, "Вверх", "мультфильм");
    Movie secondMovie = new Movie(2, "Семь", "триллер");
    Movie thirdMovie = new Movie(3, "Титаник", "мелодрама");
    Movie fourthMovie = new Movie(4, "Зеленая миля", "драма");
    Movie fifthMovie = new Movie(5, "Побег из Шоушенка", "драма");
    Movie sixthMovie = new Movie(6, "Список Шиндлера", "драма");
    Manager manager = new Manager(5);

    @BeforeEach
    public void preparations() {
        manager.add(firstMovie);
        manager.add(secondMovie);
        manager.add(thirdMovie);
        manager.add(fourthMovie);
    }

    @Test
    void shouldFindLastAmountUnderLimit() {

        Movie[] expected = new Movie[]{fourthMovie, thirdMovie, secondMovie, firstMovie};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastAmountEqualsLimit() {
        manager.add(fifthMovie);

        Movie[] expected = new Movie[]{fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastAmountOverLimit() {
        manager.add(fifthMovie);
        manager.add(sixthMovie);

        Movie[] expected = new Movie[]{sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}