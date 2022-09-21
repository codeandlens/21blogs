package com.blogs.entity;

import java.util.Date;

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
@Table(name = "StgValidTimeTable")
@NamedQuery(name = "StgValidTimeTable.findAll", query = "SELECT m FROM StgValidTimeTable m")
public class StgValidTimeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "REFERENCE_CODE", nullable = false)
	private String referenceCode;

	@Column(name = "DOCTOR_ID", nullable = false)
	private Integer doctorId;

	@Column(name = "BRANCH_ID", nullable = false)
	private Integer branchId;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "START_TIME", nullable = false)
	private String startTime;

	@Column(name = "END_TIME", nullable = false)
	private String endTime;

	@Column(name = "TIME_GAP_REMAIN", nullable = false)
	private Integer timeGapRemain;

	@Column(name = "GEN_SUR_AVAILABLE_STATUS", nullable = false)
	private String genSurAvailableStatus;

	@Column(name = "GEN_SUR_FREE_PER_SLOT", nullable = false)
	private Integer genSurFreePerSlot;

	@Column(name = "GEN_SUR_MAX_PER_SLOT", nullable = false)
	private Integer genSurMaxPerSlot;

	@Column(name = "GEN_SKIN_AVAILABLE_STATUS", nullable = false)
	private String genSkinAvailableStatus;

	@Column(name = "GEN_SKIN_FREE_PER_SLOT", nullable = false)
	private Integer genSkinFreePerSlot;

	@Column(name = "GEN_SKIN_MAX_PER_SLOT", nullable = false)
	private Integer genSkinMaxPerSlot;

	@Column(name = "GEN_DOC_OPR_AVAILABLE_STATUS", nullable = false)
	private String genDocOprAvailableStatus;

	@Column(name = "GEN_DOC_OPR_FREE_PER_SLOT", nullable = false)
	private Integer genDocOprFreePerSlot;

	@Column(name = "GEN_DOC_OPR_MAX_PER_SLOT", nullable = false)
	private Integer genDocOprMaxPerSlot;

}
