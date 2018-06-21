package com.test.test;

import java.io.Serializable;

/**
 * Created by ducheng on 2017-11-14.
 */
public class CIGitEvent extends BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;

    private String gitUrl;

    private String gitBranch;

    private String gitEvent;

    private String gitVersion;

    private String gitUserName;

    private Integer status;

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getGitBranch() {
        return gitBranch;
    }

    public void setGitBranch(String gitBranch) {
        this.gitBranch = gitBranch;
    }

    public String getGitEvent() {
        return gitEvent;
    }

    public void setGitEvent(String gitEvent) {
        this.gitEvent = gitEvent;
    }

    public String getGitVersion() {
        return gitVersion;
    }

    public void setGitVersion(String gitVersion) {
        this.gitVersion = gitVersion;
    }

    public String getGitUserName() {
        return gitUserName;
    }

    public void setGitUserName(String gitUserName) {
        this.gitUserName = gitUserName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CIGitEvent{" +
                "gitUrl='" + gitUrl + '\'' +
                ", gitBranch='" + gitBranch + '\'' +
                ", gitEvent='" + gitEvent + '\'' +
                ", gitVersion='" + gitVersion + '\'' +
                ", gitUserName='" + gitUserName + '\'' +
                ", status=" + status +
                '}';
    }
}
