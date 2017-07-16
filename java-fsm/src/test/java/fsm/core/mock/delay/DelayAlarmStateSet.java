package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.StateSet;
import fsm.core.State;

public class DelayAlarmStateSet implements StateSet {

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
