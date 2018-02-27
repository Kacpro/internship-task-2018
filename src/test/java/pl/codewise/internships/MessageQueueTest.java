package pl.codewise.internships;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageQueueTest 
{
	@Test
	public void numberOfErrorMessagesTest()
	{
		Receiver receiver = new Receiver();
		assertEquals("Empty receiver should have 0 error messages", 0, receiver.numberOfErrorMessages());
		
		receiver.add(new Message("Kacper", 200));
		assertEquals("Receiver with a correct message should have 0 error messages", 0, receiver.numberOfErrorMessages());
		
		receiver.add(new Message("Kacper2", 404));
		assertEquals("Receiver with 1 correct message and 1 with an error should have 1 error messages", 1, receiver.numberOfErrorMessages());
		
		// there are currently 2 messages in the receiver: the first correct and the second with an error
		
		for (int i=0; i<100; i++)
		{
			receiver.add(new Message("Kacper" + i, 200));
		}
		assertEquals("Receiver with 1 error message on 101 position should have 0 error messages", 0, receiver.numberOfErrorMessages());
	}
	
	@Test
	public void snapshotTest()
	{
		Receiver receiver = new Receiver();
		assertEquals("Snapshot of an empty receiver should contain 0 messages",0, receiver.snapshot().getList().size());
		
		for (int i=0; i<10; i++)
		{
			receiver.add(new Message("Kacper" + i, 200));
		}
		assertEquals("Snapshot of a receiver with 10 correct messages should contain 10 messages",10, receiver.snapshot().getList().size());
		
		for (int i=0; i<10; i++)
		{
			receiver.add(new Message("Kacper" + i, 404));
		}
		assertEquals("Snapshot of a receiver with 10 correct messages and 10 incorrect messages should contain 20 messages",20, receiver.snapshot().getList().size());
		
		for (int i=0; i<100; i++)
		{
			receiver.add(new Message("Kacper" + i, 200));
		}
		// there are currently 120 messages in the receiver
		assertEquals("Snapshot of a receiver with over then 100 messages should contain 100 messages",100, receiver.snapshot().getList().size());
	}
}