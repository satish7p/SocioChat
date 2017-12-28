package com.sociochat.sociochatbackend.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JobDetail")
public class JobDetail {

	
@Id
private int jobId;
private String jobprofile;
private String jobdate;
private String qualification;
private String status;
private Date postdate;
/*
* getter setter method
*/

public int getJobId() {
return jobId;
}

public void setJobId(int jobId) {
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

public Date getPostdate() {
return postdate;
}

public void setPostdate(Date postdate) {
this.postdate = postdate;
}

}

