package fsm.timer;

import fsm.core.Context;
import fsm.nfa.State;

public interface SetDeadlineTimerAcceptor extends State {
	State acceptSetDeadlineTimer(Context ctx, SetDeadlineTimer evt);
}
