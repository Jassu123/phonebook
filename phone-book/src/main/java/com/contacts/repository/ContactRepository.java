/**
 * 
 */
package com.contacts.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.entity.Contact;

/**
 * @author Siva Nadupuru
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	
	public List<Contact> findByActiveSw(String activeSw);

}
