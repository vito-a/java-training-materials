package org.caranus.jmp.cloud.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.caranus.jmp.cloud.service.exception.IllegalSubscriptionNumberException;
import org.caranus.jmp.dao.BankDao;
import org.caranus.jmp.dao.impl.BankDaoImpl;
import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.Subscription;
import org.caranus.jmp.dto.User;
import org.caranus.jmp.service.api.Service;


public class ServiceImpl implements Service
{
	BankDao bankDao;

	public ServiceImpl () {
		this.bankDao = new BankDaoImpl();
	}

	public ServiceImpl (BankDao bankDao) {
		this.bankDao = bankDao;
	}

	@Override
	public boolean addBankCards(final List<BankCard> bankCards)
	{
		return bankDao.addBankCards(bankCards);
	}

	@Override
	public void subscribe(BankCard bankCard)
	{
		Optional<BankCard> optionalBankCard = bankDao.getAllBankCards().parallelStream()
			  .filter(Objects::nonNull)
			  .filter(bc -> bc.getNumber().equals(bankCard.getNumber()))
			  .findFirst();
		if (optionalBankCard.isEmpty())
		{
			System.out.println("Bank card not found with " + bankCard.getNumber() + " number");
		}
		else
		{
			bankDao.addSubscription(new Subscription(bankCard.getNumber(), LocalDate.now()));
		}
	}

	@Override
	public Subscription getSubscriptionByBankCardNumber(String cardNumber)
	{
		return bankDao.getAllSubscriptions().parallelStream()
			  .filter(s -> s.getBankcard().equals(cardNumber))
			  .findFirst()
			  .orElseThrow(() -> new IllegalSubscriptionNumberException("With " + cardNumber + " card number subscription not found"));
	}

	@Override
	public boolean addUsers(final List<User> users)
	{
		return bankDao.addUsers(users);
	}

	@Override
	public List<User> getAllUsers()
	{
		return bankDao.getAllUsers();
	}

	@Override
	public List<Subscription> getAllSubscriptionByCondition(Predicate<Subscription> predicate)
	{
		return bankDao.getAllSubscriptions().stream().
			  filter(predicate).
			  collect(Collectors.toUnmodifiableList());
	}
}