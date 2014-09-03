package com.snks.mylection.model.json;


public class LectionJSON {
	
	
	public String lectionName;
	
	public long lectionCreationDate;
	
	public String lectionAuthor;
	
	public String lectionBody;
	
	
	
	public String getLectionName() {
		return lectionName;
	}




	public long getLectionCreationDate() {
		return lectionCreationDate;
	}




	public void setLectionCreationDate(long lectionCreationDate) {
		this.lectionCreationDate = lectionCreationDate;
	}




	public void setLectionName(String lectionName) {
		this.lectionName = lectionName;
	}




	public String getLectionAuthor() {
		return lectionAuthor;
	}

	public void setLectionAuthor(String lectionAuthor) {
		this.lectionAuthor = lectionAuthor;
	}

	public String getLectionBody() {
		return lectionBody;
	}

	public void setLectionBody(String lectionBody) {
		this.lectionBody = lectionBody;
	}

}
