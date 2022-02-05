package com.careerdevs;

public class Movie {
    private String title;
    private String genre;
    private int pricePerDay; // this is in cents

    public Movie(String title, String genre, int pricePerDay) {
        this.title = title;
        this.genre = genre;
        this.pricePerDay = pricePerDay;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

}
