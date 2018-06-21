package com.test.test;

import java.io.Serializable;

/**
 * Created by ducheng on 2017-11-14.
 */
public class CIAutomatedTest extends BaseModel implements Serializable {

    private Integer projectId;

    private Integer deployId;

    private Integer ciBaseId;

    private String testResultUrl;

    private String testResultInfo;

    private Integer isDelete;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getDeployId() {
        return deployId;
    }

    public void setDeployId(Integer deployId) {
        this.deployId = deployId;
    }

    public Integer getCiBaseId() {
        return ciBaseId;
    }

    public void setCiBaseId(Integer ciBaseId) {
        this.ciBaseId = ciBaseId;
    }

    public String getTestResultUrl() {
        return testResultUrl;
    }

    public void setTestResultUrl(String testResultUrl) {
        this.testResultUrl = testResultUrl;
    }

    public String getTestResultInfo() {
        return testResultInfo;
    }

    public void setTestResultInfo(String testResultInfo) {
        this.testResultInfo = testResultInfo;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CIAutomatedTest{" +
                "projectId=" + projectId +
                ", deployId=" + deployId +
                ", ciBaseId=" + ciBaseId +
                ", testResultUrl='" + testResultUrl + '\'' +
                ", testResultInfo='" + testResultInfo + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
