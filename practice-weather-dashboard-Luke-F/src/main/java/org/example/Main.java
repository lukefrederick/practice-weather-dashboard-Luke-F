package org.example;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

// http://api.openweathermap.org/geo/1.0/zip?zip=E14,GB&appid=b6a920087be0619f58f5df1592c177a1
// api.openweathermap.org/data/2.5/forecast?id=524901&appid=b6a920087be0619f58f5df1592c177a1

// City IDs
// St. Louis - https://api.openweathermap.org/data/2.5/weather?id=4407066&appid=b6a920087be0619f58f5df1592c177a1
// New Orleans - 4335045
// Kansas City - 4273837

public class Main {
    public static void main(String[] args) {

        boolean cont = true;

        while(cont) {
            System.out.println("Enter a number 1-4");
            System.out.println("1. Weather for St. Louis");
            System.out.println("2. Weather for New Orleans");
            System.out.println("3. Weather for Kansas City");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if(input >= 1 && input <= 3) {
                getWeather(input);
            }
            else if(input == 4) {
                cont = false;
            }
            else {
                System.out.println("Invalid input");
            }
        }


    }

    public static void getWeather(int choice) {
        int id = 0;
        if(choice == 1) {
            id = 4407066;
        }
        else if(choice == 2) {
            id = 4335045;
        }
        else if(choice == 3) {
            id = 4273837;
        }

        String url = "https://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=";

        RestTemplate restTemplate = new RestTemplate();
        Todo[] todos = restTemplate.getForObject(url, Todo[].class);

        System.out.println(todos[0].toString());

        return;

    }
}
