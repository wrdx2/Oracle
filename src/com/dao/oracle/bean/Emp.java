package com.dao.oracle.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal empno;
	private String ename;
	private String job;
	private BigDecimal mgr;
	private Timestamp hiredate;
	private BigDecimal sal;
	private BigDecimal comm;
	private BigDecimal deptno;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(String ename, String job, BigDecimal mgr, BigDecimal sal,
			BigDecimal comm) {
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
	}

	/** full constructor */
	public Emp(String ename, String job, BigDecimal mgr, Timestamp hiredate,
			BigDecimal sal, BigDecimal comm, BigDecimal deptno) {
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	// Property accessors

	public BigDecimal getEmpno() {
		return this.empno;
	}

	public void setEmpno(BigDecimal empno) {
		this.empno = empno;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public BigDecimal getMgr() {
		return this.mgr;
	}

	public void setMgr(BigDecimal mgr) {
		this.mgr = mgr;
	}

	public Timestamp getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public BigDecimal getComm() {
		return this.comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public BigDecimal getDeptno() {
		return this.deptno;
	}

	public void setDeptno(BigDecimal deptno) {
		this.deptno = deptno;
	}

}