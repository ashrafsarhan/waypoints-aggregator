/**********************************************************************
 *  Copyright (c) 2017, Springworks, All right reserved.
 *  
 **********************************************************************/
package com.springworks.models;

import java.time.LocalDateTime;

/**
 * The Class BasicEvent.
 *
 * @author Ashraf Sarhan <ashraf.sar7an@gmail.com>
 */
public class BasicEvent {
	
	protected String timestamp;
	
	private boolean isEnd;
	
	public BasicEvent(boolean isEnd) {
		super();
		this.isEnd = isEnd;
		this.timestamp = LocalDateTime.now().toString();
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
