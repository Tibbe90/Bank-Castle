# Bank-Castle (because Frank-Castle is unavailable)
A simple CLI bank app. Aim is easy of use with essential functions.

This application is designed to handle multiple users and keep track of their accounts separately.
You will first have to create a user to log in.
After a user is created you are able to log in and also change the pin of any user.
You will also be able to use the admin function without logging in at this point.

After logging in you will have 4 options.
1 - view current balance.
2 - deposit a sum of your choice.
3 - withdraw a sum of your choice.
4 - log out. this will return to the first menu where you can change or create a new user.
5 - quit. Exits the program

There are no plans to save the users balance to a database at this point in time.

At first I wanted to save the pin codes and bank balance as integers. 
Because I wanted to keep all the user information in a simple array this was not possible so I 
decided to save integers as strings in the user information to keep it simple, with more time it would be more effecient to 
create a user class that can handle different variable types more easily. This would also improve the security of the user information
by being able to be kept private. I have created new classes that could do this in the past but only in C# and never in Java.

I planned to make some of the extra challenges from the start. This helped me because I created the user information into a ArrayList
from the start instead of adding it later. I reused some things that I played around with last week, like a for loop to search for a specific user.
