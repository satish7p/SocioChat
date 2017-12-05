package com.sociochat.sociochatbackend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JobDetial")
public class Job {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
private String jobId;
private String jobprofile;
private String jobdate;
private String qualification;
private String status;
private String postdate;
/*
* getter setter method
*/

public String getJobId() {
return jobId;
}

public void setJobId(String jobId) {
this.jobId = jobId;
}

public String getJobprofile() {
return jobprofile;
}

public void setJobprofile(String jobprofile) {
this.jobprofile = jobprofile;
}

public String getJobdate() {
return jobdate;
}

public void setJobdate(String jobdate) {
this.jobdate = jobdate;
}

public String getQualification() {
return qualification;
}

public void setQualification(String qualification) {
this.qualification = qualification;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getPostdate() {
return postdate;
}

public void setPostdate(String postdate) {
this.postdate = postdate;
}

}

