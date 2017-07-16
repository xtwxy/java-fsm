package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.Machine;
import fsm.core.State;

public class DelayAlarmMachine implements Machine {

	@Override
	public boolean accept(Event evt) {
		return state().accept(evt);
	}

	@Override
	public boolean stopped() {
		return (state() == null);
	}

	@Override
	public void start() {
	}

	@Override
	public State state() {
		return null;
	}
}
