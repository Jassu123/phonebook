/**
 * 
 */
package com.contacts.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.contacts.constants.ApplicationConstants;
import com.contacts.entity.Contact;
import com.contacts.properties.AppProperties;
import com.contacts.service.ContactService;

/**
 * @author siva
 *
 */
@Controller
public class ContactController {

	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	@Autowired
	private ContactService contactService;
	@Autowired
	private AppProperties appProperties;

	@GetMapping("/loadForm")
	public String loadForm(Model model) {

		logger.debug("***************LoadForm() execution started ***************");

		model.addAttribute("contact", new Contact());

		logger.debug("***************LoadForm() execution completed ***************");

		logger.info("**************loadForm() executed successfully************");

		return ApplicationConstants.VIEW_INDEX;
	}

	@PostMapping("/saveContact")
	public String handleSaveContactBtn(Contact contact, Model model, RedirectAttributes redirectAttribues) {
		logger.debug("***************handleSaveContactBtn() execution started ***************");

		String txtMsg = null;

		Map<String, String> messages = appProperties.getMessages();

		if (contact.getContactId() == null) {
			txtMsg = messages.get(ApplicationConstants.SAVE_SUCCESS);
		} else {
			txtMsg = messages.get(ApplicationConstants.UPDATE_SUCCESS);
		}

		boolean isSaved = contactService.saveContact(contact);

		if (isSaved) {

			redirectAttribues.addFlashAttribute("successMsg", txtMsg);
			logger.info("**************SaveContact executed successfully************");

		} else {
			redirectAttribues.addFlashAttribute("errorMsg", messages.get(ApplicationConstants.SAVE_FAIL));
			logger.info("**************SaveConatact execution failed************");
		}
		return "redirect:/loadForm";
	}

	@GetMapping("/viewContacts")
	public String handleViewContactsHyperlink(Model model) {
		logger.debug("***************View Contacts execution started ***************");
		List<Contact> contactsList = contactService.getAllContacts();

		if (contactsList.isEmpty()) {
			logger.info("****Conatacts are not available in DB************");
		}
		model.addAttribute("contacts", contactsList);

		logger.debug("***************View Contacts execution ended ***************");
		logger.info("**************Vew contacts execution successfully completed ************");
		return "viewContacts";
	}

	@GetMapping("/editContact")
	public String handleEditHyperLink(@RequestParam("contactId") int cid, Model model) {

		logger.debug("***************edit Contacts execution started ***************");
		Contact conatctObj = contactService.getContactById(cid);

		model.addAttribute("contact", conatctObj);
		logger.debug("***************edit Contacts execution ended ***************");
		logger.info("**************Edit contacts execution successfully completed ************");
		return ApplicationConstants.VIEW_INDEX;

	}

	@GetMapping("/deleteContact")
	public String handleDeleteHyperLink(@RequestParam("contactId") Integer cid) {

		logger.debug("***************Delete Contacts execution started ***************");
		contactService.deleteContactById(cid);
		logger.debug("***************Delete Contacts execution Ended ***************");
		logger.info("**************Conatcts deleted successfully  ************");

		return "redirect:/viewContacts";

	}
}
