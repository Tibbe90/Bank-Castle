import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String[]> userList = new ArrayList<String[]>();
        String[] currentUser = new String[3]; 
        int loggedInUserNr = 0;
        /*
         * currentUser[0] = Username
         * currentUser[1] = Pin Code
         * currentUser[2] = Bank Balance
         */
        Boolean running = true;
        Boolean loggedIn = false;
        while(running) 
        {
            Login();
            int Startmenu = userInput.nextInt();
            userInput.nextLine();
            switch (Startmenu)
            {
                case 1: //Log in
                {
                    System.out.println("Type in your username");
                    String userSearch = userInput.nextLine();
                    for (int i = 0 ; i < userList.size() ; i++)
                        {
                            if (userList.get(i)[0].equals(userSearch))
                            {
                                System.out.println("Enter your pin code");
                                if (userList.get(i)[1].equals(userInput.nextLine())) 
                                {
                                    loggedInUserNr = i;
                                    loggedIn = true;
                                    break;
                                }
                                System.out.println("Wrong Pin Code");
                            }
                        }
                        if (loggedIn == false)
                        {
                            System.out.println("User not found");
                        }
                    break;
                }
                case 2: //Create user
                {
                    currentUser = CreateUser(userInput);
                    userList.add(currentUser);
                    break;
                }
                case 3: //Quit
                {
                    System.out.println("See you soon!");
                    running = false;
                    break;
                }
            }
            
            while (loggedIn)
            {
                Menu();
                int newBalance;
                int loggedInMenu = userInput.nextInt();
                userInput.nextLine();
                switch (loggedInMenu) 
                {
                    case 1:
                        PrintBalance(Integer.parseInt(userList.get(loggedInUserNr)[2]));
                        break;
                
                    case 2:
                        newBalance = Deposit(userInput, Integer.parseInt(userList.get(loggedInUserNr)[2]));
                        userList.get(loggedInUserNr)[2] = Integer.toString(newBalance);  
                        break;
                
                    case 3:
                        newBalance = Withdraw(userInput, Integer.parseInt(userList.get(loggedInUserNr)[2]));
                        userList.get(loggedInUserNr)[2] = Integer.toString(newBalance);
                        break;
                
                    case 4:
                        System.out.println("Logging out..");
                        loggedIn = false;
                        break;
                
                    case 5:
                        System.out.println("See you later!");
                        loggedIn = false;
                        running = false;
                        break;
                
                    default:
                        break;
                }
            }
        }
        userInput.close();
    }
    //Prints the login menu
    public static void Login()
    {
        System.out.println("Welcome to Bank-Castle!\n" +
        "What do you want to do? Insert the corresponding number\n" +
        "1 - Log in\n" +
        "2 - Create a new user\n" +
        "3 - Quit");
    }
    
    //Prints the logged in menu
    public static void Menu() 
    {
        System.out.println("\n----------------------------------------------------------------" +
        "\n\tYou have logged in succesfully. Insert the corresponding menu number to access it." +
        "\n\t\t 1 - Display you balance" +
        "\n\t\t 2 - Deposit" + 
        "\n\t\t 3 - Withdraw" + 
        "\n\t\t 4 - Log off" +
        "\n\t\t 5 - Exit the application" +
        "\n----------------------------------------------------------------");
    }
        
    // Creates the user information array
    public static String[] CreateUser(Scanner userInput)
    {
        String[] newUser = new String[3];
        System.out.println("Type in your name");
        newUser[0] = userInput.nextLine();
        System.out.println("Enter your pin code");
        newUser[1] = userInput.nextLine();
        newUser[2] = "0";
        return newUser;
    }
    //Prints the current balance
    public static void PrintBalance(int balance)
    {
        System.out.println("Your current balance is: " + balance + "kr\n");
    }
    //Makes a deposit to the logged in account
    public static int Deposit(Scanner userInput, int currentBalance)
    {
        System.out.println("How much money do you want to deposit?");
        int deposit = 0;
        try 
        {
            deposit = userInput.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println("Something went wrong, the application can only handle numbers." +
            " Text and symbols do not work.");
            userInput.nextLine();
        }
        if (deposit < 0) 
        {
            System.out.println("You cannot withdraw money with the the deposit option");
            return currentBalance;
        }
        currentBalance += deposit;
        return currentBalance;
    }
    //Makes a withdrawal
    public static int Withdraw(Scanner userInput, int currentBalance)
    {
        System.out.println("How much money do you want to withdraw?");
        int withdraw = 0;
        try 
        {
            withdraw = userInput.nextInt();
        } 
        catch (Exception e) 
        {
            System.out.println("Something went wrong, the application can only handle numbers." +
            " Text and symbols do not work.");
            userInput.nextLine();
        }
        if (withdraw < 0) 
        {
            System.out.println("You cannot deposit money with the the withdrawal option");
            return currentBalance;
        }
        if (withdraw > currentBalance) 
        {
            System.out.println("Unfortunately there isn't enough money in you account for this withdrawal");
            return currentBalance;
        }
        currentBalance -= withdraw;
        return currentBalance;
    }
}
