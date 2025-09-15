import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("Welcome to Bank-Castle!\n" +
        "What do you want to do? Insert the corresponding number\n" +
        "1 - Log in\n" +
        "2 - Create a new user\n" +
        "3 - Quit");
        int Startmenu = userInput.nextInt();
        switch (Startmenu)
        {
            case 1:
            {
                System.out.println("Inne i switchen");
            }
        }
            
        Boolean loggedIn = true;
        
        while (loggedIn)
        {
        
        }
        userInput.close();
    }
}
