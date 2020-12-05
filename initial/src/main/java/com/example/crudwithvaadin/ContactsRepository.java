package com.example.crudwithvaadin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contact, Long> {

		List<Contact> findByLastNameStartsWithIgnoreCase(String lastName);
}
