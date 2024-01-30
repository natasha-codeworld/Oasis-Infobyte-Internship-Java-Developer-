# Oasis-Infobyte-Internship-Java-Developer-
ATM Interface-Task 3-Oasis Infobyte Internship

1. Class Definition:
The code defines a class named ATMInterface that simulates a basic ATM interface.

2. File Name Constant:
The FILE_NAME variable stores the name of the file used to store transaction data (transactionDetails.txt).

3. Methods:
displayMenu(): Displays a menu of options for the user to choose from (transaction history, withdraw, deposit, transfer, exit).
transactionHistory(): Reads and displays the transaction history from the file.
withdrawMoney(): Processes a withdrawal, updates the balance in the file, and records the transaction.
depositMoney(): Processes a deposit, updates the balance in the file, and records the transaction.
transferMoney(): Processes a transfer to another account, updates the balance in the file, and records the transaction.
main(): The main method that runs the program, displaying the menu and handling user choices.

4. User Input and Actions:
The code takes user input through the console to make choices and enter amounts for transactions.
It uses Java's file I/O features to read and write data to the transactionDetails.txt file.

5. Transaction Handling:
Each transaction method (withdraw, deposit, transfer) reads the current balance from the file, updates it based on the transaction, and writes the updated balance back to the file.
Transactions are also recorded in the file with details like transaction ID, account number, amount, and date.
