package ui;

import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import exceptions.ChangeStateException;
import exceptions.IdentificationException;
import exceptions.SearchException;

public class Menu {

	public final static int REGISTER = 1;
	public final static int UPDATE_DATA = 2;
	public final static int CHANGE_STATE = 3;
	public final static int SAVE = 4;
	public final static int IMPORT = 5;
	public final static int EXPORT = 6;
	public final static int SHOW = 7;
	public final static int FIND_CLIENT = 8;
	public final static int EXIT = 9;
	public final static String PRINCIPAL = "1.REGISTER" + "\n" + "2.UPDATE DATA" + "\n" + "3.CHANGE STATE" + "\n"
			+ "4.SAVE" + "\n" + "5.IMPORT" + "\n" + "6.EXPORT" + "\n" + "7.SHOW IN SCREEN" + "\n" + "8.FIND CLIENT "
			+ "\n" + "9.EXIT";
	Scanner sc = new Scanner(System.in);
	RestaurantAssociation restaurantA;

	public Menu() throws FileNotFoundException, ClassNotFoundException, IOException {

		restaurantA = new RestaurantAssociation();

	}

	public void showMenu() throws ClassNotFoundException, IOException {

		int option = 0;
		while (option != EXIT) {
			System.out.println("WELCOME TO THE RESTAURANTS PROGRAM" + "\n" + "CHOOSE AN OPTION: ");
			System.out.println(PRINCIPAL);
			option = Integer.parseInt(sc.nextLine());
			switch (option) {

			case REGISTER:
				System.out.println("WHAT DO YOU WANT TO REGISTER?");
				System.out.println("1.RESTAURANT" + "\n" + "2.CLIENT" + "\n" + "3.ORDER" + "\n" + "4.PRODUCT");
				int optionR = Integer.parseInt(sc.nextLine());
				int index = 0;
				int indexc = 0;
				switch (optionR) {
				case 1:
					System.out.println("Insert the name of the restaurant");
					String name = sc.nextLine();
					System.out.println("Insert the nameAdmin");
					String nameAdmin = sc.nextLine();
					System.out.println("Insert the nit");
					int nit = Integer.parseInt(sc.nextLine());
					restaurantA.registerRestaurant(nit, name, nameAdmin);
					break;

				case 2:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A CLIENT: ");
					index = Integer.parseInt(sc.nextLine());
					System.out.println("INSERT IDENTIFICATION NUMBER: ");
					int n = Integer.parseInt(sc.nextLine());
					System.out.println("INSERT THE PHONE: ");
					int p = Integer.parseInt(sc.nextLine());
					System.out.println("INSERT IDENTIFICATION TYPE : TI/PP/CC/CE");
					String t = sc.nextLine();
					System.out.println("INSERT THE FIRSTNAME: ");
					String f = sc.nextLine();
					System.out.println("INSERT THE LASTNAME: ");
					String l = sc.nextLine();
					System.out.println("INSERT ADDRES");
					String a = sc.nextLine();
					restaurantA.getRestaurants().get(index - 1).addClient(n, p, t, f, l, a);
					restaurantA.saveRestaurants();
					break;
				case 3:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A ORDER: ");
					index = Integer.parseInt(sc.nextLine()) - 1;
					restaurantA.getRestaurants().get(index).showClients();
					System.out.println("PUT THE INDEX OF THE CLIENT TO REGISTER A ORDER: ");
					indexc = Integer.parseInt(sc.nextLine()) - 1;
					System.out.println("Insert how many different products you will add");
					int many = Integer.parseInt(sc.nextLine());
					Client client = restaurantA.getRestaurants().get(index).getClients().get(indexc);
					ArrayList<Product> products = new ArrayList<Product>();
					int clientcode = client.getIdentificationNumber();
					int restNit = restaurantA.getRestaurants().get(index).getNit();
					int code = 0;
					int count = 0;
					int cNumber = 0;
					for (int i = 0; i < many; i++) {
						System.out.println((i + 1) + "." + "PRODUCT");
						System.out.println("INSERT THE CODE OF THE PRODUCT: ");
						code = Integer.parseInt(sc.nextLine());
						System.out.println("INSERT THE QUANTITY OF THIS PRODUCT: ");
						cNumber = Integer.parseInt(sc.nextLine());
						for (int j = 0; j < restaurantA.getRestaurants().get(index).getProducts().size(); j++) {

							if (restaurantA.getRestaurants().get(index).getProducts().get(j).getCode() == code) {
								System.out.println("YEESS");

								for (int k = 0; k < cNumber; k++) {
									Product nproduct = new Product(code, restNit,
											restaurantA.getRestaurants().get(index).getProducts().get(0).getCost(),
											restaurantA.getRestaurants().get(index).getProducts().get(0).getName(),
											restaurantA.getRestaurants().get(index).getProducts().get(0)
													.getDescription());
									products.add(nproduct);
									count++;
								}
							}

						}
					}
					if (count == 0) {
						System.err.println("This restaurant dont have a product with this code");
					} else {

						client.addOrder(clientcode, restNit, products);
						System.out.println("Products with a correct code added correctly");
						restaurantA.saveRestaurants();
					}

					break;

				case 4:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A PRODUCT: ");
					index = Integer.parseInt(sc.nextLine());
					System.out.println("INSERT CODE:");
					int codeP = Integer.parseInt(sc.nextLine());
					System.out.println("INSERT COST: ");
					int costP = Integer.parseInt(sc.nextLine());
					System.out.println("INSERT THE NAME: ");
					String nameP = sc.nextLine();
					System.out.println("INSERT THE DESCRIPTION: ");
					count = 0;
					String descriptionP = sc.nextLine();
					for (int i = 0; i < restaurantA.getRestaurants().get(index - 1).getProducts().size(); i++) {
						if (restaurantA.getRestaurants().get(index - 1).getProducts().get(i).getCode() == codeP) {
							count++;
						}
					}
					if (count == 0) {

						restaurantA.getRestaurants().get(index - 1).addProduct(codeP, costP, nameP, descriptionP);
						restaurantA.saveRestaurants();
					} else {
						System.err.println("A product with this code exists");
					}

					break;
				}

				break;

			case UPDATE_DATA:
				System.out.println("WHAT DO YOU WANT UPDATE: " + "\n" + "1.RESTAURANT" + "\n" + "2.CLIENT" + "\n"
						+ "3.PRODUCT" + "\n" + "4.ORDER");
				int optionup = Integer.parseInt(sc.nextLine());
				switch (optionup) {

				case 1:
					System.out.println("INSERT THE NIT OF THE RESTAURANT TO SEARCH");
					int nitR = Integer.parseInt(sc.nextLine());
					System.out.println("CHOOSE AN OPTION :" + "1.UPDATE ALL" + " " + "2.UPDATE NAME" + " "
							+ "3.UPDATE NAME ADMIN" + " " + " " + "4.UPDATE NIT" + " " + "5.UPDATE THE PRODUCTS" + " "
							+ "6.UPDATE THE CLIENTS");
					int optionr = Integer.parseInt(sc.nextLine());
					switch (optionr) {
					case 1:
						System.out.println("INSERT THE NIT: ");
						int nit = Integer.parseInt(sc.nextLine());
						System.out.println("INSERT THE NAME: ");
						String name = sc.nextLine();
						System.out.println("INSERT NAME ADMIN: ");
						String nameAdmin = sc.nextLine();
						int opProduct = 0;
						int opClients = 0;
						ArrayList<Product> p = new ArrayList<Product>();
						ArrayList<Client> c = new ArrayList<Client>();
						while (opProduct != 2) {
							System.out.println("WHICH PRODUCTS HAVE THIS RESTAURANT ");
							System.out.println("PRESS 1 TO ADD A PRODUCT " + " " + "2 TO EXIT");
							opProduct = Integer.parseInt(sc.nextLine());
							if (opProduct == 1) {

								System.out.println("PRODUCT : ");
								System.out.println("INSERT THE CODE: ");
								int code = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE COST: ");
								int cost = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE NAME: ");
								String namep = sc.nextLine();
								System.out.println("INSERT THE DESCRIPTION: ");
								String description = sc.nextLine();
								try {
									p.add(new Product(code, restaurantA.searchRestaurant(nitR).getNit(), cost, namep,
											description));
								} catch (SearchException e) {

									e.printStackTrace();
								}
							}

						}
						while (opClients != 2) {
							System.out.println("WHICH CLIENTS HAVE THIS RESTAURANT ");
							System.out.println("PRESS 1 TO ADD A CLIENT " + " " + "2 TO EXIT");
							opClients = Integer.parseInt(sc.nextLine());
							if (opClients == 1) {
								System.out.println("CLIENT : ");
								System.out.println("INSERT THE IDENTIFICATION: ");
								int identification = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE PHONE: ");
								int phone = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE TYPE OF IDENTIFICATION: TI/CC/CE/PP");
								String type = sc.nextLine();
								System.out.println("INSERT THE FIRTSNAME: ");
								String firstName = sc.nextLine();
								System.out.println("INSERT THE LASTNAME: ");
								String lastName = sc.nextLine();
								System.out.println("INSERT THE ADDRES: ");
								String addres = sc.nextLine();
								try {
									c.add(new Client(identification, phone, type, firstName, lastName, addres));
								} catch (IdentificationException e) {

									e.printStackTrace();
								}
							}

						}
						try {
							if (restaurantA.searchRestaurant(nitR) != null) {
								try {
									restaurantA.searchRestaurant(nitR).updateAllData(nit, name, nameAdmin, p, c);
								} catch (SearchException e) {

									e.printStackTrace();
								}
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.out.println("THE NIT DONT FOUND");

							}
						} catch (ClassNotFoundException e1) {

							e1.printStackTrace();
						} catch (SearchException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}

						break;

					case 2:

						try {
							if (restaurantA.searchRestaurant(nitR) != null) {
								System.out.println("PUT THE NAME: ");
								name = sc.nextLine();
								restaurantA.searchRestaurant(nitR).setName(name);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.out.println("F BRO");
							}
						} catch (ClassNotFoundException e1) {

							e1.printStackTrace();
						} catch (SearchException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
						break;

					case 3:
						try {
							if (restaurantA.searchRestaurant(nitR) != null) {
								System.out.println("PUT THE ADMINNAME: ");
								name = sc.nextLine();
								restaurantA.searchRestaurant(nitR).setNameAdmin(name);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.out.println("F BRO");
							}
						} catch (ClassNotFoundException e1) {

							e1.printStackTrace();
						} catch (SearchException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}

						break;
					case 4:

						try {
							if (restaurantA.searchRestaurant(nitR) != null) {
								System.out.println("PUT THE NIT: ");
								int nitf = Integer.parseInt(sc.nextLine());
								try {
									restaurantA.searchRestaurant(nitR).setNit(nitf);
								} catch (SearchException e) {

									e.printStackTrace();
								}
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.out.println("F BRO");
							}
						} catch (NumberFormatException e1) {

							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {

							e1.printStackTrace();
						} catch (SearchException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
						break;
					case 5:
						opProduct = 0;
						p = new ArrayList<Product>();
						while (opProduct != 2) {
							System.out.println("WHICH PRODUCTS HAVE THIS RESTAURANT ");
							System.out.println("PRESS 1 TO ADD A PRODUCT " + " " + "2 TO EXIT");
							opProduct = Integer.parseInt(sc.nextLine());
							if (opProduct == 1) {

								System.out.println("PRODUCT : ");
								System.out.println("INSERT THE CODE: ");
								int code = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE COST: ");
								int cost = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE NAME: ");
								String namep = sc.nextLine();
								System.out.println("INSERT THE DESCRIPTION: ");
								String description = sc.nextLine();
								try {
									p.add(new Product(code, restaurantA.searchRestaurant(nitR).getNit(), cost, namep,
											description));
								} catch (SearchException e) {

									e.printStackTrace();
								}
							}
						}
						try {
							if (restaurantA.searchRestaurant(nitR) != null) {
								restaurantA.searchRestaurant(nitR).setProducts(p);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.out.println("THE NIT DONT FOUND");

							}
						} catch (ClassNotFoundException e1) {

							e1.printStackTrace();
						} catch (SearchException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}

						break;
					case 6:
						opClients = 0;
						c = new ArrayList<Client>();
						while (opClients != 2) {
							System.out.println("WHICH CLIENTS HAVE THIS RESTAURANT ");
							System.out.println("PRESS 1 TO ADD A CLIENT " + " " + "2 TO EXIT");
							opClients = Integer.parseInt(sc.nextLine());
							if (opClients == 1) {
								System.out.println("CLIENT : ");
								System.out.println("INSERT THE IDENTIFICATION: ");
								int identification = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE PHONE: ");
								int phone = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE TYPE OF IDENTIFICATION: TI/CC/CE/PP");
								String type = sc.nextLine();
								System.out.println("INSERT THE FIRTSNAME: ");
								String firstName = sc.nextLine();
								System.out.println("INSERT THE LASTNAME: ");
								String lastName = sc.nextLine();
								System.out.println("INSERT THE ADDRES: ");
								String addres = sc.nextLine();
								try {
									c.add(new Client(identification, phone, type, firstName, lastName, addres));
								} catch (IdentificationException e) {

									e.printStackTrace();
								}
							}

						}
						try {
							if (restaurantA.searchRestaurant(nitR) != null) {
								restaurantA.searchRestaurant(nitR).setClients(c);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.out.println("THE NIT DONT FOUND");

							}
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						} catch (SearchException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}

						break;

					}
					break;

				case 2:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT TO SEARCH A CLIENT: ");
					index = Integer.parseInt(sc.nextLine()) - 1;
					System.out.println("INSERT THE IDENTIFICATION NUMBER OF THE CLIENT TO SEARCH");
					int in = Integer.parseInt(sc.nextLine());
					System.out.println("CHOOSE AN OPTION :" + "1.UPDATE ALL" + " " + "2.UPDATE FIRSTNAME AND LASTNAME"
							+ " " + "3.UPDATE IDENTIFICATION NUMBER" + " " + " " + "4.UPDATE IDENTIFICATION TYPE" + " "
							+ "5.UPDATE ADDRES");
					int option2 = Integer.parseInt(sc.nextLine());
					switch (option2) {

					case 1:
						try {
							if (restaurantA.getRestaurants().get(index).searchClient(in) != null) {

								System.out.println("INSERT THE IDENTIFICATION NUMBER: ");
								int nin = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE PHONE NUMBER: ");
								int phone = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE IDENTIFICATION TYPE: TI/CC/CE/PP ");
								String type = sc.nextLine();
								System.out.println("INSERT THE FIRST NAME: ");
								String fname = sc.nextLine();
								System.out.println("INSERT THE LAST NAME: ");
								String lname = sc.nextLine();
								System.out.println("INSERT THE ADDRES: ");
								String addres = sc.nextLine();
								restaurantA.getRestaurants().get(index).searchClient(in).updateAllData(nin, phone, type,
										fname, lname, addres);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {

								System.err.println("DONT EXIST");
							}
						} catch (NumberFormatException e) {

							e.printStackTrace();
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						} catch (SearchException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}
						;

						break;

					case 2:
						try {
							if (restaurantA.getRestaurants().get(index).searchClient(in) != null) {
								System.out.println("INSERT THE FIRST NAME: ");
								String fname = sc.nextLine();
								System.out.println("INSERT THE LAST NAME: ");
								String lname = sc.nextLine();
								restaurantA.getRestaurants().get(index).searchClient(in).setFirstName(fname);
								restaurantA.getRestaurants().get(index).searchClient(in).setLastName(lname);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.err.println("DONT EXIST");
							}
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						} catch (SearchException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}
						break;

					case 3:

						try {
							if (restaurantA.getRestaurants().get(index).searchClient(in) != null) {
								System.out.println("INSERT THE IDENTIFCATION NUMBER ");
								int n = Integer.parseInt(sc.nextLine());
								restaurantA.getRestaurants().get(index).searchClient(in).setIdentificationNumber(n);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.err.println("DONT EXIST");
							}
						} catch (NumberFormatException e) {

							e.printStackTrace();
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						} catch (SearchException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}
						break;

					case 4:
						try {
							if (restaurantA.getRestaurants().get(index).searchClient(in) != null) {
								System.out.println("INSERT THE IDENTIFICATION TYPE: TI/CC/CE/PP");
								String type = sc.nextLine();
								restaurantA.getRestaurants().get(index).searchClient(in).setIdentificationType(type);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.err.println("DONT EXIST");
							}
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						} catch (SearchException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}
						break;
					case 5:
						try {
							if (restaurantA.getRestaurants().get(index).searchClient(in) != null) {
								System.out.println("INSERT THE ADDRES");
								String addres = sc.nextLine();
								restaurantA.getRestaurants().get(index).searchClient(in).setAddres(addres);
								System.out.println("UPDATE SUCCESFULY");
								restaurantA.saveRestaurants();
							} else {
								System.err.println("DONT EXIST");
							}
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						} catch (SearchException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}
						break;
					}
					break;

				case 3:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT TO SEARCH A PRODUCT: ");
					index = Integer.parseInt(sc.nextLine()) - 1;
					System.out.println("INSERT THE CODE OF THE PRODUCT TO SEARCH");
					int code = Integer.parseInt(sc.nextLine());
					System.out.println("CHOOSE AN OPTION :" + "1.UPDATE ALL" + " " + "2.UPDATE CODE" + " "
							+ "3.UPDATE COST" + " " + " " + "4.UPDATE NAME" + " " + "5.UPDATE DESCRIPTION");
					int optionP = Integer.parseInt(sc.nextLine());
					switch (optionP) {

					case 1:
						if (restaurantA.getRestaurants().get(index).searchProduct(code) != null) {
							System.out.println("INSERT THE CODE");
							int codep = Integer.parseInt(sc.nextLine());
							System.out.println("INSERT THE COST");
							int costp = Integer.parseInt(sc.nextLine());
							System.out.println("INSERT THE NAME");
							String namep = sc.nextLine();
							System.out.println("INSERT THE DESCRIPTION");
							String description = sc.nextLine();
							restaurantA.getRestaurants().get(index).searchProduct(code).updateAllData(codep, costp,
									namep, description);
							System.out.println("UPDATE SUCCESFULY");
							restaurantA.saveRestaurants();
						} else {
							System.err.println("DONT EXIST");

						}
						break;

					case 2:
						if (restaurantA.getRestaurants().get(index).searchProduct(code) != null) {
							System.out.println("INSERT THE CODE");
							int codep = Integer.parseInt(sc.nextLine());
							restaurantA.getRestaurants().get(index).searchProduct(code).setCode(codep);
							System.out.println("UPDATE SUCCESFULY");
							restaurantA.saveRestaurants();
						} else {
							System.err.println("DONT EXIST");

						}

						break;

					case 3:
						if (restaurantA.getRestaurants().get(index).searchProduct(code) != null) {
							System.out.println("INSERT THE COST");
							int costp = Integer.parseInt(sc.nextLine());
							restaurantA.getRestaurants().get(index).searchProduct(code).setCost(costp);
							System.out.println("UPDATE SUCCESFULY");
							restaurantA.saveRestaurants();
						} else {
							System.err.println("DONT EXIST");

						}
						break;

					case 4:
						if (restaurantA.getRestaurants().get(index).searchProduct(code) != null) {
							System.out.println("INSERT THE NAME");
							String namep = sc.nextLine();
							restaurantA.getRestaurants().get(index).searchProduct(code).setName(namep);
							System.out.println("UPDATE SUCCESFULY");
							restaurantA.saveRestaurants();
						} else {
							System.err.println("DONT EXIST");

						}
						break;

					case 5:
						if (restaurantA.getRestaurants().get(index).searchProduct(code) != null) {
							System.out.println("INSERT THE DESCRIPTION");
							String description = sc.nextLine();
							restaurantA.getRestaurants().get(index).searchProduct(code).setDescription(description);
							System.out.println("UPDATE SUCCESFULY");
							restaurantA.saveRestaurants();
						} else {
							System.err.println("DONT EXIST");

						}
						break;
					}
					break;

				case 4:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT TO SEARCH A CLIENT: ");
					index = Integer.parseInt(sc.nextLine()) - 1;
					for (int i = 0; i < restaurantA.getRestaurants().get(index).getClients().size(); i++) {
						Client client = restaurantA.getRestaurants().get(index).getClients().get(i);
						System.out.println((i + 1) + "." + client.getLastName() + " " + client.getFirstName() + " "
								+ client.getIdentificationNumber());
					}
					System.out.println("INSERT THE INDEX THE CLIENT TO UPDATE A ORDER");
					int inclient = Integer.parseInt(sc.nextLine()) - 1;
					System.out.println("INSERT THE CODE OF THE ORDER TO UPDATE");
					int codeu = Integer.parseInt(sc.nextLine());
					Order order = null;
					order = restaurantA.getRestaurants().get(index).getClients().get(inclient).searchOrder(codeu);
					if (order != null) {
						System.out.println(
								"CHOOSE AN OPTION : 1.ADD A PRODUCT  2.REMOVE A PRODUCT 3.OVERWRITE ALL PRODUCTS");
						int optionO = Integer.parseInt(sc.nextLine());
						switch (optionO) {

						case 1:
							System.out.println("INSERT THE QUANTITY OF THE PRODUCT");
							int many = Integer.parseInt(sc.nextLine());
							System.out.println("INSERT THE CODE OF THE PRODUCT TO ADD");
							code = Integer.parseInt(sc.nextLine());
							int count = 0;
							for (int i = 0; i < restaurantA.getRestaurants().get(index).getProducts().size(); i++) {
								if (restaurantA.getRestaurants().get(index).getProducts().get(i).getCode() == code) {
									count++;
									for (int j = 0; j < many; j++) {
										order.getProducts()
												.add(restaurantA.getRestaurants().get(index).getProducts().get(i));
									}

								}
							}
							if (count > 0) {
								System.out.println("ADDED SUCCESFULLY");
								restaurantA.saveRestaurants();
							} else {
								System.err.println("F");
							}

							break;

						case 2:
							for (int i = 0; i < restaurantA.getRestaurants().get(index).getClients().get(inclient)
									.searchOrder(codeu).getProducts().size(); i++) {
								Product product = restaurantA.getRestaurants().get(index).getClients().get(inclient)
										.searchOrder(codeu).getProducts().get(i);
								System.out.println((i + 1) + "." + product.getName() + " "
										+ product.getDescription() + " " + product.getCode());
							}
							System.out.println("PUT THE INDEX OF THE PRODUCT TO REMOVE");
							int indexR = Integer.parseInt(sc.nextLine()) - 1;
							restaurantA.getRestaurants().get(index).getClients().get(inclient).searchOrder(codeu)
									.getProducts().remove(indexR);
							restaurantA.saveRestaurants();
							break;
						case 3:

							System.out.println("Insert how many different products you will add");
							many = Integer.parseInt(sc.nextLine());
							ArrayList<Product> products = new ArrayList<Product>();
							int restNit = restaurantA.getRestaurants().get(index).getNit();
							code = 0;
							count = 0;
							int cNumber = 0;
							for (int i = 0; i < many; i++) {
								System.out.println((i + 1) + "." + "PRODUCT");
								System.out.println("INSERT THE CODE OF THE PRODUCT: ");
								code = Integer.parseInt(sc.nextLine());
								System.out.println("INSERT THE QUANTITY OF THIS PRODUCT: ");
								cNumber = Integer.parseInt(sc.nextLine());
								Restaurant restaurant = restaurantA.getRestaurants().get(index);
								for (int j = 0; j < restaurant.getProducts().size(); j++) {

									if (restaurant.getProducts().get(j).getCode() == code) {
										System.out.println("YEESS");

										for (int k = 0; k < cNumber; k++) {
											Product nproduct = new Product(code, restNit,
													restaurant.getProducts().get(0).getCost(),
													restaurant.getProducts().get(0).getName(),
													restaurant.getProducts().get(0).getDescription());
											products.add(nproduct);
											count++;
										}
									}

								}
							}
							if (count == 0) {
								System.err.println("This restaurant dont have a product with this code");
							} else {

								restaurantA.getRestaurants().get(index).getClients().get(inclient)
										.searchOrder(codeu).setProducts(products);
								System.out.println("Products with a correct code added correctly");
								restaurantA.saveRestaurants();
							}

							break;

						}

					}

					else {

						System.err.println("CODE DOESNT EXIST");
					}
					break;

				}
				break;

			case CHANGE_STATE:

				restaurantA.showRestaurants();
				System.out.println("PUT THE INDEX OF THE RESTAURANT TO REGISTER A ORDER: ");
				index = Integer.parseInt(sc.nextLine()) - 1;
				restaurantA.getRestaurants().get(index).showClients();
				System.out.println("PUT THE INDEX OF THE CLIENT TO CHANGE STATE A ORDER: ");
				indexc = Integer.parseInt(sc.nextLine()) - 1;
				Client client = restaurantA.getRestaurants().get(index).getClients().get(indexc);
				client.showOrders();
				int count = 0;
				for (int i = 0; i < client.getOrders().size(); i++) {
					if (client.getOrders().get(i).getRestaurantNit() == restaurantA.getRestaurants().get(index)
							.getNit()) {
						count++;
					}

				}
				if (count == client.getOrders().size()) {
					System.out.println("PUT THE INDEX OF THE ORDER TO CHANGE THE STATE");
					int indexS = Integer.parseInt(sc.nextLine()) - 1;
					System.out.println("PUT THE STATE - IN PROCESS|SHIPPED|DELIVERED");
					String state = sc.nextLine();
					try {
						client.changeState(state, indexS);
					} catch (ChangeStateException e) {

						e.printStackTrace();
					}
				}
				restaurantA.saveRestaurants();
				break;

			case SAVE:
				restaurantA.saveRestaurants();
				System.out.println("You save correctly");
				break;

			case IMPORT:
				System.out.println("WHAT INFORMATION YOU WANT IMPORT : " + "\n" + "1.RESTAURANTS" + "\n" + "2.CLIENTS"
						+ "\n" + "3.PRODUCTS" + "\n" + "4.ORDERS");
				int optionImport = Integer.parseInt(sc.nextLine());
				System.out.println("PUT THE PATH OF THE FILE TO IMPORT: ");
				String path = sc.nextLine();
				System.out.println("PUT THE SEPARATOR OF THE FILE TO IMPORT: ");
				String separator = sc.nextLine();
				int indexcl = 0;
				switch (optionImport) {

				case 1:
					try {

						restaurantA.importRestaurants(path, separator);
						System.out.println("IMPORT SUCCESFULLY");
						restaurantA.saveRestaurants();
					} catch (FileNotFoundException fne) {

						System.err.println(fne.getStackTrace());

					}

					break;

				case 2:

					restaurantA.showRestaurants();
					System.out.println("INSERT THE INDEX TO THE RESTAURANT TO IMPORT CLIENTS");
					indexcl = Integer.parseInt(sc.nextLine()) - 1;
					try {
						restaurantA.getRestaurants().get(indexcl).importClients(path, separator);
						System.out.println("IMPORT SUCCESFULLY");
						Collections.sort(restaurantA.getRestaurants().get(indexcl).getClients());
						restaurantA.saveRestaurants();
					} catch (FileNotFoundException fne) {

						System.err.println(fne.getStackTrace());
					}

					break;

				case 3:

					restaurantA.showRestaurants();
					System.out.println("INSERT THE INDEX TO THE RESTAURANT TO IMPORT PRODUCTS");
					indexcl = Integer.parseInt(sc.nextLine()) - 1;
					try {
						restaurantA.getRestaurants().get(indexcl).importProducts(path, separator);
						System.out.println("IMPORT SUCCESFULLY");
						restaurantA.saveRestaurants();
					} catch (FileNotFoundException fne) {

						System.err.println(fne.getStackTrace());
					}

					break;

				case 4:
					restaurantA.showRestaurants();
					System.out.println("PUT THE INDEX OF THE RESTAURANT IMPORT A ORDER: ");
					index = Integer.parseInt(sc.nextLine()) - 1;
					restaurantA.getRestaurants().get(index).showClients();
					System.out.println("PUT THE INDEX OF THE CLIENT TO IMPORT A ORDER: ");
					client = restaurantA.getRestaurants().get(index).getClients().get(indexcl);
					Restaurant restaurant = restaurantA.getRestaurants().get(index);
					indexc = Integer.parseInt(sc.nextLine()) - 1;
					try {

						client.importOrders(path, separator, restaurant.getNit(), restaurant,
								client.getIdentificationNumber());
						System.out.println("IMPORT SUCCESFULLY");
						restaurantA.saveRestaurants();
					} catch (FileNotFoundException fne) {
						System.err.println(fne.getStackTrace());
					}
					restaurantA.saveRestaurants();

					break;

				default:

					break;

				}

				break;

			case EXPORT:

				restaurantA.showRestaurants();
				System.out.println("PUT THE INDEX OF THE RESTAURANT TO EXPORT ORDERS: ");
				index = Integer.parseInt(sc.nextLine()) - 1;
				restaurantA.getRestaurants().get(index).showClients();
				System.out.println("PUT THE INDEX OF THE CLIENT TO EXPORT ORDERS: ");
				indexc = Integer.parseInt(sc.nextLine()) - 1;
				System.out.println("INSERT THE FILENAME");
				String filename = sc.nextLine();
				System.out.println("INSERT THE SEPARATOR");
				String separator2 = sc.nextLine();
				restaurantA.getRestaurants().get(index).getClients().get(indexc).export(filename, separator2);

				break;

			case SHOW:
				System.out.println("1.SHOW RESTAURANTS  2.SHOW CLIENTS 3.EXIT");
				option = Integer.parseInt(sc.nextLine());
				while (option != 3) {
					switch (option) {

					case 1:
						RestaurantComparator rc = new RestaurantComparator();
						Collections.sort(restaurantA.getRestaurants(), rc);
						String resorder = "";
						for (int i = 0; i < restaurantA.getRestaurants().size(); i++) {
							Restaurant restaurant = restaurantA.getRestaurants().get(i);
							resorder += (i + 1) + "." + restaurant.getNit() + "-" + restaurant.getName() + "-"
									+ restaurant.getNameAdmin() + "\n";

						}
						System.out.println(resorder);
						break;
					case 2:
						System.out.println("Put the index of the restaurant to show the clients");
						int indexR = Integer.parseInt(sc.nextLine()) - 1;
						Restaurant restaurant = restaurantA.getRestaurants().get(indexR);
						if (restaurant.getClients().size() != 0) {

							/** BUBBLE SORT */
							for (int i = 0; i < restaurant.getClients().size(); i++) {
								for (int j = 0; j < restaurant.getClients().size() - 1; j++) {

									if (restaurant.getClients().get(j).getPhone() < restaurant.getClients().get(j + 1)
											.getPhone()) {
										Client temp = restaurant.getClients().get(j);
										restaurant.getClients().set(j, restaurant.getClients().get(j + 1));
										restaurant.getClients().set(j + 1, temp);
									}

								}
							}
							for (int i = 0; i < restaurant.getClients().size(); i++) {

								System.out.println((i + 1) + "." + restaurant.getClients().get(i).toString());
							}

							Collections.sort(restaurant.getClients());
						} else {

							System.err.println("ERROR");
						}
						break;
					case 3:
						System.out.println("Exit...");
						break;
					default:
						System.err.println("You choose an invalid option");
						break;

					}
					break;
				}
				break;
			case FIND_CLIENT:
				restaurantA.showRestaurants();
				System.out.println("PUT THE INDEX OF THE RESTAURANT TO FIND A CLIENT: ");
				index = Integer.parseInt(sc.nextLine()) - 1;
				System.out.println("INSERT THE FIRSTNAME OF THE CLIENT // REMEMBER PUT THE FIRST LETTER IN MAYUS");
				String name = sc.nextLine();
				/** BINARY SEARCH */
				int start = 0;
				int end = restaurantA.getRestaurants().get(index).getClients().size() - 1;
				int position = 0;
				boolean encontre = false;
				long startCount = System.currentTimeMillis();
				while (start <= end && !encontre) {
					position = (start + end) / 2;
					client = restaurantA.getRestaurants().get(index).getClients().get(position);
					if ((client.getFirstName()).equalsIgnoreCase(name)) {

						System.out.println(client.toString());
						encontre = true;
					} else if (client.getFirstName().compareTo(name) > 0) {
						end = position - 1;
					} else {
						start = position + 1;
					}

				}
				long endCount = System.currentTimeMillis();
				if (encontre == false) {
					System.err.println("THE CLIENT WITH THIS NAME DOESNT EXIST");
				}
				System.out.println("TIME OF THE SEARCH: ");
				System.out.println("Start:" + startCount);
				System.out.println("End:" + endCount);
				System.out.println("End-Start:" + (endCount - startCount));
				break;

			default:
				System.out.println("THANKS FOR USE THE PROGRAM");
				break;

			}
		}
		sc.close();
	}

}
