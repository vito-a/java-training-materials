package org.caranus.jmp.dto;

// DebitBankCard class
public class DebitBankCard extends BankCard
{
	public DebitBankCard(String number, User user)
	{
		super(number, user);
	}

	@Override
	public String toString()
	{
		return "DebitBankCard{" +
			  "number='" + number + '\'' +
			  ", user=" + user +
			  '}';
	}
}
