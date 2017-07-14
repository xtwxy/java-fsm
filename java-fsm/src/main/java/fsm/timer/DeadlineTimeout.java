package fsm.timer;

import fsm.core.Context;
import fsm.core.Event;
import fsm.nfa.State;

public final class DeadlineTimeout implements Event {
	private final Context source;

	public DeadlineTimeout(Context src) {
		this.source = src;
	}

	@Override
	public void apply(Context ctx, State s) {
		DeadlineTimeoutAcceptor acceptor = (DeadlineTimeoutAcceptor) s;
		acceptor.acceptDeadlineTimeout(ctx, this);
	}

	@Override
	public Context source() {
		return source;
	}
}
