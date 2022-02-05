package com.careerdevs;

import java.util.ArrayList;

public class MovieRentalService {

    // Movie storage
    private static MovieRenter movieRenter;
    private static ArrayList<Movie> movieStorage;

    //Movie rental menus

    public static void main(String[] args) {
        System.out.println("MOVIE RENTAL SERVICE\n\n");

        movieRenter = createMovieRenter();
        initializaMovies();

        mainMenu();

    }

    public static void mainMenu () {
        System.out.println("MAIN MENU");
        rentMovieMenu();
        //System.out.println(movieRenter.getName());
    }

    public static void initializaMovies () {
        movieStorage = new ArrayList<>();
        movieStorage.add(new Movie("Matrix", "SciFi", 300));
        movieStorage.add(new Movie("Black Panther", "Action", 400));
        movieStorage.add(new Movie("Jai Mummy Di", "Dramedy", 150));
        movieStorage.add(new Movie("Coming 2 America", "Comedy", 250));
    }

    private static MovieRenter createMovieRenter () {

        System.out.println("Before you start to renting movies, you need to make an account\n");
        String name;
        int startMoney;

        while (true) {
             name = UserInterface.readString("Enter your name");
             startMoney = UserInterface.readInt("How much money do you have in USD?",5,500) * 100;

            // Confirm choices
            System.out.println("Your name is " + name + " and you will start with $" + startMoney + ".00");
            boolean confirmation = UserInterface.yesOrNo("Do you confirm your choices?");

            if (confirmation == true) break;

        }

        System.out.println("Okay you can rent movies now " + name);
        return new MovieRenter(name, startMoney);

    }


    private static void rentMovieMenu () {

        System.out.println("Rental menu");
        for (int i = 0; i < movieStorage.size(); i++) {
            Movie tenpMovie = movieStorage.get(i);
            float price = (float)tenpMovie.getPricePerDay()/100;
            System.out.println(i + 1 + ") " + tenpMovie.getTitle() + " - $" + price);

        }
        int userInput = UserInterface.readInt("Select A Movie", 1, movieStorage.size());
        Movie rentedMovie = movieStorage.remove(userInput - 1);

        int daysToRent = UserInterface.readInt("How many days would you like to rent the movie", 1, 14);

        int totalAmt = rentedMovie.getPricePerDay() * daysToRent;

        String confirmMsg = "Are you sure you want to rent " + rentedMovie.getTitle() + " for " + daysToRent + "?";
        confirmMsg += "\nTotal Price: " + totalAmt;

        if (UserInterface.yesOrNo(confirmMsg)) {
             int paidAmt = movieRenter.payWithWallet(totalAmt);
             if (paidAmt != 0) {
                 movieStorage.remove(rentedMovie);
                 movieRenter.addMovie(rentedMovie);
                 System.out.println("Thanks " + movieRenter.getName() + ", you are now renting" + rentedMovie.getTitle());

             } else {
                 System.out.println("You don't have the funds to rent a movie");
             }

        }



    }

    private static void returnMovieMenu () {}
}
