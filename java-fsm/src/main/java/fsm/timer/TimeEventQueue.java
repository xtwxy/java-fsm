package fsm.timer;

import fsm.core.Event;
import fsm.core.EventQueue;
import fsm.core.Machine;

public class TimeEventQueue implements EventQueue {
	private final Machine initial;

	public TimeEventQueue(Machine initial) {
		this.initial = initial;
	}

	@Override
	public void send(Event evt) {
		initial.accept(evt);
	}
}
