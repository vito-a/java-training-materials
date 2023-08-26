package org.caranus.jmp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.caranus.jmp.dao.BankDao;
import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.Subscription;
import org.caranus.jmp.dto.User;


/**
 * Hello world!
 *
 */
public class BankDaoImpl implements BankDao
{
    public List<User> users = new ArrayList<>();
    public List<BankCard> bankCards = new ArrayList<>();
    public List<Subscription> subscriptions = new ArrayList<>();
    @Override
    public boolean addUsers(final List<User> users)
    {
        this.users.addAll(users);
        return true;
    }

    @Override public List<User> getAllUsers()
    {
        return users;
    }

    @Override
    public boolean addBankCards(final List<BankCard> bankCards)
    {
        this.bankCards.addAll(bankCards);
        return true;
    }

    @Override public List<BankCard> getAllBankCards()
    {
        return bankCards;
    }

    @Override
    public boolean addSubscription(final Subscription subscription)
    {
        this.subscriptions.add(subscription);
        return true;
    }

    @Override
    public boolean addSubscriptions(final List<Subscription> subscriptions)
    {
        this.subscriptions.addAll(subscriptions);
        return true;
    }

    @Override public List<Subscription> getAllSubscriptions()
    {
        return subscriptions;
    }
}
