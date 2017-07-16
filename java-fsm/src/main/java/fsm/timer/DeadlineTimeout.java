package fsm.timer;

import fsm.core.Event;
import fsm.core.StateSet;
import fsm.core.State;

public final class DeadlineTimeout implements Event {
	private final StateSet source;

	public DeadlineTimeout(StateSet src) {
		this.source = src;
	}

	@Override
	public boolean apply(State s) {
		DeadlineTimeoutAcceptor acceptor = (DeadlineTimeoutAcceptor) s;
		acceptor.acceptDeadlineTimeout(this);
		return true;
	}

	@Override
	public StateSet source() {
		return source;
	}
}
