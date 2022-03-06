package com.rakbank.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(generator = "CustomUUIDGenerator")
	@GenericGenerator(name = "CustomUUIDGenerator", strategy = "com.rakbank.ems.config.UUIDGenerator")
	@Column(name="uuid",unique=true, nullable=false)
	private String uuId;
	
	@Column(name="is_active",nullable=false)
	private Boolean isActive ;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on",nullable=false)
	private Date createdOn ;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_on",nullable=false)
	private Date lastUpdatedOn ;
	
}


