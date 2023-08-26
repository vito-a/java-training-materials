package org.caranus.jmp.service.api;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.caranus.jmp.dto.BankCard;
import org.caranus.jmp.dto.Subscription;
import org.caranus.jmp.dto.User;


public interface Service
{
	boolean addBankCards(List<BankCard> bankCards);

	void subscribe(BankCard bankCard);

	Subscription getSubscriptionByBankCardNumber(String bankCardNumber);

	boolean addUsers(List<User> users);

	List<User> getAllUsers();

	default double getAverageUserAge()
	{
		List<User> users = getAllUsers();
		return users.stream().mapToLong(user -> {
			var now = LocalDate.now();
			return ChronoUnit.YEARS.between(user.getBirthday(), now);
		}).average().orElse(0);
	}

	static boolean isPayable(User user)
	{
		var now = LocalDate.now();
		var birthday = user.getBirthday();
		return ChronoUnit.YEARS.between(birthday, now) > 18;
	}

	List<Subscription> getAllSubscriptionByCondition(Predicate<Subscription> predicate);
}
