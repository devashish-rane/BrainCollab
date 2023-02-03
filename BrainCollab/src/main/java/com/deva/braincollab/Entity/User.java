package com.deva.braincollab.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Entity

public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	 @Column(name = "user_id")
	 private Long userId;
	 
	 @Column(unique = true)
	 private String name;
	 
	 @Column
	 private String password;
	 
	 @Column
	 private String role;
	 
	 @ToString.Exclude
	 @EqualsAndHashCode.Exclude
	 @JsonManagedReference
	 @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
	 private List<Blog> blogs = new ArrayList<Blog>();
	 
//	 private List<Power> edge;
	 
}
