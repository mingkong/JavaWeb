package com.web.master.component.test.butterfly.po;

import com.jenkov.db.itf.mapping.AClassMapping;
import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jenkov.db.itf.mapping.ASetterMapping;

@AClassMapping(tableName = "KDB_USER")
public class UserPO {
	private String userKey;
	private String userName;
	private String password;
	private String ownDepartmentKey;
	private String phone;
	private String mainQq;
	private String type;
	private String sex;
	private String idcard;
	private String birthDate;
	private Integer status;
	private String updateTime; 
	private String dflag;

	@AGetterMapping(columnName = "UUID_", databaseGenerated = false)
	public String getUserKey() {
		return userKey;
	}

	@ASetterMapping(columnName = "UUID_")
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	@AGetterMapping(columnName = "NAME_")
	public String getUserName() {
		return userName;
	}

	@ASetterMapping(columnName = "NAME_")
	public void setUserName(String userName) {
		this.userName = userName;
	}


	@AGetterMapping(columnName = "OWN_DEPT")
	public String getOwnDepartmentKey() {
		return ownDepartmentKey;
	}

	@ASetterMapping(columnName = "OWN_DEPT")
	public void setOwnDepartmentKey(String ownDepartmentKey) {
		this.ownDepartmentKey = ownDepartmentKey;
	}

	@AGetterMapping(columnName = "TYPE_")
	public String getType() {
		return type;
	}

	@ASetterMapping(columnName = "TYPE_")
	public void setType(String type) {
		this.type = type;
	}

	@AGetterMapping(columnName = "STATUS_")
	public Integer getStatus() {
		return status;
	}

	@ASetterMapping(columnName = "STATUS_")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@AGetterMapping(columnName = "PASSWORD_")
	public String getPassword() {
		return password;
	}

	@ASetterMapping(columnName = "PASSWORD_")
	public void setPassword(String password) {
		this.password = password;
	}

	@AGetterMapping(columnName = "PHONE_")
	public String getPhone() {
		return phone;
	}

	@ASetterMapping(columnName = "PHONE_")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@AGetterMapping(columnName = "MAIN_QQ")
	public String getMainQq() {
		return mainQq;
	}

	@ASetterMapping(columnName = "MAIN_QQ")
	public void setMainQq(String mainQq) {
		this.mainQq = mainQq;
	}

	@AGetterMapping(columnName = "SEX_")
	public String getSex() {
		return sex;
	}

	@ASetterMapping(columnName = "SEX_")
	public void setSex(String sex) {
		this.sex = sex;
	}

	@AGetterMapping(columnName = "IDCARD_")
	public String getIdcard() {
		return idcard;
	}

	@ASetterMapping(columnName = "IDCARD_")
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@AGetterMapping(columnName = "BIRTH_DATE")
	public String getBirthDate() {
		return birthDate;
	}

	@ASetterMapping(columnName = "BIRTH_DATE")
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@AGetterMapping(columnName = "UPDATE_TIME")
	public String getUpdateTime() {
		return updateTime;
	}

	@ASetterMapping(columnName = "UPDATE_TIME")
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@AGetterMapping(columnName = "DFLAG_")
	public String getDflag() {
		return dflag;
	}

	@ASetterMapping(columnName = "DFLAG_")
	public void setDflag(String dflag) {
		this.dflag = dflag;
	}
	
	
}
