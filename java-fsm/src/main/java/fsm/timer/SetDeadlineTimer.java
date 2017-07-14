package fsm.timer;

import fsm.core.Context;
import fsm.core.Event;
import fsm.nfa.State;

public final class SetDeadlineTimer implements Event {
	private final Context source;
	private final long deadline;

	public SetDeadlineTimer(Context src, long millsecFromNow) {
		this.source = src;
		this.deadline = System.currentTimeMillis() + millsecFromNow;
	}

	@Override
	public void apply(Context ctx, State s) {
		SetDeadlineTimerAcceptor acceptor = (SetDeadlineTimerAcceptor) s;
		acceptor.acceptSetDeadlineTimer(ctx, this);
	}

	@Override
	public Context source() {
		return source;
	}

	public long deadline() {
		return deadline;
	}
}
