package com.test.test;

import java.io.Serializable;

/**
 * Created by ducheng on 2017-11-14.
 */
public class CIBase extends BaseModel implements Serializable {

    private Integer ciEventId;

    private Integer ciEventType;    //1:git

    public Integer getCiEventId() {
        return ciEventId;
    }

    public void setCiEventId(Integer ciEventId) {
        this.ciEventId = ciEventId;
    }

    public Integer getCiEventType() {
        return ciEventType;
    }

    public void setCiEventType(Integer ciEventType) {
        this.ciEventType = ciEventType;
    }

    @Override
    public String toString() {
        return "CIBase{" +
                "ciEventId=" + ciEventId +
                ", ciEventType=" + ciEventType +
                '}';
    }
}
