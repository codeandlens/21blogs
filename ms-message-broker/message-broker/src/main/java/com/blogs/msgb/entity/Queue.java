/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="QUEUE")
@NamedQuery(name="Queue.findAll", query = "SELECT m FROM Queue m")
public class Queue extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false)
	private Integer queueId;
	
	@Column(name="MAINSERVICENAME", nullable=false)
	private String mainServiceName;
	
	@Column(name="EVENT", nullable=false)
	private String event;
	
	@Lob
	@Column(name = "DATA", nullable = false, length=1048576)
	private String data;
	
}
