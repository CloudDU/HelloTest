package com.test.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ducheng on 2017-11-14.
 */
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date creationDate;
    private Date lastChangedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastChangedDate() {
        return lastChangedDate;
    }

    public void setLastChangedDate(Date lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }

}