# Bank-Castle (because Frank-Castle is unavailable)
A simple CLI bank app. This is made for a "introduction to Java" school assignment.
I have written everything in Visual Studio Code

This application is designed to handle multiple users and keep track of their accounts separately.
You will first have to create a user to log in.
After a user is created you are able to log in and also change the pin of any existing user.
You will also be able to use the admin function without logging in at this point.

After logging in you will have 4 options.
1 - view current balance.
2 - deposit a sum of your choice.
3 - withdraw a sum of your choice.
4 - log out. this will return to the first menu where you can change or create a new user.
5 - quit. Exits the program

There are no plans to save the users balance to a database at this point in time.

At first I wanted to save the pin codes and bank balance as integers. 
Because I wanted to keep all the user information in a simple array this was not possible. 
I decided to save integers as strings in the user information to keep it simple, with more time (and experience from my part) 
it would be more effecient to create a user class that can handle different variable types more easily. 
This would also improve the security of the user informationby being able to be kept private. 
I have created new classes that could do this in the past but only in C# and never in Java.
This challenged me a bit anyway because the handling of the List class is slightly different between C# and Java.
Another thing that made me scratch my head was that you can't compare strings in Java using "==", but you have to call for the ".equals(otherString)" method instead 

I planned to make some of the extra challenges from the start. This helped me because I created the user information into a ArrayList
from the start instead of adding it later. I reused some things that I played around with last week, like a for loop to search for a specific user in the list.
