package com.didispace.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: PageResultDto
 * @Description: 返回分页数据
 * @author syq
 * @date 2017年6月6日 下午2:06:51
 *
 */
public class PageResultDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageNum;// 当前页
	private int pages;// 总页数
	private int pageSize;// 每页显示条数
	private long total;// 总条数
	private List list;// 数据

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
