package io.github.view;

import io.github.client.MovieApi;
import io.github.service.MovieService;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    public void startInput() throws IOException, InterruptedException {
        MovieService service = new MovieService();
        TextValidation validation = new TextValidation();
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        var title = validation.validateInput(sc, "Insert a movie: ");
        service.chooseMovie(title);


        while(choice != 0){
                System.out.println("Choose a option:");
                System.out.println("1 - Insert a movie");
                System.out.println("2 - Filter a genre ");
                System.out.println("3 - Show all movies");
                System.out.println("4 - Save a movie to favorites");
                System.out.println("5 - Print all movies saved as favorites");

                System.out.println("Enter a option: ");
                choice = sc.nextInt();

                if (!(choice > 0 && choice <= 5)) {
                    System.out.println("--------------");
                    System.out.println("You can only enter a number from 0 to 5");
                    System.out.println("--------------");
                    continue; // 🔁 volta ao menu
                }
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Insert a movie: ");
                    title = sc.nextLine();

                    validation.validateInput(sc, "Insert a movie:");
                    service.chooseMovie(title);

                } else if (choice == 2){
                    System.out.println("Choose a genre: ");
                    var data = validation.validateInput(sc, "Insert a movie:");


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

                    validation.validateInput(sc, "Insert a movie:");


                    service.saveFavorite(data);

                }else if (choice == 5){
                    service.showFavorites();

                }else {
                    System.out.println("Invalid option");
                }
                if(choice == 0 ) break;
            }


        sc.close();
    }
}
