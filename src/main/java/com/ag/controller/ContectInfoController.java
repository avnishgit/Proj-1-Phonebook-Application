package com.ag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ag.domain.Contact;
import com.ag.service.ContactService;
/**
 * The class helps listens to the user request
* @version 1.1
 * @author AVNISH SINGH
 *
 */
@Controller
public class ContectInfoController {

	@Autowired
	private ContactService contactService;

	/**
	 * This method display Contact form
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String displayContactForm(Model model ) {
		Contact c = new Contact();
		model.addAttribute("contactFormBean", c);

		return "contact";
	}

	/**
	 * This method is used to view All contact
	 * @param model
	 * @return String
	 */
	@GetMapping("/viewAll")
	public String viewContact(Model model) {
		
		List<Contact> lcontact = contactService.getAllContact();
		
			model.addAttribute("listcontact", lcontact);
		return "viewContact";
		
	}
	/**
	 * This method is used to save the record
	 * @param model
	 * @return String
	 */
	@PostMapping("/contactInfo")
	public String handleSubmitBtn(@ModelAttribute("contactFormBean") Contact c ,Model model ,RedirectAttributes attributes) {
		boolean flage = contactService.saveContact(c);
		if(flage) {
			
			attributes.addFlashAttribute("successMsg", "Recored Inserted Successfully");
		}
		else {
			attributes.addFlashAttribute("failMsg", "Recored Not Inserted ");
		}   
		return "redirect:/";
		
	}
}
