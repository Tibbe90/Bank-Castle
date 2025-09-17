# Bank-Castle (because Frank-Castle is unavailable)
A simple CLI bank app. Aim is easy of use with essential functions.

This application is designed to handle multiple users and keep track of their accounts separately.
You will first have to create a user to log in.
You will also be able to use the admin function without logging in at this point.

After logging in you will have 4 options.
1 - view current balance.
2 - deposit a sum of your choice.
3 - withdraw a preset sum or a sum of your choice.
4 - quit. Either quit the program or go back to the login.

There are no plans to save the users balance to a database at this point in time.

I have decided to save integers as strings in the user information to keep it simple, with more time it would be more effecient to 
create a user class that can handle different variable types more easily. This would also improve the security of the user information
by being inaccessible to the user part of the program.
