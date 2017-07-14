package fsm.timer;

import fsm.core.Context;
import fsm.core.Event;
import fsm.nfa.State;

public interface DeadlineTimeoutAcceptor extends State {
	State acceptDeadlineTimeout(Context ctx, Event evt);
}
