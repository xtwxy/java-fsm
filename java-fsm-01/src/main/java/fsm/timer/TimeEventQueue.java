package fsm.timer;

import fsm.core.Context;
import fsm.core.Event;
import fsm.core.EventQueue;

public class TimeEventQueue implements EventQueue {
	private final Context initial;

	public TimeEventQueue(Context initial) {
		this.initial = initial;
	}

	@Override
	public void send(Event evt) {
		initial.accept(evt);
	}
}
