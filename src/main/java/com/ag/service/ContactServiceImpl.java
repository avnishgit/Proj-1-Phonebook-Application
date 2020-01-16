package com.ag.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.domain.Contact;
import com.ag.entity.ContactDetailsEntity;
import com.ag.repository.ContactDetailRepository;
import com.ag.util.EmailUtil;

/**
 * The class is use to perform b.logic operation
* @version 1.1
 * @author AVNISH SINGH
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDetailRepository cntctDtlRepo;
	
	@Autowired
	EmailUtil emailUtil;

	/**
	 * This method is used to save contact Details
	 * 
	 * @param c
	 * @return boolean
	 */
	@Override
	public boolean saveContact(Contact c) {

		ContactDetailsEntity entity = new ContactDetailsEntity();
		BeanUtils.copyProperties(c, entity);
		entity.setActiveSc("Y");
		entity = cntctDtlRepo.save(entity);
		
		  if(entity.getPid()>0)
			  sendEmailMsg(c.getEmail());
		 
		return entity.getPid() > 0;

	}

	/**
	 * This method Get all Contact Details
	 * @return list Contact
	 */
	@Override
	public List<Contact> getAllContact() {
		List<Contact> cList = new ArrayList<>();
		
		List<ContactDetailsEntity> listentity= (List<ContactDetailsEntity>) cntctDtlRepo.findAll();
		
		List<ContactDetailsEntity> filterlist = listentity.stream().filter(entity->
				entity.getActiveSc()=="Y")
				.collect(Collectors.toList());
		filterlist.forEach(entity->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			cList.add(contact);
		});
		
		return cList;

	}

	

	/**
	 * This method delete Recored
	 * 
	 * @param entity
	 * @return boolean
	 */
	@Override
	public boolean deleteById(Integer cid) {
		boolean flag=false;
		if(cid != null  && cid != 0){
		cntctDtlRepo.updateContactById("N", cid);
		flag=true;
		}
		return flag;
	}

	/**
	 * This method get contact Detail
	 * 
	 * @param cid
	 * @return contact
	 */
	@Override
	public Contact getContactById(Integer cid) {
		Contact c =null;
		Optional<ContactDetailsEntity> optional = cntctDtlRepo.findById(cid);
		if(optional.isPresent()) {
			ContactDetailsEntity entity = optional.get();
			 c =new Contact();
			BeanUtils.copyProperties(entity, c);
		}
		return c;

	}
	
	public void sendEmailMsg(String to) {
		
		emailUtil.sendEmail(to);
	}
	
	
}
