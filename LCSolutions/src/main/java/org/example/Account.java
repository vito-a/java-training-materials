package org.example;

public class Account {
    Integer accountNumber;
    Long transactions[];
    Long totalBalance;

    public Long deposit(Long amount) { /* ... */ return totalBalance; };
    public Long withdraw(Long amount) { /* ... */ return totalBalance; };
    public Long transfer(Account toAccount, Long amount) { /* ... */ return totalBalance; };
    public Integer getAccountNumber() { return accountNumber; };
}
