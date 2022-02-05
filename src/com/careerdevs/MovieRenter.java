package com.careerdevs;

import java.util.ArrayList;

public class MovieRenter {
    private String name;
    private int wallet;
    private ArrayList<Movie> moviesRented;

    public MovieRenter(String name, int wallet, ArrayList<Movie> moviesRented) {
        this.name = name;
        this.wallet = wallet;
        this.moviesRented = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public ArrayList<Movie> getMoviesRented() {
        return moviesRented;
    }

    public int payWithWallet (int amount) {
        if (wallet - amount < 0) {
            return 0; // the renter will not pay if their wallet would go to negative
        } else {
            wallet -= amount;
            return amount;
        }
    }


    public void addMovie (Movie movieToAdd) {
        moviesRented.add(movieToAdd);

    }

    public void returnMovie (Movie movieToReturn) {
        moviesRented.remove(movieToReturn);
    }
}
