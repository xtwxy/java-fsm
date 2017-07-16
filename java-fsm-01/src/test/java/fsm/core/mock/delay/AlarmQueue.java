package fsm.core.mock.delay;

import java.util.Set;
import java.util.TreeSet;

import fsm.core.Event;
import fsm.core.Context;
import fsm.core.TopicQueue;

public class AlarmQueue implements TopicQueue {
	private final Set<Context> subscribers;

	public AlarmQueue() {
		this.subscribers = new TreeSet<>();
	}

	@Override
	public void subscribe(Context ctx) {
		this.subscribers.add(ctx);
	}

	@Override
	public void unsubscribe(Context ctx) {
		this.subscribers.remove(ctx);
	}

	@Override
	public void send(Event evt) {
	}
	
	@Override
	public void publish(Event evt) {
		for (Context ctx : this.subscribers) {
			ctx.accept(evt);
		}
	}
}
