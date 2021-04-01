package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Client;
import entidades.Order;
import entidades.OrderItem;
import entidades.Product;
import entidades.enums.StatusOrder;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Enter client data:");
		System.out.print("\nName");
		String clientName = sc.nextLine();
		System.out.print("\nEmail");
		String clientEmail = sc.nextLine();
		System.out.print("\nBirth date (DD/MM/YYYY)");
		Date clientBirthDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName,clientEmail,clientBirthDate);
		
		System.out.println("\nEnter order data:");
		System.out.println("Status");
		String orderStatus = sc.next();
		
		Order order = new Order (new Date(), StatusOrder.valueOf(orderStatus),client);
		
		System.out.println("How Many items to this order");
		int  numberOrders = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i<=numberOrders;i++) {
			
			System.out.print("\nProduct name");
			String productName = sc.nextLine();
			System.out.print("\nProduct price");
			Double productPrice = sc.nextDouble();
			System.out.print("\nQuantity");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			OrderItem orderItem = new OrderItem(productQuantity,productPrice,new Product (productName,productPrice));
			order.addOrderItem(orderItem);
			
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.println(order.toString());
	}

}
