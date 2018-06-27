package com.du.util.reflection;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XP_IS_BUG
 * @date 2018/6/27
 */
public class BaseModel implements Serializable{
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 最后修改时间
	 */
	private Date lastChangedDate;
	/**
	 * 是否删除，1删除，0未删除
	 */
	private Integer isDelete;

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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
