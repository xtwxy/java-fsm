package fsm.timer;

import fsm.core.Event;
import fsm.core.Machine;
import fsm.core.State;

public final class SetDeadlineTimer implements Event {
	private final Machine source;
	private final long deadline;

	public SetDeadlineTimer(Machine src, long millsecFromNow) {
		this.source = src;
		this.deadline = System.currentTimeMillis() + millsecFromNow;
	}

	@Override
	public boolean apply(State s) {
		SetDeadlineTimerAcceptor acceptor = (SetDeadlineTimerAcceptor) s;
		acceptor.acceptSetDeadlineTimer(this);
		return true;
	}

	@Override
	public Machine source() {
		return source;
	}

	public long deadline() {
		return deadline;
	}
}
