package org.caranus;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.caranus.jmp.bank.api.Bank;
import org.caranus.jmp.cloud.bank.impl.CloudBankImpl;
import org.caranus.jmp.cloud.service.exception.IllegalSubscriptionNumberException;
import org.caranus.jmp.cloud.service.impl.ServiceImpl;
import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.BankCardType;
import org.caranus.jmp.dto.CreditBankCard;
import org.caranus.jmp.dto.Subscription;
import org.caranus.jmp.dto.User;
import org.caranus.jmp.service.api.Service;


public class App
{

	public static void main(String[] args)
	{
		// create users
		var usersList = List.of(
			  new User(1, "Sami", "Wolking", LocalDate.of(1979, 5, 10)),
			  new User(2, "Nick", "Gore", LocalDate.of(1980, 4, 12)),
			  new User(3, "Sampsa", "Astala", LocalDate.of(1981, 10, 4)),
			  new User(4, "Leena", "Peisa", LocalDate.of(1981, 10, 4))
		);
		ServiceImpl.users.addAll(usersList);

		// Add bank cards
		Bank bank = new CloudBankImpl();
		var cardsList = List.of(
			  bank.createBankCard(usersList.get(0), BankCardType.DEBIT),
			  bank.createBankCard(usersList.get(1), BankCardType.CREDIT),
			  bank.createBankCard(usersList.get(2), BankCardType.DEBIT),
			  bank.createBankCard(usersList.get(3), BankCardType.CREDIT)
		);
		ServiceImpl.bankCards.addAll(cardsList);

		// Add subscriptions
		Service service = new ServiceImpl();
		for (BankCard bankCard : cardsList)
		{
			if (bankCard instanceof CreditBankCard)
			{
				service.subscribe(bankCard);
			}
		}

		// Retrieve subscriptions
		try
		{
			for (BankCard bankCard : cardsList)
			{
				if (bankCard instanceof CreditBankCard)
				{
					System.out.println(service.getSubscriptionByBankCardNumber(bankCard.getNumber()));
				}
			}
		}
		catch (IllegalSubscriptionNumberException e)
		{
			System.out.println(e.getMessage());
		}

		// Get all users
		List<User> unmodifiableUserList = service.getAllUsers().stream().collect(Collectors.toUnmodifiableList());
		unmodifiableUserList.forEach(System.out::println);

		// Get users average age
		double averageUserAge = service.getAverageUserAge();
		System.out.println(averageUserAge);

		// Get isPayable
		boolean payable = Service.isPayable(usersList.get(2));
		System.out.println(payable);

		// Get all subscription by condition
		Predicate<Subscription> predicateWithContainsCardNumber = getPredicateWithContainsCardNumber("3");

		List<Subscription> allSubscriptionByCondition = service.getAllSubscriptionByCondition(predicateWithContainsCardNumber);
		System.out.println(allSubscriptionByCondition);
	}

	private static Predicate<Subscription> getPredicateWithContainsCardNumber(String cardNumber)
	{
		return subscription -> subscription.getBankcard().contains(cardNumber);
	}
}