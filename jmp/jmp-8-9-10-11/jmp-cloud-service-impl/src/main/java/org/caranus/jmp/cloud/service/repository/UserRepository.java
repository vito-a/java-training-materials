package org.caranus.jmp.cloud.service.repository;

import org.caranus.jmp.dto.User;

public class UserRepository extends CrudRepository<User, Integer>
{
	@Override public User save(User entity)
	{
		return getTable().put(entity.getId(), entity);
	}
}
