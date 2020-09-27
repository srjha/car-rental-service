package com.assignment.car.rental.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {
	private static final long serialVersionUID = 2370892890655450122L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@CreatedDate
	protected ZonedDateTime createdAt;

	@CreatedDate
	protected ZonedDateTime lastUpdatedAt;

	public Long getId() {
		return id;
	}

}
