package com.np.kd.model;

public class Response {
	boolean areAnagram;
	
	public Response(boolean areAnagram) {
		this.areAnagram = areAnagram;
	}

	public boolean getAreAnagram() {
		return areAnagram;
	}

	public void setAreAnagram(boolean areAnagram) {
		this.areAnagram = areAnagram;
	}
}
