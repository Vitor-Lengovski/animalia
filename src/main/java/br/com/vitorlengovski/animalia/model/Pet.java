package br.com.vitorlengovski.animalia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

@Entity
public class Pet {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private long clientId;
	private long raceId;
	private double weight;
	private String type;
	private char sex;

}
