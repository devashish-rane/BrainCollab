package com.deva.braincollab.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Power {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long power_id;
	private String name;
}
