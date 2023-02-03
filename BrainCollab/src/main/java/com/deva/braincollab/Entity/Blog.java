package com.deva.braincollab.Entity;

import java.sql.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String text;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonBackReference
	@ManyToOne
	private User author;
	
	@Column
	private Date creationDate;
	
	@Column
	private Date updatedDate;
	
}
