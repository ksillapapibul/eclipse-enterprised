package com.hellospringboot.hello.config;



import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "codecamp")
public class CodeCampConfig {

   private String language;
   private String student;

   public String getLanguage() {
       return this.language;
   }

   public String getStudent() {
       return this.student;
   }

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void setStudent(String student) {
		this.student = student;
	}

   
}

