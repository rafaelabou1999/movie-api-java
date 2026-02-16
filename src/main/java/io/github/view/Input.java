package io.github.view;

import io.github.client.MovieApi;
import io.github.service.MovieService;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    public void startInput() throws IOException, InterruptedException {
        MovieService service = new MovieService();
        MovieApi movieApi;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a option:");
        System.out.println("1 - Add a movie");
        System.out.println("2 - Filter a genre ");
        System.out.println("3 - Save a movie to favorites");
        System.out.println("4 - Print all movies saved as favorites");
        System.out.println("Enter a option: ");
        int choice = Integer.parseInt(sc.nextLine());
        var data = "";
        var link = "http://www.omdbapi.com/?apikey=7a43f72&t=" + data;
        while(choice != 0){
            System.out.println("Wanna quit? Press 0. If no, press enter an option:");
            choice = Integer.parseInt(sc.nextLine());

            if(choice == 1){
                MovieApi.connectApi(link);
                System.out.println("Insert a movie: ");
                data = sc.nextLine();
                service.chooseMovie(data);
            } else if (choice == 2){
                MovieApi.connectApi(link);
                System.out.println("Choose a genre: ");
                data = sc.nextLine();
                service.filterGenre(data);
            } else if (choice == 3){
                MovieApi.connectApi(link);
                System.out.println("Choose a movie to save: ");
                data = sc.nextLine();
                service.saveFavorite(data);
            } else if(choice == 4) {
                service.showFavorites();
            } else {
                System.out.println("Invalid option");
            }


            if(choice == 0 ) break;
        }








        sc.close();
    }
}
