package org.caranus.jmp.dto;

// CreditBankCard class
public class CreditBankCard extends BankCard {
    public CreditBankCard(String number, User user)
    {
        super(number, user);
    }

    @Override
    public String toString() {
        return "CreditBankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
