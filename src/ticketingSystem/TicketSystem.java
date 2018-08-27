package ticketingSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class TicketSystem {

	static HashMap<String, Integer> routeMap = new HashMap<String, Integer>();
	static int fare = 0;
	static HashMap<String,ArrayList<Integer>> ticketNbrs = new HashMap<>();
	static ArrayList<Integer> tickets = new ArrayList<>();
			
	public static void main(String[] args) {
		String[] routes = {"Metro","RMZ","Tin Factory","KR Puram Station","B.Narayanapura","Mahadevpura","Phenix","ESI","Hoodi","Big Baazar","Satya Sai","Vaidehi"};
		setRouteMap(routes);
		purchaseTicket("Vaidehi", "Big Baazar", 10,"Adult",1);
		
	}
	
	/*****************Set Route Map*****************************/
	
	public static void setRouteMap(String[] stageNames) {
		
		for(int i=0; i < stageNames.length; i++) {
			routeMap.put(stageNames[i], i);
		}
	}
	
	/*****************Check Fair*****************************/
	
	public static int checkFair(String origin, String destination, String ageGroup) {
		
		int stage = 0, ticketFare = 0;
		
		try {
			stage = Math.abs(routeMap.get(origin) - routeMap.get(destination));	
		}catch (Exception e) {
			System.out.println("Invalid Origin or Destination");
		}
		
		if(stage > 0 ) {
			int baseFare = getBaseFare(stage);
			ticketFare = calculateFair(ageGroup, baseFare);
			System.out.println("Fare per "+ageGroup+" is Rs."+ticketFare+"/-");
		}
		
		return ticketFare;
	}
	
	
	/*****************Purchase Ticket*****************************/

	public static void purchaseTicket(String origin, String destination, int denomination,String ageGroup, int numberOfTickets) {

		int returnAmount = 0, totalAmount = 0; 

			
		
			totalAmount = checkFair(origin,destination,ageGroup) * numberOfTickets;
			if(totalAmount!=0) {
				System.out.println("The denomination given by you is Rs."+denomination+"/-");
				if(totalAmount > denomination) {
					int amountToPay = Math.abs(totalAmount - denomination);
					System.out.println("The total Amount of the ticket is Rs."+totalAmount+"/- You still need to Pay Rs." + amountToPay+"/-");
					String response = userConfirmation();
					if(response.contains("Yes")) {
						generateTickets(numberOfTickets);
					}else {
						System.out.println("You have choosen to offboard");
					}
				}else {
					returnAmount = Math.abs(totalAmount - denomination);
					System.out.println("The total Amount is Rs."+totalAmount+"/- Amount to be Returned Rs."+returnAmount+"/-");
					generateTickets(numberOfTickets);
				}
			}else {
				// Do Nothing
			}		
	}
	
	/*****************Confirm if User wants to Pay additional Amount*****************************/
	
	public static String userConfirmation() {
		Scanner scan = new Scanner(System.in);
		String response;		
		do{
			System.out.println("Do you want to Purchase the ticket ? Yes or No.");
			response = scan.next().toLowerCase();			
		}while(!response.contains("ye") && !response.contains("n"));
		scan.close();
		return response;
	}
	
	/*****************generate Tickets*****************************/
	
	public static void generateTickets(int numberOfTickets) {
		
		int ticket = 0;
		Date today = null;
				
		for(int i = 0; i < numberOfTickets; i++) {			
			ticket = (int) Math.round(Math.random()*1000000);
			today = new Date();
			tickets.add(ticket);
			System.out.println("Ticket Number "+(i+1)+" : "+ticket);
		}	
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			ticketNbrs.put(df.format(today), tickets);		
	}
	
	/*****************Calculate Fare*****************************/
	
	public static int calculateFair(String ageGroup, int baseFare) {
		
		if (ageGroup.contains("Child")) {
			float disc = 100 - 50;
			return baseFare = Math.round((baseFare * disc) / 100);
		} else if (ageGroup.contains("Senior Citizen")) {
			float disc = 100 - 25;
			return baseFare = Math.round((baseFare * disc) / 100);
		} else {
			return baseFare;
		}
	}
	
	
	/*****************Get Base Fare based on Stages*****************************/
	
	public static int getBaseFare(int stages) {
		switch (stages) {

		case 1: fare = 5; break;
		case 2: fare = 10; break;
		case 3: fare = 15; break;
		case 4: fare = 17; break;
		case 5: fare = 19; break;
		case 6: fare = 20; break;
		case 7: fare = 20; break;
		case 8: fare = 22; break;
		case 9: fare = 22; break;
		case 10: fare = 23; break;
		case 11: fare = 23; break;
		case 12: fare = 24; break;
		case 13: fare = 24; break;
		case 14: fare = 25; break;
		case 15: fare = 25; break;
		case 16: fare = 25; break;
		case 17: fare = 25; break;
		case 18: fare = 25; break;
		case 19: fare = 26; break;
		case 20: fare = 27; break;
		case 21: fare = 27; break;
		case 22: fare = 29; break;
		case 23: fare = 29; break;
		case 24: fare = 30; break;
		case 25: fare = 30; break;
		case 26: fare = 31; break;
		case 27: fare = 31; break;
		case 28: fare = 31; break;
		case 29: fare = 32; break;
		case 30: fare = 32; break;
		case 31: fare = 32; break;
		case 32: fare = 33; break;
		case 33: fare = 33; break;
		case 34: fare = 33; break;
		case 35: fare = 34; break;
		case 36: fare = 34; break;
		case 37: fare = 34; break;
		case 38: fare = 35; break;
		case 39: fare = 35; break;
		case 40: fare = 35; break;
		case 41: fare = 36; break;
		case 42: fare = 36; break;
		case 43: fare = 36; break;
		case 44: fare = 37; break;
		case 45: fare = 37; break;
		case 46: fare = 37; break;
		case 47: fare = 38; break;
		case 48: fare = 38; break;
		case 49: fare = 38; break;
		case 50: fare = 39; break;
		case 51: fare = 39; break;
		case 52: fare = 39; break;
		case 53: fare = 40; break;
		case 54: fare = 40; break;
		case 55: fare = 40; break;
		case 56: fare = 41; break;
		case 57: fare = 41; break;
		case 58: fare = 41; break;
		case 59: fare = 42; break;
		case 60: fare = 42; break;
		case 61: fare = 42; break;
		case 62: fare = 43; break;
		case 63: fare = 43; break;
		case 64: fare = 43; break;
		case 65: fare = 44; break;
		case 66: fare = 44; break;
		case 67: fare = 44; break;

		default:
			System.out.println("This is invalid origin or destination");
		}
		return fare;
		
	}	
}



