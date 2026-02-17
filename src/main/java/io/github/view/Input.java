package io.github.view;

import io.github.client.MovieApi;
import io.github.service.MovieService;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    public void startInput() throws IOException, InterruptedException {
        MovieService service = new MovieService();
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        System.out.println("Insert a movie: ");
        var title = sc.nextLine();
        service.chooseMovie(title);

        while(choice != 0){
            System.out.println("Choose a option:");
            System.out.println("1 - Insert a movie");
            System.out.println("2 - Filter a genre ");
            System.out.println("3 - Show all movies");
            System.out.println("4 - Save a movie to favorites");
            System.out.println("5 - Print all movies saved as favorites");

            System.out.println("Enter a option: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                System.out.println("Insert a movie: ");
                title = sc.nextLine();
                service.chooseMovie(title);
            }else if (choice == 2){
                System.out.println("Choose a genre: ");
                var data = sc.nextLine();
                service.filterGenre(data);
            } else if (choice == 3){
                if(!service.movies.isEmpty()){
                    service.showAllMovies();
                } else{
                    System.out.println("No movie found.");
                }

            } else if(choice == 4) {
                System.out.println("Choose a movie to save: ");
                var data = sc.nextLine();
                service.saveFavorite(data);
            }else if (choice == 5){
                service.showFavorites();
            } else {
                System.out.println("Invalid option");
            }




            if(choice == 0 ) break;
        }








        sc.close();
    }
}
