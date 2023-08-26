package org.caranus.jmp.dto;

// BankCard class
public class BankCard
{
	String number;
	User user;

	public BankCard(String number, User user)
	{
		this.number = number;
		this.user = user;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String toString()
	{
		return "BankCard{" +
			  "number='" + number + '\'' +
			  ", user=" + user +
			  '}';
	}
}
