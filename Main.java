package DBBLBANK;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Customer c1 = new Customer("rony das",7485685,"@gmail.com",45857145,
             9853,2007);
        c1.setBalance(500);
        c1.ATM();

    }
}
