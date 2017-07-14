package fsm.core;

import fsm.nfa.State;

public interface Event {
	void apply(Context ctx, State state);
	Context source();
}
