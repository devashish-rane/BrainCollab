package com.deva.braincollab.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Data
@Entity
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	 private Long userId;
	 
	 @Column(unique = true)
	 private String name;
	 
	 @Column
	 private String password;
	 
	 @Column
	 private String role;
//	 private List<Power> edge;
	 
}
