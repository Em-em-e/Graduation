package com.endtcy.graduation.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Work entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Work  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

     private Long id;
     private Course course;
     private String name;
     private String describe;
     private Date firsttime;
     private Date lasttime;
     private String attachment;
     private Set studentworks = new HashSet(0);


    // Constructors

    /** default constructor */
    public Work() {
    }

    
    /** full constructor */
    public Work(Course course, String name, String describe, Date firsttime, Date lasttime, String attachment, Set studentworks) {
        this.course = course;
        this.name = name;
        this.describe = describe;
        this.firsttime = firsttime;
        this.lasttime = lasttime;
        this.attachment = attachment;
        this.studentworks = studentworks;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return this.describe;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getFirsttime() {
        return this.firsttime;
    }
    
    public void setFirsttime(Date firsttime) {
        this.firsttime = firsttime;
    }

    public Date getLasttime() {
        return this.lasttime;
    }
    
    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getAttachment() {
        return this.attachment;
    }
    
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Set getStudentworks() {
        return this.studentworks;
    }
    
    public void setStudentworks(Set studentworks) {
        this.studentworks = studentworks;
    }
   








}