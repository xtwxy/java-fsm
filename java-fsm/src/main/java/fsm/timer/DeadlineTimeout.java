package fsm.timer;

import fsm.core.Event;
import fsm.core.Machine;
import fsm.core.State;

public final class DeadlineTimeout implements Event {
	private final Machine source;

	public DeadlineTimeout(Machine src) {
		this.source = src;
	}

	@Override
	public boolean apply(State s) {
		DeadlineTimeoutAcceptor acceptor = (DeadlineTimeoutAcceptor) s;
		acceptor.acceptDeadlineTimeout(this);
		return true;
	}

	@Override
	public Machine source() {
		return source;
	}
}
