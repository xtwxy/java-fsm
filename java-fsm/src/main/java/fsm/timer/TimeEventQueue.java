package fsm.timer;

import fsm.core.Event;
import fsm.core.EventQueue;
import fsm.core.StateMachine;

public class TimeEventQueue extends EventQueue.Adaptor {
	private final StateMachine queueHandler;

	public TimeEventQueue(StateMachine handler) {
		this.queueHandler = handler;
	}

	@Override
	public void send(Event evt) {
		evt.apply(queueHandler.state());
	}
}
