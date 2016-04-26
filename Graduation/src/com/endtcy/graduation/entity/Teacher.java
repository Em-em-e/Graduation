package com.endtcy.graduation.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Teacher  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

     private Long id;
     private String name;
     private String username;
     private String password;
     private Set courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Teacher() {
    }

	/** minimal constructor */
    public Teacher(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    /** full constructor */
    public Teacher(String name, String username, String password, Set courses) {
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
   








}