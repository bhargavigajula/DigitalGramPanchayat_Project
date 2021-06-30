package com.dto;

public class Schemes {
    private String schemeName;
    private String description;
    private String imageFileName;
    public Schemes() {
    	
    }
	public Schemes(String schemeName, String description, String imageFileName) {
		super();
		this.schemeName = schemeName;
		this.description = description;
		this.imageFileName = imageFileName;
	}
	public Schemes(String schemeName, String description) {
		super();
		this.schemeName = schemeName;
		this.description = description;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	@Override
	public String toString() {
		return "Schemes [schemeName=" + schemeName + ", description=" + description + ", imageFileName=" + imageFileName
				+ "]";
	}
    
}
