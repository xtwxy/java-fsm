package fsm.nfa;

import fsm.core.Context;
import fsm.core.Event;

public interface State {
	State accept(Context ctx, Event evt);
}
