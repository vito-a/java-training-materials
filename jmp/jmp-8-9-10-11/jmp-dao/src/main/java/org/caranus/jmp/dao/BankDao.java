package org.caranus.jmp.dao;

import java.util.ArrayList;
import java.util.List;

import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.Subscription;
import org.caranus.jmp.dto.User;


/**
 * Hello world!
 *
 */
public interface BankDao
{
	boolean addUsers(List<User> users);

	List<User> getAllUsers();

	boolean addBankCards(List<BankCard> bankCards);

	List<BankCard> getAllBankCards();

	boolean addSubscription(Subscription subscription);

	boolean addSubscriptions(List<Subscription> subscriptions);

	List<Subscription> getAllSubscriptions();
}
