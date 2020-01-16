package com.ag.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ag.entity.ContactDetailsEntity;
/**
 * The class helps us to perform DB operations
* @version 1.1
 * @author AVNISH SINGH
 *
 */
@Repository
public interface ContactDetailRepository extends CrudRepository<ContactDetailsEntity, Integer>{
	@Transactional
	@Modifying
	@Query("update ContactDetailsEntity set activeSc=:sw WHERE pid = :cid")
	public void updateContactById( String sw,Integer cid);
}

