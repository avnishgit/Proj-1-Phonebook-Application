package com.ag.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * This  class hold b.logic data
* @version 1.1
 * @author AVNISH SINGH
 *
 */
@Entity
@Table(name = "contect_details")
@Data
public class ContactDetailsEntity {

	@Id
	@GeneratedValue
	private Integer pid;
	private String name;
	private String email;
	private Long mobNo ;
	private String activeSc;
	
	
	
}
