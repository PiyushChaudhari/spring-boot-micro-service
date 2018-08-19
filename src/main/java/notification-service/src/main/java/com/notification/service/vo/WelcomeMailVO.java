package com.notification.service.vo;

public class WelcomeMailVO {

	private String to;
	private String name;
	private String signature;
	private String location;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WelcomeMailVO [to=");
		builder.append(to);
		builder.append(", name=");
		builder.append(name);
		builder.append(", signature=");
		builder.append(signature);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
