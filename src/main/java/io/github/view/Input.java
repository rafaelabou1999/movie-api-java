package io.github.view;

import io.github.service.MovieService;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    public void startInput() throws IOException, InterruptedException {
        MovieService service = new MovieService();
        TextValidation validation = new TextValidation();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        System.out.println("----- Welcome to MovieLife -----");
        var movie = validation.validateInput(sc, "Enter a movie to start the program: ");
        service.chooseMovie(movie);
        System.out.println("---------------------------------");

        while(choice != 0){
            System.out.println("Choose a option:");
            System.out.println("1 - Insert a movie");
            System.out.println("2 - Filter a genre ");
            System.out.println("3 - Show all movies");
            System.out.println("4 - Save a movie to favorites");
            System.out.println("5 - Print all movies saved as favorites");

            System.out.println("Enter a option: ");
            choice = sc.nextInt();

            if (!(choice >= 0 && choice <= 5)) {
                System.out.println("--------------");
                System.out.println("You can only enter a number from 0 to 5");
                System.out.println("--------------");
                continue; // 🔁 volta ao menu
            }
            sc.nextLine();
            if (choice == 1) {
                movie = validation.validateInput(sc, "Insert a movie:");

                if(service.movies.contains(movie)){
                    System.out.println("This move has already been added");
                } else {
                    System.out.println("Movie successfully added");
                    service.chooseMovie(movie);
                }
            } else if (choice == 2){
                System.out.println("-------- GENRES AVAILABLE ---------");
                service.getGenre().forEach(g -> System.out.println("- " + g));

                movie = validation.validateInput(sc, "Choose a genre:");
                service.filterGenre(movie.getTitle());


            } else if (choice == 3){
                if(!service.movies.isEmpty()){
                    service.showAllMovies();
                } else{
                    System.out.println("No movie found.");
                }

            } else if(choice == 4) {
                movie = validation.validateInput(sc, "Enter a movie to save:");
                String data = movie.getTitle();
                boolean exists  = service.favorites.stream().anyMatch(m -> m.getTitle().equalsIgnoreCase(data));
                if(exists){
                    System.out.println("Error. This movie is already in favorites");
                } else {
                    System.out.println("Move successfully added to favorites");
                    service.saveFavorite(movie.getTitle());
                }

            } else if (choice == 5) {
                service.showFavorites();

            } else {
                System.out.println("Invalid option");
            }
            if(choice == 0 ) break;
        }


        sc.close();
    }
}
