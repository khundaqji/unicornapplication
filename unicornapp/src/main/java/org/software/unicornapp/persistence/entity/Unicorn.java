package org.software.unicornapp.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UNICORN")
@Getter
@Setter
public class Unicorn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "color")
	private String color;
	
	@ManyToOne(targetEntity = Zone.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "zone_id")
	private Zone zoneId;
}
