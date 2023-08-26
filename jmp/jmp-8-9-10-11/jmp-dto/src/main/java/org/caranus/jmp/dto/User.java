package org.caranus.jmp.dto;

import java.time.LocalDate;


// User class
public class User
{

	Integer id;

	String name;

	String surname;

	LocalDate birthday;

	public User(Integer id, String name, String surname, LocalDate birthday)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public LocalDate getBirthday()
	{
		return birthday;
	}

	public void setBirthday(LocalDate birthday)
	{
		this.birthday = birthday;
	}

	@Override
	public String toString()
	{
		return "User{" +
			  "name='" + name + '\'' +
			  ", surname='" + surname + '\'' +
			  ", birthday=" + birthday +
			  '}';
	}
}
