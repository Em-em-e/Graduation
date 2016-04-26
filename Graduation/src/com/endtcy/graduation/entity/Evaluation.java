package com.endtcy.graduation.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Evaluation entity. @author MyEclipse Persistence Tools
 */

public class Evaluation implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Studentwork studentwork;
	private Date commenttime;
	private String evaluation;
	private BigDecimal score;

	// Constructors

	/** default constructor */
	public Evaluation() {
	}

	/** full constructor */
	public Evaluation(Studentwork studentwork, Date commenttime,
			String evaluation, BigDecimal score) {
		this.studentwork = studentwork;
		this.commenttime = commenttime;
		this.evaluation = evaluation;
		this.score = score;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Studentwork getStudentwork() {
		return this.studentwork;
	}

	public void setStudentwork(Studentwork studentwork) {
		this.studentwork = studentwork;
	}

	public Date getCommenttime() {
		return this.commenttime;
	}

	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}