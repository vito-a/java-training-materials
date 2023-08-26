package org.caranus.jmp.bank.api;

import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.BankCardType;
import org.caranus.jmp.dto.User;


public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
