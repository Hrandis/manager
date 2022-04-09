package ru.netology;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Manager {
    private Movie[] movies = new Movie[0];
    private int limit = 10;

    public Manager(int limit) {
        if (limit <= 0) {
            return;
        }
        this.limit = limit;
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        int lastIndex = tmp.length - 1;
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength = Math.min(limit, movies.length); //предложенный в ДЗ алгоритм заменен на Math.min по предложению IDEA
        //if (limit >= movies.length) {
        //    resultLength = movies.length;
        //} else {
        //    resultLength = limit;
        //}
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}
