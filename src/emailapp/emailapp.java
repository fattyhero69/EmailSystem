package emailapp;

import java.util.Scanner;

public class emailapp {
    public static void main(String[] args) {
        // Single instance
//        EmailObjs em1 = new EmailObjs();
//        System.out.println(em1.getUserInfo());
        System.out.println("How many people are being added to the system?");
        Scanner in = new Scanner(System.in);
        int userNum = in.nextInt();
        EmailObjs[] emails = new EmailObjs[userNum];
        // Create i email address
        for (int i = 0; i < userNum; i++) {
            emails[i] = new EmailObjs();
            System.out.println(emails[i].getUserInfo());
        }
    }
}
