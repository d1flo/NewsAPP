//in this class we create the menu so we can print the preferable results

import java.util.List;
import java.util.Scanner;

import exception.NewsAPIException;
import model.newsinfo;
import model.thenewsdb.Location;
import model.thenewsdb.LocationResult;
import services.LocationAPIService;
import services.NewsAPIService;

public class Application {

	public static void main(String[] args) throws NewsAPIException{
		// TODO Auto-generated method stub
     NewsAPIService newsAPIService=NewsAPI.getNewsAPIService();
    
     
     System.out.println("Welcome to my NewsAPP!");
     
//While (true) has been used to enable the menu options to be repeated to the user after a selection has been made     
     while (true) {
//we create cases depending on the results we want the application to bring us
    	 
     System.out.println("Please select one of the following options");
     System.out.println();
     System.out.println("1. Show the top headlines:");
     System.out.println("1a. Show the top headlines for a country:");
     System.out.println("1b. Show the top headlines for a category:");
     System.out.println("2. Search for news with criteria");
     System.out.println("2a. Search a query for news ");
     System.out.println("2b. Search for a language ");
     System.out.println("2c. Search for a source of news ");
     System.out.println("2d. Search for news' date of publication ");
     System.out.println("3. Search for popular news for your country with user apikey");
     System.out.println("4. Exit");
     System.out.println();
     System.out.println("Your input");
     
     Scanner sc = new Scanner(System.in);
     String input= sc.nextLine();
     System.out.println("Your input:"+input);
     
 // Please run the program and select one or more options. Follow the steps on the screen. 
 //The information on which options you can enter you will find in class NewsAPITest in our library NewsAPI
     switch(input) {
     case "1a":
    
    	 System.out.println("Enter the country of your choice:");
    	 String country = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.getPopularNewsForCountry(country);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
     case "1b":
    	    
    	 System.out.println("Enter the country of your choice:");
    	 String Country = sc.nextLine();
    	 System.out.println("Enter the category of your choice:");
    	 String Category = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.getPopularNewsForCategory(Country,Category);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
      case "2a":
 	    
    	 System.out.println("Enter the query of your choice:");
    	 String query = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.searchAQueryForNews(query);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
      case "2b":
  	    
    	 System.out.println("Enter the query of your choice:");
    	 String q = sc.nextLine();
    	 System.out.println("Enter the language of your choice:");
    	 String Language = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.searchLanguageForNews(q,Language);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
      case "2c":
   	    
    	 System.out.println("Enter the query of your choice:");
    	 String q1 = sc.nextLine();
    	 System.out.println("Enter the language of your choice:");
    	 String Language1 = sc.nextLine();
    	 System.out.println("Enter the source of your choice:");
    	 String Sources = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.searchSourceForNews(q1,Language1,Sources);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "2d":
    	    
    	 System.out.println("Enter the query of your choice:");
    	 String q2 = sc.nextLine();
    	 System.out.println("Enter the language of your choice:");
    	 String Language2 = sc.nextLine();
    	 System.out.println("Enter the source of your choice:");
    	 String Sources1 = sc.nextLine();
    	 System.out.println("Enter the startdate of your choice:");
    	 String from = sc.nextLine();
    	 System.out.println("Enter the enddate of your choice:");
    	 String to = sc.nextLine();
    	 try {
    	 List<newsinfo> results = newsAPIService.searchDateofPublicationForNews(q2,Language2,Sources1,from,to);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "3":
    	 System.out.println("Enter your api key:"); //enter your api from https://ip-geolocation.whoisxmlapi.com/api/documentation/making-requests
    	 String api_key = sc.nextLine();
    		final LocationAPIService newsSearchService1= LocationAPI.getLocationAPIService();
    		final LocationResult results2 = newsSearchService1.searchUserLocation(api_key);
    		String country3 = Location.getCountry();
    		System.out.println("Your country is: " + country3);
    		try {
    	final List<newsinfo> results= newsAPIService.getPopularNewsForCountry(country3);
    	 System.out.println("Results are:");
    	 System.out.println(results);
     } catch (NewsAPIException e) {
    	 System.out.println(e.getMessage());
     }
    	 break;
    	 
     case "4":
    	 System.out.println("See you soon!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input");
     }
		}
	}

}

