package com.blogs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "StgStandardDetail")
@NamedQuery(name = "StgStandardDetail.findAll", query = "SELECT m FROM StgStandardDetail m")
public class StgStandardDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "DOCTOR_ID", nullable = false)
	private Integer doctorId;

	@Column(name = "START_TIME", nullable = false)
	private String startTime;

	@Column(name = "END_TIME", nullable = false)
	private String endTime;

	@Column(name = "YEAR", nullable = false)
	private String year;

	@Column(name = "GEN_DOC_OPR_FREE_PER_SLOT", nullable = true)
	private Integer genDocOprFreePerSlot;

	@Column(name = "GEN_DOC_OPR_MAX_PER_SLOT", nullable = true)
	private Integer genDocOprMaxPerSlot;

	@Column(name = "GEN_SKIN_FREE_PER_SLOT", nullable = true)
	private Integer genSkinFreePerSlot;

	@Column(name = "GEN_SKIN_MAX_PER_SLOT", nullable = true)
	private Integer genSkinMaxPerSlot;

	@Column(name = "GEN_SUR_FREE_PER_SLOT", nullable = true)
	private Integer genSurFreePerSlot;

	@Column(name = "GEN_SUR_MAX_PER_SLOT", nullable = true)
	private Integer genSurMaxPerSlot;

}
