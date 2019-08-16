package com.projectBoard.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.projectBoard.demo.model.common.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ProjectTask")
public class ProjectTask extends BaseEntity {

    @NotBlank(message = "summary cant be blank")
    @Column(name = "summary")
    @ApiModelProperty(notes = "Summary")
    private String summary;
    @Column(name = "acceptance_criteria")
    @ApiModelProperty(notes = "acceptance_criteria")
    private String acceptanceCriteria;
    @Column(name = "status")
    @ApiModelProperty(notes = "status")
    private String status;

    public ProjectTask() {
	super();
    }

    public ProjectTask(String summary, String acceptanceCriteria, String status) {
	super();
	this.summary = summary;
	this.acceptanceCriteria = acceptanceCriteria;
	this.status = status;
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	this.summary = summary;
    }

    public String getAcceptanceCriteria() {
	return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
	this.acceptanceCriteria = acceptanceCriteria;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((acceptanceCriteria == null) ? 0 : acceptanceCriteria.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((summary == null) ? 0 : summary.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ProjectTask other = (ProjectTask) obj;
	if (acceptanceCriteria == null) {
	    if (other.acceptanceCriteria != null)
		return false;
	} else if (!acceptanceCriteria.equals(other.acceptanceCriteria))
	    return false;
	if (status == null) {
	    if (other.status != null)
		return false;
	} else if (!status.equals(other.status))
	    return false;
	if (summary == null) {
	    if (other.summary != null)
		return false;
	} else if (!summary.equals(other.summary))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ProjectTask [summary=" + summary + ", acceptanceCriteria=" + acceptanceCriteria + ", status=" + status
		+ "]";
    }

}
