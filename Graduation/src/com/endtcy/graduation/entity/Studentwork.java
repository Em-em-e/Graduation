package com.endtcy.graduation.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Studentwork entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Studentwork  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
     private Student student;
     private Work work;
     private Date uploadtime;
     private String path;
     private String describe;
     private Set evaluations = new HashSet(0);


    // Constructors

    /** default constructor */
    public Studentwork() {
    }

    
    /** full constructor */
    public Studentwork(Student student, Work work, Date uploadtime, String path, Set evaluations) {
        this.student = student;
        this.work = work;
        this.uploadtime = uploadtime;
        this.path = path;
        this.evaluations = evaluations;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public Work getWork() {
        return this.work;
    }
    
    public void setWork(Work work) {
        this.work = work;
    }

    public Date getUploadtime() {
        return this.uploadtime;
    }
    
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public Set getEvaluations() {
        return this.evaluations;
    }
    
    public void setEvaluations(Set evaluations) {
        this.evaluations = evaluations;
    }


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}
    
    
   








}