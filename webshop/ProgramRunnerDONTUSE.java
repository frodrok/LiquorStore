package se.bastagruppen.webshop;
//
//import java.util.Scanner;
//
//import se.bastagruppen.webshop.exceptions.InvalidProductException;
//import se.bastagruppen.webshop.exceptions.InvalidUserException;
//import se.bastagruppen.webshop.model.Product;
//import se.bastagruppen.webshop.model.User;
//import service.ECommerceService;
//
public final class ProgramRunnerDONTUSE
{
//
//	private boolean running;
//	private Scanner scanner;
//	private ECommerceService shopService;
//
//	public ProgramRunnerDONTUSE(ECommerceService shopService)
//	{
//		this.shopService = shopService;
//		this.running = true;
//		this.scanner = new Scanner(System.in);
//		run();
//	}
//
//	public void run()
//	{
//		String key = "";
//		while (running && (!key.toLowerCase().equals("q")))
//		{
//			printMenu();
//			key = takeInput();
//			switch (key.toLowerCase())
//			{
//			case "1":
//
//				printUserMenu();
//				key = takeInput();
//				switch (key.toLowerCase())
//				{
//				case "1":
//					printAllUsers();
//					break;
//				case "2":
//					addUser();
//					break;
//
//				case "3":
//
//					System.out.println("Insert userId: ");
//				}
//
//				break;
//			case "2":
//				printProductsMenu();
//				key = takeInput();
//				switch (key.toLowerCase())
//				{
//				case "1":
//					printProducts();
//					break;
//				case "2":
//					addProduct();
//					break;
//				case "3":
//					deleteProduct();
//					break;
//				case "4":
//					updateProductPrice();
//					break;
//				}
//				break;
//			case "q":
//				running = false;
//				break;
//			default:
//				System.out.println("lol default");
//				break;
//			}
//		}
//	}
//
//	private void updateProductPrice()
//	{
//		System.out.println("Insert product id: ");
//		String name = takeInput().toLowerCase();
//		shopService.
//		
//	}
//
//	private void deleteProduct()
//	{
//		System.out.println("Insert product id: ");
//		String name = takeInput().toLowerCase();
//		shopService.deleteProduct(name);
//	}
//
//	private void addProduct()
//	{
//		boolean added = false;
//		while (!added)
//		{
//			System.out.println("Insert product name: ");
//			String name = takeInput();
//			System.out.println("Insert product price: ");
//			String price = takeInput();
//			Product product = new Product(name, new Double(price));
//			try
//			{
//				shopService.addProduct(product);
//				added = true;
//			}
//			catch (InvalidProductException e)
//			{
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//	private void printProductsMenu()
//	{
//		System.out.println("PRODUCTMENU:");
//		System.out.println("1: PRINT ALL PRODUCTS");
//		System.out.println("2: ADD PRODUCT");
//		System.out.println("3: DELETE PRODUCT");
//		System.out.println("4: UPDATE PRODUCT PRICE");
//	}
//
//	private void printUserMenu()
//	{
//		System.out.println("USERMENU:");
//		System.out.println("1: PRINT ALL USERS");
//		System.out.println("2: ADD USER");
//		System.out.println("3: DELETE USER");
//		System.out.println("4: UPDATE USER");
//		System.out.println("5: FIND USER BY ID");
//
//	}
//
//	private void printProducts()
//	{
//		for (Product product : shopService.getAllProducts())
//		{
//			System.out.println("SerialNO: " + product.getId() + ", productName: " + product.getName() +
//					", productPrice: " + product.getPrice());
//		}
//
//	}
//
//	private void printMenu()
//	{
//		System.out.println("MENU FOR THIS SHIT!");
//		System.out.println("PRESS 1 FOR USER OPTIONS");
//		System.out.println("PRESS 2 FOR PRODUCT OPTIONS");
//		System.out.println("PRESS 3 FOR ORDER OPTIONS");
//	}
//
//	private String takeInput()
//	{
//		return scanner.nextLine();
//	}
//
//	private void addUser()
//	{
//		// TODO VALIDATION
//		boolean added = false;
//		while (!added)
//		{
//			System.out.println("Insert username: ");
//			String name = takeInput();
//			System.out.println("Insert password: ");
//			String password = takeInput();
//			User tempUser = new User(name, password);
//			try
//			{
//				shopService.addUser(tempUser);
//				added = true;
//			}
//			catch (InvalidUserException e)
//			{
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//	private void printAllUsers()
//	{
//		for (User user : shopService.getAllUsers())
//		{
//			System.out.println("Id: " + user.getId() + ", Username: " + user.getUsername() +
//					", password: " + user.getPassword() + ", ");
//
//		}
//	}
//
//	private void deleteUser()
//	{
//		for (User user : shopService.getAllUsers())
//		{
//
//		}
//	}
}
