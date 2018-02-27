package pl.codewise.internships;

import java.time.Instant;


public class Message {

    private final String userAgent;
    private final int errorCode;
    
    private Instant receiveTime;

    public Message(String userAgent, int errorCode) 
    {
        this.userAgent = userAgent;
        this.errorCode = errorCode;
        this.receiveTime = Instant.now();
    }

    public String getUserAgent() 
    {
        return userAgent;
    }

    public int getErrorCode() 
    {
        return errorCode;
    }
    
    public Instant getReceiveTime()
    {
    	return receiveTime;
    }
    
}
