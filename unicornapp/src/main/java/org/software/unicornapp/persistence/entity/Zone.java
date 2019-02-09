package org.software.unicornapp.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ZONE")
@Getter
@Setter
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "longtitude")
	private String longtitude;

	@Column(name = "latitude")
	private String latitude;

	@JsonBackReference
	@OneToMany(mappedBy = "zoneId", targetEntity = Unicorn.class)
	private List<Unicorn> unicornList;

}
