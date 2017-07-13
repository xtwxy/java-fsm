package fsm.core;

import fsm.nfa.State;

public interface Event {
	State apply(Context ctx, State s);
	Context source();
}
