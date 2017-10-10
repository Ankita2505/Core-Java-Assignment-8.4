package assignment8_4;
/*
 * program to reserve tickets in an online bus reservation system using synchronization
 */
//This class book the tickets and print the result of booked ticket history
class Ticket
{
	int seats_available=10;
	synchronized void bookTicket(String passenger_name,int no_of_seats)
	{
		if((seats_available>=no_of_seats)&&(no_of_seats>0))
		{
			System.out.println(passenger_name + " :" + no_of_seats + "Seats booked");
			seats_available=no_of_seats;
		}
		else
			System.out.println(passenger_name + " :" + "Seats not available");
	}
}

class TicketBookThread extends Thread
{
	Ticket tkt;
	String name;
	int seats;
	
	TicketBookThread(Ticket t, String pname, int pseats)
	{
		tkt=t;
		name=pname;
		seats=pseats;
		start();
	}
	public void run()
	{
		tkt.bookTicket(name, seats);
	}
}

public class OnlineBusReserve
{
	public static void main(String[] args)//Start of Main Class
	{
		Ticket tkt=new Ticket();//Creating object of Ticket Class
		//Creating object of TicketBookThread parameterized constructor and passing the values
		TicketBookThread t1=new TicketBookThread(tkt, "Ankita", 6);
		TicketBookThread t2=new TicketBookThread(tkt, "Pranshu", 10);
		TicketBookThread t3=new TicketBookThread(tkt, "Ravi", 4);
		
	}//Close of Main Class
}