import java.util.ArrayList;
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
         * currentUser[2] = Bank Balace
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
                int loggedInMenu = userInput.nextInt();
                userInput.nextLine();
                switch (loggedInMenu) 
                {
                    case 1:
                        
                        break;
                
                    case 2:
                        
                        break;
                
                    case 3:
                        
                        break;
                
                    case 4:
                        
                        break;
                
                    case 5:
                        
                        break;
                
                    default:
                        break;
                }
                loggedIn = false;
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
}
