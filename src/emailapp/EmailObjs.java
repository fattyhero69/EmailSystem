package emailapp;

import java.util.Scanner;

public class EmailObjs {
    public String firstName;
    public String lastname;
    public String department;
    public String company;
    public String password;
    public String altEmail;
    public int passwordLength;
    public int diffpassLength;
    public int month, date, year;
    public int cap, defcap = 1000;

    // Constructor
    public EmailObjs() {
        // Gather information about user.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name:");
        this.firstName = sc.nextLine();
        System.out.println("Enter last name:");
        this.lastname = sc.nextLine();
        System.out.println("Enter company name:");
        this.company = sc.nextLine();
        System.out.println("Enter your date of birth (MM/DD/YYYY)");
        this.month = sc.nextInt();
        this.date = sc.nextInt();
        this.year = sc.nextInt();

        // Call department method
        this.department = setDepartment();
        System.out.println("Department chosen: " + this.department);

        // Call email set method
        System.out.println("Your email address is: " + setEmail()); // Move this to the end

        // Call password generator method
        System.out.println("Enter desired length of password:");
        this.passwordLength = sc.nextInt();
        this.password = generatePassword(this.passwordLength);
        System.out.println("Your password is: " + this.password);

//         Ask if user wants to change password (if yes, then call method)
        System.out.println("Are you satisfied with your current password? (y/n)");
        Scanner news = new Scanner(System.in);
        String ans = news.nextLine();
        if (ans.equals("n")) {
            this.password = changePassword(); // Overrides previous password
            System.out.println("Your new password is: " + this.password);
        }
        System.out.println("Would you like another email address? (y/n)");
        Scanner yourCall = new Scanner(System.in);
        String confirmed = yourCall.nextLine();
        if (confirmed.equals("y")) {
            // Create alt email
            this.altEmail = altEmailaddr();
            System.out.println("Your alternate email address is: " + this.altEmail);
        }
        System.out.println("Your default mailbox capacity is: " + defcap + "mb" +
                "\nWould you like to increase the capacity? (y/n)");
        String call = yourCall.nextLine();
        if (call.equals("y")) {
            this.cap = setmailboxCap(defcap);
            System.out.println("Your new mailbox capacity is: " + this.cap + "mb");
        }
    }

    // Methods (All private setters)
    // Set department method
    private String setDepartment() {
        System.out.println("Choose department:\n1-Coding \n2-Development \n3-Advertising \n4-Human Resources \n0-None");
        Scanner scan = new Scanner(System.in);
        int response = scan.nextInt();
        // Sets and prints department according to users response
        if (response == 1) {
            return "coding";
        } else if (response == 2) {
            return "dev";
        } else if (response == 3) {
            return "ad";
        } else if (response == 4) {
            return "hr";
        } else
            return "";
    }

    // Set email address
    private String setEmail() {
        // If department is unknown
        if (this.department.equals("")) {
            return this.firstName.toLowerCase()
                    + "." + this.lastname.toLowerCase()
                    + "@" + this.company.toLowerCase().replaceAll(" ", "")
                    + ".com";
        }
        // If department chosen from selection
        return this.firstName.toLowerCase()
                + "." + this.lastname.toLowerCase()
                + "@" + this.department.toLowerCase()
                + "." + this.company.toLowerCase().replaceAll(" ", "")
                + ".com";
    }

    //Generate a random password
    private String generatePassword(int passLen) {
        String passwordPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*";
        char[] password = new char[passLen];
        for (int i = 0; i < passLen; i++) {
            // Picks character at random location in passwordPool string
            int randomNum = (int) (Math.random() * passwordPool.length());
            // Adds to whole password until desired length is reached
            password[i] = passwordPool.charAt(randomNum);
        }
        return new String(password);
    }

    // Change password?
    private String changePassword() {
        System.out.println("Enter new password length:");
        Scanner in = new Scanner(System.in);
        diffpassLength = in.nextInt();
        // If user provides same length but wants a different password
        if (diffpassLength == passwordLength) {
            return this.password = generatePassword(passwordLength);
        } else {
            // Calls generate password method again if user gives a different length
            return generatePassword(diffpassLength);
        }
    }

    // Set mailbox capacity
    private int setmailboxCap(int cap) {
        // Doubles the capacity
        return 2 * cap;
    }

    // Provide an alternate email
    private String altEmailaddr() {
        // If department is unknown
        if (this.department.equals("")) {
            return this.lastname.toLowerCase() + "."
                    + this.firstName.toLowerCase() + this.year +
                    "@" + this.company.toLowerCase().replaceAll(" ", "") + ".com";
        }
        // If department is chosen
        return this.lastname.toLowerCase() + "." + this.firstName.toLowerCase() + this.year + "@"
                + this.company.toLowerCase().replaceAll(" ", "") + "." + this.department.toLowerCase() + ".com";
    }

    //    // Getters
//    // Get password
//    public String getGeneratedPassword(){
//        return this.password;
//    }
//    // Get mailbox capacity
//    public int getMailboxCapacity(){
//        return this.cap;
//    }
//    // Get alt email
//    public String getAltEmail(){
//        return this.altEmail;
//    }
//    // Get user's name
//    public String getUserName(){
//        return this.firstName + " " + this.lastname;
//    }
//    // Get company name
//    public String getComanyName(){
//        return this.company;
//    }
//    // Get DOB
//    public String getBirthday(){
//        return this.month + "/" + this.date + "/" + this.year;
//    }
    // Get user information (All getters in one)
    // Prints all relevant information about user for the email address
    public String getUserInfo() {
        return "You are " + this.firstName + " " + this.lastname
                + "\nYour DOB is " + this.month + "/" + this.date + "/" + this.year
                + "\nYour primary email address is: " + this.setEmail()
                + "\nYour alternate emaill address is: " + this.altEmail
                + "\nYour password is " + "'" + this.password + "'"
                + "\nYour mailbox capacity is " + this.cap + "mb";
    }
}
