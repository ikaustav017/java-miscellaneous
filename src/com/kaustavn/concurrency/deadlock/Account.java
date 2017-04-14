package com.kaustavn.concurrency.deadlock;

public class Account {

	private int id;
	private int balance;

	public Account(int id, int balance) {
		this.setId(id);
		this.setBalance(balance);

	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public static void transfer(Account from, Account to, int amount) {
		from.withdraw(amount);
		to.deposit(amount);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
