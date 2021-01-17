package shelforganiser;

import java.util.ArrayList;
import java.util.Scanner;

public class ShelfOrganiser {
    
    public static Scanner scan = new Scanner (System.in);
    public static ArrayList<item>shelf = new ArrayList<>();

    public static void main(String[] args) {
        scan.useDelimiter("\n");
        menu();
    }
    
    public static void menu(){
        System.out.println("welcome to the inventory your shelf, would you like to:");
        System.out.println("1 - add to the shelf");
        System.out.println("2 - view items on shelf");
        System.out.println("3 - edit an item");
        System.out.println("4 - delete an item");
        System.out.println("0 - exit");
        int userChoise = scan.nextInt();

            switch (userChoise) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewItem();
                    break;
                case 3:
                    editItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 0:
                    System.exit(0);
            }
    }
    
    public static void addItem(){
        System.out.println("please type in the name of the item");
        String name = scan.next();
        System.out.println("please type in the date you recived the item");
        String dateRecived = scan.next();
        System.out.println("please type in the regularity of this items use (high, medium, low)");
        String usage = scan.next();
        
        item myItem = new item(name, dateRecived, usage);
        shelf.add(myItem);
        System.out.println(myItem.toString());
        menu();
    }
    
    public static void viewItem(){
        if(shelf.isEmpty()){
            System.out.println("sorry you don't appear to have any items on your shelf");
        } else {
            for (int i = 0; i < shelf.size(); i++) {
                System.out.println(shelf.get(i).toString());
            }
        }
        menu();
    }
    
    public static void editItem(){
        int index = getIndex();
        
        if(index != -1){
            System.out.println("what would you like to edit?");
            System.out.println("1 - name");
            System.out.println("2 - date recived");
            System.out.println("3 - usage");
            int userChoice = scan.nextInt();
            
            switch (userChoice){
                case 1:
                    System.out.println("Please type in a name");
                    String newName = scan.next();
                    shelf.get(index).setName(newName);
                    break;
                case 2:
                    System.out.println("Please type in the date recived");
                    String newDateRecived = scan.next();
                    shelf.get(index).setDateRecived(newDateRecived);
                    break;
                case 3:
                    System.out.println("Please type in the new usage (high, medium, low)");
                    String newUsage = scan.next();
                    shelf.get(index).setUsage(newUsage);
                    break;
            }
            System.out.println("your item has been changed to " + shelf.get(index).toString());
        }else{
            System.out.println("item not found");
        }
        menu();
    }
    
    public static void deleteItem(){
        int index = getIndex();
        if(index != -1){
            shelf.remove(index);
            System.out.println("your item was removed");
        }else{
            System.out.println("item not found");
        }
        menu();
    }
    
    public static int getIndex(){
        System.out.println("please type in the name of the item");
        String name = scan.next();

        if (!shelf.isEmpty()) {
            for (int i = 0; i < shelf.size(); i++) {
                if (name.equals(shelf.get(i).getName())) {
                    return i;
                }
            }
        }
        return -1;
    }
    
}
