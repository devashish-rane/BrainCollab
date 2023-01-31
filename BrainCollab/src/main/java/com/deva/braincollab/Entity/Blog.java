package com.deva.braincollab.Entity;

import java.sql.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String text;
	private List<User> writers;
	private Date creationDate;
	private Date updatedDate;
	
}
