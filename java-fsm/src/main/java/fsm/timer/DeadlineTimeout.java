package fsm.timer;

import fsm.core.Event;
import fsm.core.StateMachine;
import fsm.core.State;

public final class DeadlineTimeout implements Event {
	private final StateMachine source;

	public DeadlineTimeout(StateMachine src) {
		this.source = src;
	}

	@Override
	public boolean apply(State s) {
		DeadlineTimeoutAcceptor acceptor = (DeadlineTimeoutAcceptor) s;
		acceptor.acceptDeadlineTimeout(this);
		return true;
	}

	@Override
	public StateMachine source() {
		return source;
	}
}
