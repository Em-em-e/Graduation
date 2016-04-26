package com.endtcy.graduation.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Term entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Term  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

     private Long id;
     private String name;
     private Set courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Term() {
    }

	/** minimal constructor */
    public Term(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public Term(String name, Set courses) {
        this.name = name;
        this.courses = courses;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
   








}