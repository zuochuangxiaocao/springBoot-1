package com.didispace.dto;

import java.io.Serializable;

public class Query
  implements Serializable
{
  private static final long serialVersionUID = -1446385552530670122L;
  private static final int DEFAULT_PAGE_NUM = 1;
  private static final int DEFAULT_PAGE_SIZE = 15;
  private String pageNum;
  private String pageSize;

  public String getPageNum()
  {
    return this.pageNum;
  }

  public void setPageNum(String pageNum) {
    this.pageNum = pageNum;
  }

  public String getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(String pageSize) {
    this.pageSize = pageSize;
  }

  public int getSafePageNum()
  {
    try {
      if ((this.pageNum == null) || ("".equalsIgnoreCase(this.pageNum))) {
        return 1;
      }
      return Integer.parseInt(this.pageNum.trim());
    } catch (Exception e) {
    }
    return 1;
  }

  public int getSafePageSize()
  {
    try
    {
      if ((this.pageSize == null) || ("".equalsIgnoreCase(this.pageSize))) {
        return 15;
      }
      return Integer.parseInt(this.pageSize.trim());
    } catch (Exception e) {
    }
    return 15;
  }

  public String toString()
  {
    return "Query [pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + "]";
  }
}