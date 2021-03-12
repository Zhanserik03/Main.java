package com.company;

import com.company.controllers.TECHController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
private final TECHController controller;
private final Scanner scanner;
public MyApplication(TECHController controller){
    this.controller = controller;
    scanner = new Scanner(System.in);
}
    public void start(){
    while (true){
        System.out.println();
        System.out.println("Here's the MyApplication");
        System.out.println("Select option: (0-5)");
        System.out.println("1.Get all techs");
        System.out.println("2.Get tech by id");
        System.out.println("3.Get tech by name");
        System.out.println("4.Remove tech");
        System.out.println("5.Get tech by price range");
        System.out.println("0.Exit");
        System.out.println();
        try {
            System.out.println("Enter the option: (0-5)");
            int option = scanner.nextInt();
            if(option==1){
            getAllTECHsMenu();
            }
            else if(option==2){
            getTECHById();
            }
            else if(option==3){
            GetTECHByNAME();
            }
            else if(option==4){
            RemoveTechByID();
            }
            else if(option==5){
                GetTechByPrice();
            }

            else if(option==0){
            break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("**********************************");
        }
    }
    public void getAllTECHsMenu(){
    String response = controller.getAllTechs();
        System.out.println(response);
    }
    public void getTECHById(){
        System.out.println("Please enter id");
        int ID = scanner.nextInt();
        String response = controller.getTech(ID);
        System.out.println(response);
    }

   public void GetTECHByNAME(){
       System.out.println("Please enter the name");
       scanner.nextLine();
       String NAME = scanner.nextLine();
       System.out.println(controller.getTechByName(NAME));
   }
   public void RemoveTechByID(){
       System.out.println("Please enter the id");
       int ID = scanner.nextInt();
       System.out.println(controller.removeTechByID(ID));
   }
   public void GetTechByPrice(){
       System.out.println("Please enter the price1");
       int price1 = scanner.nextInt();
       System.out.println("Please enter the price2");
       int price2 = scanner.nextInt();
       System.out.println(controller.getTechByPrice(price1,price2));
   }
}
