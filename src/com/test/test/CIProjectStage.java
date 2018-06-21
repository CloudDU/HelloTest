package com.test.test;

import java.io.Serializable;

/**
 * Created by ducheng on 2017-11-14.
 */
public class CIProjectStage extends BaseModel implements Serializable {

    private Integer ciBaseId;

    private Integer projectId;

    private Integer stageObjectId;

    private String stageName;

    private Integer stageStatus;

    private Integer isDelete;

    public Integer getCiBaseId() {
        return ciBaseId;
    }

    public void setCiBaseId(Integer ciBaseId) {
        this.ciBaseId = ciBaseId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getStageObjectId() {
        return stageObjectId;
    }

    public void setStageObjectId(Integer stageObjectId) {
        this.stageObjectId = stageObjectId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Integer getStageStatus() {
        return stageStatus;
    }

    public void setStageStatus(Integer stageStatus) {
        this.stageStatus = stageStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CIProjectStage{" +
                "ciBaseId=" + ciBaseId +
                ", projectId=" + projectId +
                ", stageObjectId=" + stageObjectId +
                ", stageName='" + stageName + '\'' +
                ", stageStatus=" + stageStatus +
                ", isDelete=" + isDelete +
                '}';
    }
}
