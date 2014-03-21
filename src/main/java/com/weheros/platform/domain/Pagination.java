/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.domain;

/**
 * @ClassName: Pagination
 * @Description: paginate many results.
 * @author Administrator
 * @date 2013年11月20日 下午2:47:13
 */
public class Pagination {
    private Integer total;
    private Integer start;
    private Integer limit;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
