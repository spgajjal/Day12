package com.capgemini.bankapp.repository.impl;

import java.util.HashSet;

import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;

public class BankAccountRepositoryImpl implements BankAccountRepository {

	private HashSet<BankAccount> bankAccounts;

	public BankAccountRepositoryImpl() {
		super();
		bankAccounts = new HashSet<>();
		bankAccounts.add(new BankAccount(1234, "John Doe", "SAVING", 34000));
		bankAccounts.add(new BankAccount(2373, "Jane Doe", "SAVING", 56000));
		bankAccounts.add(new BankAccount(3990, "Alex Browning", "CURRENT", 89000));
	}

	@Override
	public double getBalance(long accountId) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId() == accountId)
				return bankAccount.getAccountBalance();
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId() == accountId) {
				bankAccount.setAccountBalance(newBalance);
				return true;
			}
		}
		return false;
	}

}