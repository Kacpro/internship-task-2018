package pl.codewise.internships;

import pl.codewise.internships.Message;
import pl.codewise.internships.Snapshot;

public interface MessageQueue 
{

    void add(Message message);

    Snapshot snapshot();

    long numberOfErrorMessages();
}
