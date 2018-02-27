package pl.codewise.internships;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class Receiver implements MessageQueue
{
	LinkedList<Message> messageContainer = new LinkedList<Message>();

	public void add(Message message) 
	{
		if (!message.equals(null))
		{
			messageContainer.addFirst(message);
		}
		
	}

	public Snapshot snapshot() 
	{
		int counter = 0;
		Snapshot resultSnapshot = new Snapshot();
		
		for (Message message : messageContainer)
		{
			if (counter >= 100) break;
			
			if (Duration.between(message.getReceiveTime(), Instant.now()).toMinutes() >= 5) break;
			
			resultSnapshot.addToSnapshot(message);	
			counter++;
		}
		
		return resultSnapshot;
	}

	public long numberOfErrorMessages() 
	{
		long numberOfErrors = 0;
		int counter = 0;
		
		for (Message message : messageContainer)
		{
			if (counter >= 100) break;
			
			if (Duration.between(message.getReceiveTime(), Instant.now()).toMinutes() >= 5) break;
			
			int errorCode = message.getErrorCode();
			if (((errorCode >= 400 && errorCode <= 418) || errorCode == 451) ||
				 (errorCode >= 500 && errorCode <= 511))
			{
				numberOfErrors++;	
			}
			counter++;
		}
		
		return numberOfErrors;
	}

}
