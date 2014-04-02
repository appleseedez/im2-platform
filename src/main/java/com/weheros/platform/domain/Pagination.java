/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.domain;

/**
 * @ClassName: Pagination
 * @Description: paginate many results.
 * @author Yang
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
