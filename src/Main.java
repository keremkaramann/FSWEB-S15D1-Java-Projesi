import com.workintech.models.Contacts;
import com.workintech.models.GroceryList;
import com.workintech.models.MobilePhone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroceryList groceryList = new GroceryList();
        int choice;

        do {
            System.out.println("Enter number(0:close,1:add item('s),2:remove item: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter item('s) you want to add(use comma after one item!): ");
                    String itemsToAdd = scanner.nextLine();
                    groceryList.addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Enter item name to delete: ");
                    String itemsToRemove = scanner.nextLine();
                    groceryList.removeItems(itemsToRemove);
                    break;
            }
            groceryList.printSorted();
        } while (choice != 0);
        scanner.close();

        Contacts bob = new Contacts("Bob", "123456");
        Contacts alice = new Contacts("Alice", "234561");
        Contacts jane = new Contacts("Jane", "3456466");
        Contacts tom = new Contacts("Tom", "456123");

        MobilePhone mobile = new MobilePhone("12312444");
        mobile.addNewContact(bob);
        mobile.addNewContact(alice);
        mobile.addNewContact(jane);
        mobile.addNewContact(tom);
        System.out.println("******");
        mobile.printContact();
        System.out.println("update contact");
        boolean updateResult = mobile.updateContact(bob, new Contacts("Bob", "9999909"));
        mobile.printContact();
        System.out.println("update contact " + updateResult);
        System.out.println("remove contact");
        mobile.removeContact(jane);
        mobile.printContact();
        System.out.println("quary contact");
        Contacts contact = mobile.queryContact("Bob");
        System.out.println("query " + contact.getName() + "num: " + contact.getPhoneNum());
        System.out.println("find contact");
        int indexRestult = mobile.findContact(tom);
        System.out.println("index'i: " + indexRestult);
    }


}