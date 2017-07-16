package fsm.core.mock.delay;

import java.util.Set;
import java.util.TreeSet;

import fsm.core.Event;
import fsm.core.Machine;
import fsm.core.TopicQueue;

public class AlarmQueue implements TopicQueue {
	private final Set<Machine> subscribers;

	public AlarmQueue() {
		this.subscribers = new TreeSet<>();
	}

	@Override
	public void subscribe(Machine m) {
		this.subscribers.add(m);
	}

	@Override
	public void unsubscribe(Machine m) {
		this.subscribers.remove(m);
	}

	@Override
	public void send(Event evt) {
	}

	@Override
	public void publish(Event evt) {
		for (Machine m : this.subscribers) {
			m.accept(evt);
		}
	}
}
