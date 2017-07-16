package fsm.core.mock.delay;

import fsm.core.Context;
import fsm.core.Event;
import fsm.core.IllegalState;
import fsm.nfa.State;

public class DelayAlarmMachine implements Context {
	private State state;

	public DelayAlarmMachine(State initial) {
		this.state = initial;
	}

	@Override
	public void accept(Event evt) {
		State old = state;
		if (state != null) {
			state = state.accept(this, evt);
		} else {
			throw new IllegalState("State Machine is already STOPPED!");
		}
		if (old != state) {
			old.leave(this);
			if (state != null) {
				state.enter(this);
			}
		}
	}

	@Override
	public boolean stopped() {
		return (state == null);
	}

	@Override
	public void start() {
		state.enter(this);
	}
}
