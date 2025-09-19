# Bank-Castle - Tibbes bank application
(because Frank-Castle is unavailable)

A CLI bank app. This is made for my "introduction to Java" school assignment.
I have written everything in Visual Studio Code

This application is designed to handle multiple users and keep track of their accounts separately.
You will first have to create a user to log in.
After a user is created you are able to log in and also change the pin of any existing user.
You will have the following options at startup:
1 - Log in
2 - Change pin code
3 - Create a new user
4 - Quit
9 - *ADMIN* Display the 6 latest transactions

After logging in you will have another 5 options:
1 - view current balance.
2 - deposit a sum of your choice.
3 - withdraw a sum of your choice.
4 - log out. this will return to the first menu where you can change or create a new user.
5 - quit. Exits the program

There are no plans to save the users balance to a database at this point in time.
All menu options besides shutting the program down does most of its actions through methods.

At first I wanted to save the pin codes and bank balance as integers. 
Because I wanted to keep all the user information in a simple array, this was not possible. 
I decided to save integers as strings in the user information to keep it simple, with more time (and experience from my part) 
it would be more effecient to create a user class that can handle different variable types more easily. 
This would also improve the security of the user informationby being able to be kept private. 
I will practise this in the future.

I have created new classes that could do this in the past but only in C# and never in Java.
This challenged me a bit anyway because the handling of the List class is slightly different between C# and Java.
Another thing that made me scratch my head was that you can't compare strings in Java using "==", but you have to call for the ".equals(otherString)" method instead 

I planned to make some of the extra challenges from the start. This helped me because I created the user information into a ArrayList
from the start instead of adding it later. I reused some things that I played around with last week, like a for loop to search for a specific user in the list.
I decided to add support for several users, give each user a pin code (The pin code is decided by the user upon user creation). Each user has their own information
saved in an ArrayList so you can create as many users as you like and everyone will have their own name, pin and account balance.

I had some time over so I decided to create a transaction history, I created a method that adds a string to the complete transaction information into an array.
The array is then looped through when the option to display transaction history is selected in the login menu. The array can be changed to save any number of transactions you desire,
because the length of the array is always checked and never hard coded.
