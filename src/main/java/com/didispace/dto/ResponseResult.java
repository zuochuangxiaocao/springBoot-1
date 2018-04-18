package com.didispace.dto;

public class ResponseResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String status = Status.SUCCESS.getCode();// 状态码

	private String message = Status.SUCCESS.getName();// 信息

	private Object data;// 数据

	public ResponseResult() {
	}

	public ResponseResult(Object data) {
		this.data = data;
	}

	public ResponseResult(ResultCode result) {
		this.status = result.getStatus();
		this.message = result.getMessage();
	}
	
	public ResponseResult(ResultCode result, Object data, String desc) {
        this.status = result.getStatus();
        this.message = result.getMessage()+"," + desc;
        this.data = data;
    }
	
	public ResponseResult(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	

	public enum Status {
		SUCCESS("success", "成功"), 
		FAILED("failed", "失败");

		private String code;
		private String name;

		Status(String code, String name) {
			this.code = code;
			this.name = name;
		}

		public String getCode() {
			return this.code;
		}

		public String getName() {
			return this.name;
		}
	}

}
