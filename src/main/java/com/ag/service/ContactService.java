package com.ag.service;

import java.util.List;

import com.ag.domain.Contact;

public interface ContactService {
	public boolean saveContact(Contact c);
	public List<Contact> getAllContact();
	public boolean deleteById(Integer cid);
	public Contact getContactById(Integer cid);
}
