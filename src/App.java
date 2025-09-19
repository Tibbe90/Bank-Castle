import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String[]> userList = new ArrayList<String[]>();
        String[] currentUser = new String[3]; 
        /*
         * currentUser[0] = Username
         * currentUser[1] = Pin Code
         * currentUser[2] = Bank Balance
         */
        String[] transactionHistory = new String[]{"Still empty","Still empty","Still empty","Still empty","Still empty","Still empty"};
        int transactionCounter = 0; //Makes sure the transactionHistory doesn't go out of bounds.
        int loggedInUserNr = 0; //Tracks the index of the logged in user
        Boolean running = true; //Boot menu
        Boolean loggedIn = false; //Logged in menu
        int Startmenu = 0;
        while(running) 
        {
            login();
        try 
        {
            Startmenu = userInput.nextInt();
        } 
        catch (Exception e) 
        {
            errorMessage();
            Startmenu = 0;
        }
            userInput.nextLine();
            switch (Startmenu)
            {
                case 1: //Log in
                {
                    loggedInUserNr = findUser(userInput, userList);
                    if (loggedInUserNr == -1) //Makes sure a user was found
                        break;
                    System.out.println("Enter your pin code");
                    if (userList.get(loggedInUserNr)[1].equals(userInput.nextLine())) 
                    {
                        loggedIn = true;
                        break;
                    }
                    System.out.println("Wrong Pin Code\n");
                    break;
                }
                case 2: //Change pin code
                {
                    loggedInUserNr = findUser(userInput, userList);
                    if (loggedInUserNr == -1) //Makes sure a user was found
                        break;
                    System.out.println("User found, enter your new pin code");
                    userList.get(loggedInUserNr)[1] = userInput.nextLine();
                    break;
                }
                case 3: //Create user
                {
                    currentUser = createUser(userInput);
                    userList.add(currentUser);
                    break;
                }
                case 4: //Quit
                {
                    exitMessage();
                    running = false;
                    break;
                }
                case 9: //Display latest transactions
                {
                    printTransactions(transactionHistory);
                    break;
                }
                default:
                {
                    System.out.println("Invalid option");
                }
            }
            
            while (loggedIn)
            {
                menu();
                int newBalance;
                int loggedInMenu = 0;
                int transaction = 0;
                if (transactionCounter == transactionHistory.length)
                        transactionCounter = 0;
                try 
                {
                    loggedInMenu = userInput.nextInt();
                } 
                catch (Exception e) 
                {
                    errorMessage();
                    loggedInMenu = 0;
                }
                userInput.nextLine();
                switch (loggedInMenu) 
                {
                    case 1: //Show balance
                        printBalance(Integer.parseInt(userList.get(loggedInUserNr)[2]));
                        break;

                    case 2: //Deposit money and update transaction history
                        newBalance = deposit(userInput, Integer.parseInt(userList.get(loggedInUserNr)[2]));
                        transaction = newBalance - Integer.parseInt(userList.get(loggedInUserNr)[2]);
                        userList.get(loggedInUserNr)[2] = Integer.toString(newBalance);  
                        transactionHistory[transactionCounter] = transactionHistoryUpdate(userList, loggedInUserNr, transaction);
                        transactionCounter++;
                        break;
                
                    case 3: //Withdraw money and update transaction history
                        newBalance = withdraw(userInput, Integer.parseInt(userList.get(loggedInUserNr)[2]));
                        transaction = newBalance - Integer.parseInt(userList.get(loggedInUserNr)[2]);
                        userList.get(loggedInUserNr)[2] = Integer.toString(newBalance);
                        transactionHistory[transactionCounter] = transactionHistoryUpdate(userList, loggedInUserNr, transaction);
                        transactionCounter++;
                        break;
                
                    case 4: //Go back to the login menu
                        logOffMessage();
                        loggedIn = false;
                        break;
                
                    case 5: //Shut down the program
                        exitMessage();
                        loggedIn = false;
                        running = false;
                        break;
                
                    default:
                    {
                        System.out.println("Invalid option");
                    }
                        break;
                }
            }
        }
        userInput.close();
    }
    //Prints the login menu
    public static void login()
    {
        System.out.println("Welcome to Bank-Castle!\n" +
        "What do you want to do? Insert the corresponding number\n" +
        "1 - Log in\n" +
        "2 - Change pin code\n" +
        "3 - Create a new user\n" +
        "4 - Quit\n" +
        "9 - *ADMIN* Display the 6 latest transactions\n");
    }
    
    //Prints the logged in menu
    public static void menu() 
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
    public static void printTransactions(String[] transactionHistory)
    {
        for (int i = 0; i < transactionHistory.length; i++)
        {
            System.out.println(transactionHistory[i] + "\n");
        }
    }
    //User did not enter an integer (probably)
    public static void errorMessage() 
    {
        System.out.println("Something went wrong, the application can only handle numbers." +
            " Text and symbols do not work.");
    }  
    // An exit message that is used more than once
    public static void exitMessage()
    {
        System.out.println("See you later!");
    }
    // A log out message
    public static void logOffMessage()
    {
        System.out.println("Going back to login..");
    }
    // Creates the user information array
    public static String[] createUser(Scanner userInput)
    {
        String[] newUser = new String[3];
        System.out.println("Type in your name");
        newUser[0] = userInput.nextLine();
        System.out.println("Enter your pin code");
        newUser[1] = userInput.nextLine();
        newUser[2] = "0";
        return newUser;
    }
    //Change your pin code
    public static int findUser(Scanner userInput, ArrayList<String[]> userList)
    {
        if (userList.size() == 0)
        {
            System.out.println("There are no users yet\n");
            return -1;
        }
        System.out.println("Type in your username");
        String userSearch = userInput.nextLine();
        for (int i = 0 ; i < userList.size() ; i++)
        {
            if (userList.get(i)[0].equals(userSearch))
            {
                int userNr = i;
                return userNr;
            }
        }
        System.out.println("User not found\n");
        return -1;
    }
    //Prints the current balance
    public static void printBalance(int balance)
    {
        System.out.println("Your current balance is: " + balance + "kr\n");
    }
    //Makes a deposit to the logged in account
    public static int deposit(Scanner userInput, int currentBalance)
    {
        System.out.println("How much money do you want to deposit?");
        int deposit = 0;
        try 
        {
            deposit = userInput.nextInt();
        } 
        catch (Exception e) 
        {
            errorMessage();
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
    public static int withdraw(Scanner userInput, int currentBalance)
    {
        System.out.println("How much money do you want to withdraw?");
        int withdraw = 0;
        try 
        {
            withdraw = userInput.nextInt();
        } 
        catch (Exception e) 
        {
            errorMessage();
            userInput.nextLine();
        }
        if (withdraw < 0) 
        {
            System.out.println("You cannot deposit money with the the withdrawal option");
            return currentBalance;
        }
        if (withdraw > currentBalance) 
        {
            System.out.println("Unfortunately there isn't enough money in your account for this withdrawal");
            return currentBalance;

        }
        currentBalance -= withdraw;
        return currentBalance;
    }
    //Updates the transaction History string[] with the transaction, name, new balance and the date
    public static String transactionHistoryUpdate(ArrayList<String[]> userList, int loggedInUserNr, int transaction) 
    {
        LocalDateTime transactionTime = LocalDateTime.now();
        DateTimeFormatter transactionDisplayFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        String transactionDisplayTime = transactionTime.format(transactionDisplayFormat);
        String transactionString = userList.get(loggedInUserNr)[0] + " made a " + 
        transaction + "kr transaction on " + transactionDisplayTime + " and their new balance is " + userList.get(loggedInUserNr)[2];
        return transactionString;
    }
}