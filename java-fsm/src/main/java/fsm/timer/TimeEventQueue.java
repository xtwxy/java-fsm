package fsm.timer;

import fsm.core.Event;
import fsm.core.EventQueue;
import fsm.core.StateSet;

public class TimeEventQueue extends EventQueue.Adaptor {
	private final StateSet initial;

	public TimeEventQueue(StateSet initial) {
		this.initial = initial;
	}

	@Override
	public void send(Event evt) {
		initial.accept(evt);
	}
}
