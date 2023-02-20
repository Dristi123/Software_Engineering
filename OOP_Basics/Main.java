package com.company;
import java.util.Scanner;

class User {
    private String holder_name;
    private int initial_deposite;
    private String account_type;
    private int loanflag;
    private int loanamount;
    private int loantobeapproved;
    private Savingsaccount s=new Savingsaccount();
    private Studentsaccount st=new Studentsaccount();
    private Fixeddepositeaccount fd=new Fixeddepositeaccount();
    private int age_of_account;
    private int loanasked;
    public User(int deposite, String name,String type) {
        holder_name=name;
        initial_deposite=deposite;
        account_type=type;
        age_of_account=0;
        loanflag=0;
        loanamount=0;
        loanasked=0;
        loantobeapproved=0;
        System.out.println(type+" account for "+name+" Created; initial balance "+deposite+"$");
    }
    public void depositemoney(int amount) {
        if(account_type.equals("Savings")){
            initial_deposite=initial_deposite+s.deposite(amount);
        }
        else if(account_type.equals("Student")){
            initial_deposite=initial_deposite+st.deposite(amount);
        }
        else {
            int temp=fd.deposite(amount);
            initial_deposite=initial_deposite+temp;
            if(temp==0) return;

        }
        System.out.println(amount+"$ deposited. Current balance "+initial_deposite+"$");
    }
    public void withdrawmoney(int amount) {
        if(amount>initial_deposite) {
            System.out.println("amount is not present in the account");
            return;
        }
        if(account_type.equals("Savings")){
            initial_deposite=s.withdraw(initial_deposite,amount);
        }
        else if(account_type.equals("Student")){
            initial_deposite=st.withdraw(initial_deposite,amount);
        }
        else {
            if(age_of_account>=1)
                initial_deposite=fd.withdraw(initial_deposite,amount);
            else System.out.println("Account is not enough mature");
        }
    }
    public void requestloan(int amount) {
        boolean flag;
        if(account_type.equals("Savings")){
            flag=s.isloanvalid(amount);
        }
        else if(account_type.equals("Student")){
            flag=st.isloanvalid(amount);
        }
        else {
            flag=fd.isloanvalid(amount);
        }
        if(flag==true){
            System.out.println("Loan Request Successful.Sent for approval");
            loanflag=1;
            loanamount=loanamount+amount;
            loantobeapproved=loantobeapproved+amount;
        }
        else System.out.println("Loan amount not permissible");
    }
    public void approveloan() {
        loanasked=1;
        initial_deposite=initial_deposite+loantobeapproved;
        loanflag=0;
        loantobeapproved=0;
    }
    public void incyear() {
        age_of_account=age_of_account+1;
        if(account_type.equals("Savings")){
            //System.out.println(s.intrate);
            initial_deposite=initial_deposite+s.calculateinterest(initial_deposite)-(int)(0.1*loanamount);
        }
        else if(account_type.equals("Student")){
            initial_deposite=initial_deposite+st.calculateinterest(initial_deposite)-(int)(0.1*loanamount);
        }
        else {
            initial_deposite=initial_deposite+fd.calculateinterest(initial_deposite)-(int)(0.1*loanamount);
        }

    }

    public int getLoantobeapproved() {
        return loantobeapproved;
    }

    public String getHolder_name() {
        return holder_name;
    }

    public int getInitial_deposite() {
        return initial_deposite;
    }

    public int getLoanflag() {
        return loanflag;
    }

    public int getLoanamount() {
        return loanamount;
    }
    public int getLoanasked() {
        return loanasked;
    }
}


abstract class Account {
       int  deposite(int amount) {
            return amount;
       }
       abstract int withdraw(int deposite,int amount);
       abstract boolean isloanvalid(int amount);
       abstract int calculateinterest(int deposite);

}


class Savingsaccount extends Account{
        static double intrate=0.1;
        public int withdraw(int deposite,int amount) {
            int temp=deposite-amount;
            if(temp<1000) {
                System.out.println("Invalid transaction; current balance "+deposite+"$");
                return deposite;
            }
            else {
                System.out.println("Transaction Successful; current balance "+temp+"$");
                return temp;
            }
        }
        public boolean isloanvalid(int amount) {
            if(amount<10000) return true;
            else return false;
        }
        public int calculateinterest(int deposite) {
            int temp=(int)((deposite*intrate)-500);
            return temp;
        }
}


class Studentsaccount extends Account{
    static double intrate=0.05;
    public int withdraw(int deposite,int amount){
        if(amount>10000) {
            System.out.println("Invalid transaction; current balance "+deposite+"$");
            return deposite;
        }
        else  {
            System.out.println("Transaction Successful; current balance "+(deposite-amount)+"$");
            return deposite-amount;
        }
    }
    public boolean isloanvalid(int amount) {
        if(amount<1000) return true;
        else return false;
    }
    public int calculateinterest(int deposite) {
        int temp=(int)(deposite*intrate);
        return temp;
    }
}


class Fixeddepositeaccount extends Account{
    static double intrate=0.15;
    public int  deposite(int amount) {
        if(amount<50000) {
            System.out.println("amount less than required");
            return 0;
        }
        else return amount;
    }
    public int withdraw(int deposite,int amount) {
        System.out.println("Transaction Successful; current balance "+(deposite-amount)+"$");
        return deposite-amount;
    }
    public boolean isloanvalid(int amount) {
        if(amount<100000) return true;
        else return false;
    }
    public int calculateinterest(int deposite) {
        int temp=(int)((deposite*intrate)-500);
        return temp;
    }
}


abstract class Employee {
    private int totalloanamount = 0;
    void lookup(User[] arr, int length, String name) {
        for (int i = 0; i < length; i++) {
            if (arr[i].getHolder_name().equals(name)) {
                System.out.println(name + "'s Current balance is:" + arr[i].getInitial_deposite()+"$");
            }
        }
    }

    void approveloan(User[] arr, int length) {
        for (int i = 0; i < length; i++) {
            if (arr[i].getLoanflag() == 1) {
                totalloanamount = totalloanamount + arr[i].getLoantobeapproved();
                arr[i].approveloan();
                System.out.println("Loan for " + arr[i].getHolder_name() + " approved");
            }
        }
    }
    public int getTotalloanamount() {
        return totalloanamount;
    }
    abstract void changeintrate(User[] arr, String type, double rate);
}


class MD extends Employee {
    public void changeintrate(User[] arr,String type,double rate) {
        if(type.equals("Student")) {
            Studentsaccount.intrate=rate/100;
        }
      else if(type.equals("Savings"))  {
            Savingsaccount.intrate=rate/100;
        }
      else {
            Fixeddepositeaccount.intrate=rate/100;
        }
        System.out.println("Interest Rate Changed");
    }
}


class Officer extends Employee{
    public void changeintrate(User[] arr, String type, double rate) {
        System.out.println("You don't have permission for this");
    }
}


class Cashier extends Employee {
    public void approveloan(User[] arr,int length) {
        System.out.println("You dont have permission for this operation");
    }
    public void changeintrate(User[] arr, String type, double rate) {
        System.out.println("You don't have permission for this");
    }
}


class Bank {
    private int fund;
    private MD md;
    private Officer[] officers;
    private Cashier[] cashiers;
    private User[] users;
    private int clock;
    private int noofusers;
    public Bank() {
        fund=1000000;
        officers=new Officer[2];
        cashiers=new Cashier[5];
        users=new User[1000];
        clock=0;
        noofusers=0;
        md=new MD();
    }
    public void createuser(int deposite, String name, String type) {
        if (type.equals("Fixeddeposite") && deposite < 100000) System.out.println("Initial deposite not enough");
        else {
            users[noofusers] = new User(deposite, name, type);
            noofusers = noofusers + 1;
        }
    }
    public int search(String name) {
        for(int i=0;i<noofusers;i++) {
            if(users[i].getHolder_name().equals(name)) return i;
        }
        return -1;
    }
    public void depositemoney(String name,int amount) {
        int temp=search(name);
        users[temp].depositemoney(amount);
    }
    public void withdrawmoney(String name,int amount) {
        int temp=search(name);
        users[temp].withdrawmoney(amount);
    }
    public void requestloan(String name,int amount) {
        int temp=search(name);
        users[temp].requestloan(amount);
    }
    public void increaseyear() {
        clock=clock+1;
        for(int i=0;i<noofusers;i++) {
            users[i].incyear();
        }
        System.out.println("One year passed");
    }
    public void moneyquery(String name) {
        int temp=search(name);
        if(users[temp].getLoanasked()==1)System.out.println("Current balance "+users[temp].getInitial_deposite()+"$,loan "+users[temp].getLoanamount()+"$");
        else System.out.println("Current balance "+users[temp].getInitial_deposite()+"$");
    }
    public void createemployee(String type,int number) {
        int loanpend=0;
        for(int i=0;i<noofusers;i++) {
            if(users[i].getLoanflag()==1) {
                loanpend=1;
                break;
            }
        }
        if(type.charAt(0)=='O') {
            officers[number-1]=new Officer();
            System.out.print("O"+number+" active.");
            if(loanpend==1) System.out.println("there are loan approvals pending");
            else System.out.println(" ");

        }
        else if(type.charAt(0)=='C') {
            cashiers[number-1]=new Cashier();
            System.out.println("C"+number+" active");
        }
        else {
            System.out.print("MD active.");
            if(loanpend==1) System.out.println("there are loan approvals pending");
            else System.out.println(" ");
        }

    }
    public void approveloan(String type,int num) {
        int loanpend = 0;
        int loanpending=0;
        for (int i = 0; i < noofusers; i++) {
            if (users[i].getLoanflag() == 1) {
                loanpend = 1;
                break;
            }
        }
        if (loanpend == 1) {
            if (type.charAt(0) == 'O') {
                officers[num - 1].approveloan(users, noofusers);
                loanpending=officers[num-1].getTotalloanamount();
            } else if (type.charAt(0) == 'C') {
                cashiers[num - 1].approveloan(users, noofusers);
                loanpending=cashiers[num-1].getTotalloanamount();
            } else {
                md.approveloan(users, noofusers);
                loanpending=md.getTotalloanamount();
            }
            decreasefund(loanpending);

        } else {
            System.out.println("No pending loan");
        }
    }
    public void changerate(String type,int num,String accounttype,double rate) {
        if(type.charAt(0)=='O') {
            officers[num-1].changeintrate(users,accounttype,rate);
        }
        else if(type.charAt(0)=='C') {
            cashiers[num-1].changeintrate(users,accounttype,rate);
        }
        else md.changeintrate(users,accounttype,rate);
    }
    public void lookup(String type,int num,String name) {
        if(search(name)==-1) System.out.println("No user of the given name");
        else{
            if(type.charAt(0)=='O') {
                officers[num-1].lookup(users,noofusers,name);
            }
            else if(type.charAt(0)=='C') {
                cashiers[num-1].lookup(users,noofusers,name);
            }
            else md.lookup(users,noofusers,name);
        }
    }
    public void seefund(String type) {
        if(type.equals("MD")) {
            System.out.println("Bank's fund "+getfund()+"$");
        }
        else System.out.println("You dont have permission for this operation.");
    }
    public void decreasefund(int amount) {
        int temp=fund-amount;
        if(temp<0) System.out.println("Asked amount not available");
        else fund=temp;
    }
    public void increasefund(int amount) {
        fund=fund+amount;
    }
    public int getfund() {
        return fund;
    }
}


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Bank Created; MD; O1; O2;C1;C2;C3;C4;C5 created");
        System.out.println("Type 'Exit' to exit the system");
        String tempname = "";
        String userflag = "";
        int tempnum = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] splited = input.split(" ");
            if (splited[0].equals("Create")) {
                tempname = splited[1];
                userflag = "user";
                bank.createuser(Integer.parseInt(splited[3]), splited[1], splited[2]);

            }
                if (splited[0].equals("Deposite")) {
                    if(userflag.equals("user"))
                    bank.depositemoney(tempname, Integer.parseInt(splited[1]));
                    else System.out.println("Create an account or open your existing account for this transaction");
                }
                if (splited[0].equals("Withdraw")) {
                    if(userflag.equals("user"))
                    bank.withdrawmoney(tempname, Integer.parseInt(splited[1]));
                    else System.out.println("Create an account or open your existing account for this transaction");
                }
                if (splited[0].equals("Request")) {
                    if(userflag.equals("user"))
                    bank.requestloan(tempname, Integer.parseInt(splited[1]));
                    else System.out.println("Create an account or open your existing account for this transaction");
                }
                if (splited[0].equals("Query")) {
                    if(userflag.equals("user"))
                    bank.moneyquery(tempname);
                    else System.out.println("Create an account or open your existing account for this transaction");
                }
                if (splited[0].equals("Close")) {
                    if(userflag.equals("user"))
                    System.out.println("Transaction Closed for " + tempname);
                    else System.out.println("Operations for "+tempname+" closed");
                    tempname = "";
                }
            if (splited[0].equals("Open")) {
                tempname = splited[1];
                if (tempname.equals("O1") || tempname.equals("O2") || tempname.equals("C1") || tempname.equals("C2")
                        || tempname.equals("C3") || tempname.equals("C4") || tempname.equals("C5")) {
                    userflag = "employee";
                    tempnum = tempname.charAt(1) - '0';
                    bank.createemployee(tempname, tempnum);
                } else if (tempname.equals("MD")) {
                    bank.createemployee("MD", 1);
                    userflag = "employee";
                } else {
                    if (bank.search(tempname) == -1) System.out.println("No user of the given name");
                    else {
                        userflag = "user";
                        System.out.println("Welcome Back " + tempname);
                    }
                }
            }
                if (splited[0].equals("Approve")) {
                    if (userflag.equals("employee"))
                    bank.approveloan(tempname, tempnum);
                    else System.out.println("You are not an employee");
                }
                if (splited[0].equals("Change")) {
                    if (userflag.equals("employee"))
                    bank.changerate(tempname, tempnum, splited[1], Double.parseDouble(splited[2]));
                    else System.out.println("You are not an employee");
                }
                if (splited[0].equals("Lookup")) {
                    if (userflag.equals("employee"))
                    bank.lookup(tempname, tempnum, splited[1]);
                    else System.out.println("You are not an employee");
                }
                if (splited[0].equals("See")) {
                    if (userflag.equals("employee"))
                    bank.seefund(tempname);
                    else System.out.println("You are not an employee");
                }
                if (splited[0].equals("INC")) {
                    bank.increaseyear();
                }
                if(splited[0].equals("Exit")) System.exit(0);
        }
    }
}
