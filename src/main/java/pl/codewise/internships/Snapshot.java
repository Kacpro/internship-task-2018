package pl.codewise.internships;

import java.util.LinkedList;
import java.util.List;

public class Snapshot 
{
	private List<Message> snapshotList = new LinkedList<Message>();
	
	public void addToSnapshot(Message message)
	{
		snapshotList.add(message);
	}
	
	public List<Message> getList()
	{
		return snapshotList;
	}

}
