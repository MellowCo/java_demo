package bank;

import java.util.Vector;

public class Bank {
    public static void main(String[] args) {
        Account person1 = new Account("P10001", "周星驰", 1000);
        Account person2 = new Account("P10002", "周润发", 2000);
        Account person3 = new Account("P10003", "成龙 ", 2500);
        Account person4 = new Account("P10004", "李连杰", 1800);
        Account person5 = new Account("P10005", "甄子丹", 1500);

        Vector<Account> ve = new Vector<>();
        ve.add(person1);
        ve.add(person2);
        ve.add(person3);
        ve.add(person4);
        ve.add(person5);

        for (Account account : ve) {
            System.out.println(account);
        }
    }

}

class Account{
    private String accountID;
    private String userName;
    private double deposit;

    public Account(String accountID, String userName, double deposit) {
        this.accountID = accountID;
        this.userName = userName;
        this.deposit = deposit;
    }

    double getDeposit(){
        return deposit;
    }

    void setDeposit(double deposit){
        this.deposit = deposit;
    }

    double withDraw(){
        return deposit * 1.05;
    }

    @Override
    public String toString() {
        return "用户:" + userName +"\t存款本金:" + deposit + "\t到期取款总额:" + withDraw();
    }
}