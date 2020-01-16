package com.ag.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ag.domain.Contact;
import com.ag.service.ContactService;

/**
 * This class is used to edit and delete Record
 * @author AVNISH SINGH
 */
@Controller
public class ContactViewController {
	@Autowired
	ContactService contactService;

	/**
	 * This method is used to Edit Contact Details
	 * @param model
	 * @return String
	 */
	@GetMapping("/editContact")
	public String editContact(HttpServletRequest req, Model model, @ModelAttribute("contactFormBean") Contact contact) {
		Contact c = null;
		String pid = req.getParameter("cnctId");
		if (pid != null) {
			int cId = Integer.parseInt(pid);
			c = contactService.getContactById(cId);
			BeanUtils.copyProperties(c, contact);

		}
		model.addAttribute("contact", c);
		return "contact";

	}

	/**
	 * This method is used to delete the record
	 * @param req
	 * @return string
	 */
	@GetMapping("/delete")
	public String deleteContact(HttpServletRequest req) {
		String dcid = req.getParameter("cId");
		int cid = Integer.parseInt(dcid);

		contactService.deleteById(cid);

		return "redirect:viewAll";

	}

}
