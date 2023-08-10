import java.util.Scanner;

class BankAccount {

	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";

	// BankAccount(String name, String userName, String password, String accountNo)
	// {
	// this.name = name;
	// this.userName = userName;
	// this.password = password;
	// this.accountNo = accountNo;
	// }

	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name - ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username - ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password - ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number - ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration completed..kindly login");
		System.out.println("******************************");

	}

	public boolean login() {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while (!isLogin) {
			System.out.print("\nEnter Your Username - ");
			String Username = sc.nextLine();
			if (Username.equals(userName)) {
				while (!isLogin) {
					System.out.print("\nEnter Your Password - ");
					String Password = sc.nextLine();
					if (Password.equals(password)) {
						System.out.print("\nLogin successful!!");
						System.out.println("********************");

						isLogin = true;
					} else {
						System.out.println("\nIncorrect Password");
					}
				}
			} else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}

	public void withdraw() {

		System.out.print("\nEnter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {

			if (balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);

			} else {
				System.out.println("\nInsufficient Balance");
			}

		} catch (Exception e) {
		}
	}

	public void deposit() {

		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();

		try {
			if (amount <= 100000f) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			} else {
				System.out.println("\nSorry...Limit is 100000.00");
			}

		} catch (Exception e) {
		}
	}

	public void transfer() {

		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name - ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float amount = sc.nextFloat();

		try {
			if (balance >= amount) {
				if (amount <= 50000f) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				} else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			} else {
				System.out.println("\nInsufficient Balance");
			}
		} catch (Exception e) {
		}
	}

	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}

	public void transHistory() {
		if (transactions == 0) {
			System.out.println("\nEmpty");
		} else {
			System.out.println("\n" + transactionHistory);
		}
	}
}

public class AtmInterface {

	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;

		while (!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;

				if (flag && input > limit || input < 1) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		}
		;
		return input;
	}

	public static void main(String[] args) {

		System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);

		if (choice == 1) {
			BankAccount b = new BankAccount();
			b.register();
			while (true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if (ch == 1) {
					if (b.login()) {
						System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println(
									"\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch (c) {
								case 1:
									b.withdraw();
									break;
								case 2:
									b.deposit();
									break;
								case 3:
									b.transfer();
									break;
								case 4:
									b.checkBalance();
									break;
								case 5:
									b.transHistory();
									break;
								case 6:
									isFinished = true;
									break;
							}
						}
					}
				} else {
					System.exit(0);
				}
			}
		} else {
			System.exit(0);
		}

	}
}

// package classFiles;
// import java.util.ArrayList;
// import java.util.Scanner;
// class bankaccount{
// static void register(){
// Scanner sc=new Scanner(System.in);
// System.out.println("=========================");
// System.out.println("Enter your name :");
// ATM.name=sc.nextLine();
// System.out.println("Enter user id :");
// String user=sc.nextLine();
// System.out.println("Enter password :");
// String pass=sc.nextLine();
// System.out.println("REGISTRATION SUCCESSFUL!");
// System.out.println("=========================");
// ATM.menu();
// while(true){
// display(ATM.name);
// int choice=sc.nextInt();
// if(choice==1){
// login(user,pass);
// break;
// }
// else {
// if(choice==2){
// System.exit(0);
// }
// else{
// System.out.println("Wrong choice! Enter again!");
// }
// }
// }
// }
// static void display(String name){}
// static void login(String user,String pass){}
// }
// class transaction{
// static void withdraw(){
// Scanner sc=new Scanner(System.in);
// System.out.println("=========================");
// System.out.println("Enter amount to withdraw :");
// int wcash=sc.nextInt();
// if(wcash<=ATM.balance){
// ATM.balance=ATM.balance-wcash;
// ATM.history.add(Integer.toString(wcash));
// ATM.history.add("Withdraw");
// System.out.println("Rs."+wcash+"/- withdrawn successfully");
// System.out.println("=========================");
// }
// else{
// System.out.println("Insufficient balance to withdraw the cash");
// System.out.println("=========================");
// }
// ATM.menu();
// }
// static void deposit(){
// Scanner sc=new Scanner(System.in);
// System.out.println("=========================");
// System.out.print("Enter amount to deposit :");
// int dcash=sc.nextInt();
// ATM.updatebalance(dcash);
// ATM.history.add(Integer.toString(dcash));
// ATM.history.add("Deposit");
// System.out.println("Rs."+dcash+"/- deposited successfully!");
// System.out.println("=========================");
// ATM.menu();
// }
// static void transfer(){
// Scanner sc=new Scanner(System.in);
// System.out.println("Enter the receiver's name:");
// String s=sc.nextLine();
// System.out.println("Enter the account number of the receiver");
// int num=sc.nextInt();
// System.out.println("Enter the amount to be transferred :");
// int tcash=sc.nextInt();
// if(tcash<=ATM.balance){
// ATM.balance=ATM.balance-tcash;
// ATM.history.add(Integer.toString(tcash));
// ATM.history.add("transferred");
// System.out.println("Rs."+tcash+"/- transferred successfully");
// System.out.println("=========================");
// }
// else{
// System.out.println("Insufficient balance to transfer the cash");
// System.out.println("=========================");
// }
// }
// }
// class check{
// static void checkbalance(){
// System.out.println("=========================");
// System.out.println("The available balance in the bank account :");
// ATM.showbalance();
// System.out.println("=========================");
// ATM.menu();
// }
// }
// class his{
// static void transactionhistory(){
// System.out.println("=========================");
// System.out.println("Transaction History :");
// int k=0;
// if(ATM.balance>0){
// for(int i=0;i<(ATM.history.size()/2);i++)
// {
// for(int j=0;j<2;j++)
// {
// System.out.print(ATM.history.get(k)+" ");
// k++;
// }
// System.out.println("=========================");
// }
// }
// else {
// System.out.println("Your account is empty");
// }
// ATM.menu();
// }
// }
// public class ATM {
// public static String name;
// public static int balance=0;
// public static ArrayList<String> history=new ArrayList<String>();

// static void updatebalance(int dcash){
// balance=balance+dcash;
// }
// static void showbalance(){
// System.out.println(balance);
// }
// public static void homepage(){
// System.out.println("\033[H\033[2J");
// Scanner sc=new Scanner(System.in);
// System.out.println("WELCOME TO ATM INTERFACE");
// System.out.println("=========================");
// System.out.println("Select option :");
// System.out.println("1. Register");
// System.out.println("2. Exit");
// System.out.println("Enter choice");
// int choice =sc.nextInt();
// if (choice==1){
// bankaccount.register();
// }
// else {
// if(choice==2){
// System.exit(0);
// }
// else{
// System.out.println("Select correctly");
// homepage();
// }
// }
// }
// static void menu(){
// Scanner sc=new Scanner(System.in);
// System.out.println("WELCOME "+ATM.name+"! TO OUR ATM SYSTEM");
// System.out.println("=========================");
// System.out.println("Select option : ");
// System.out.println("1. Withdraw");
// System.out.println("2. Deposit");
// System.out.println("3. Transfer");
// System.out.println("4. Check balance");
// System.out.println("5. Transaction History");
// System.out.println("6. Exit");
// System.out.print("Enter your choice : ");
// int choice=sc.nextInt();
// switch (choice) {
// case 1:
// transaction.withdraw();
// case 2:
// transaction.deposit();
// case 3:
// transaction.transfer();
// case 4:
// check.checkbalance();
// case 5:
// his.transactionhistory();
// case 6: {
// System.out.println("THANKS VISIT AGAIN!");
// System.exit(0);
// }
// }
// }
// public static void main(String[] args) {
// homepage();
// }
// }