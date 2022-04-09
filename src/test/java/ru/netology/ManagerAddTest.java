package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerAddTest {
    Manager manager = new Manager();
    Movie firstMovie = new Movie(1, "Вверх", "мультфильм");

    @Test
    void shouldAddIfEmpty() {
        manager.add(firstMovie);

        Movie[] expected = new Movie[]{firstMovie};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIfNotEmpty() {
        Movie secondMovie = new Movie(2, "Семь", "триллер");
        manager.add(firstMovie);

        manager.add(secondMovie);

        Movie[] expected = new Movie[]{firstMovie, secondMovie};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    //Тест shouldFindAll решено не писать, т.к. он будет повторять тесты shouldAdd
}