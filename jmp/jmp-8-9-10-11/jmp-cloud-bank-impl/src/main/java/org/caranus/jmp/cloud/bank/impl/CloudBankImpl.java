package org.caranus.jmp.cloud.bank.impl;

import java.util.Random;

import org.caranus.jmp.bank.api.Bank;
import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.BankCardType;
import org.caranus.jmp.dto.CreditBankCard;
import org.caranus.jmp.dto.DebitBankCard;
import org.caranus.jmp.dto.User;

public class CloudBankImpl implements Bank
{
	@Override
	public BankCard createBankCard(final User user, final BankCardType bankCardType)
	{
		BankCard bankCard;
		var cardNumber = generateRandomCardNumber();

		switch (bankCardType)
		{
			case DEBIT:
				bankCard = new DebitBankCard(cardNumber, user);
				break;
			case CREDIT:
				bankCard = new CreditBankCard(cardNumber, user);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + bankCardType);
		}
		return bankCard;
	}

	private String generateRandomCardNumber()
	{
		int leftLimit = 48; // letter '0'
		int rightLimit = 57; // letter '9'
		int targetStringLength = 16;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1)
			  .limit(targetStringLength)
			  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			  .toString();
	}
}
