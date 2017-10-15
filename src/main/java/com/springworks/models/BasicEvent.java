/**
 * 
 */
package com.springworks.models;

/**
 * @author assar
 *
 */
public class BasicEvent {
	
	private String timestamp;
	
	private boolean isEnd;
	
	public BasicEvent(boolean isEnd) {
		super();
		this.isEnd = isEnd;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public boolean isEnd() {
		return isEnd;
	}

	@Override
	public String toString() {
		return "BasicEvent [timestamp=" + timestamp + ", isEnd=" + isEnd + "]";
	}

}
