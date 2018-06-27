package com.du.util.reflection;

import java.util.Date;

/**
 * @author XP_IS_BUG
 * @date 2018/6/27
 */
public class PersonObj extends BaseModel{
	private Long userId;
	private String userName;
	private Long userNum;
	private Integer userAge;
	private Date userBirth;
	private Integer userWorkYear;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserNum() {
		return userNum;
	}

	public void setUserNum(Long userNum) {
		this.userNum = userNum;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public Integer getUserWorkYear() {
		return userWorkYear;
	}

	public void setUserWorkYear(Integer userWorkYear) {
		this.userWorkYear = userWorkYear;
	}
}
