package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.EventQueue;
import fsm.core.TopicQueue;

public class AlarmQueue extends EventQueue.Adaptor implements TopicQueue {

	@Override
	public void publish(Event evt) {
	}
}
