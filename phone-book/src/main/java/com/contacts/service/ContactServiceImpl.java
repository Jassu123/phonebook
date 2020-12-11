/**
 * 
 */
package com.contacts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepository;

/**
 * @author Siva Nadupuru
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository conactRepo;

	@Override
	public boolean saveContact(Contact contact) {

		contact.setActiveSw("Y");

		Contact savedObj = conactRepo.save(contact);
		return savedObj.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {

		return conactRepo.findByActiveSw("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = conactRepo.findById(contactId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		try {
			conactRepo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		try {
			Contact contact = conactRepo.findById(contactId).get();
			contact.setActiveSw("N");
			conactRepo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
