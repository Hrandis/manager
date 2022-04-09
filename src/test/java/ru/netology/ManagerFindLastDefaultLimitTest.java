package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFindLastDefaultLimitTest {

    Movie firstMovie = new Movie(1, "Вверх", "мультфильм");
    Movie secondMovie = new Movie(2, "Семь", "триллер");
    Movie thirdMovie = new Movie(3, "Титаник", "мелодрама");
    Movie fourthMovie = new Movie(4, "Зеленая миля", "драма");
    Movie fifthMovie = new Movie(5, "Побег из Шоушенка", "драма");
    Movie sixthMovie = new Movie(6, "Список Шиндлера", "драма");
    Movie seventhMovie = new Movie(7, "Форрест Гамп", "драма");
    Movie eighthMovie = new Movie(8, "1+1", "драма");
    Movie ninthMovie = new Movie(9, "Криминальное чтиво", "криминал");
    Movie tenthMovie = new Movie(10, "Король Лев", "мультфильм");
    Movie eleventhMovie = new Movie(11, "Иван Васильевич меняет профессию", "комедия");
    Manager manager = new Manager();

    @BeforeEach
    public void preparations() {
        manager.add(firstMovie);
        manager.add(secondMovie);
        manager.add(thirdMovie);
        manager.add(fourthMovie);
        manager.add(fifthMovie);
        manager.add(sixthMovie);
        manager.add(seventhMovie);
        manager.add(eighthMovie);
        manager.add(ninthMovie);
    }

    @Test
    void shouldFindLastAmountUnderLimit() {

        Movie[] expected = new Movie[]{ninthMovie, eighthMovie, seventhMovie, sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastAmountEqualsLimit() {
        manager.add(tenthMovie);

        Movie[] expected = new Movie[]{tenthMovie, ninthMovie, eighthMovie, seventhMovie, sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastAmountOverLimit() {
        manager.add(tenthMovie);
        manager.add(eleventhMovie);

        Movie[] expected = new Movie[]{eleventhMovie, tenthMovie, ninthMovie, eighthMovie, seventhMovie, sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}