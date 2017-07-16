package fsm.core.mock.delay;

import fsm.core.State;
import fsm.core.StateSet;

public class DelayAlarmStateSet implements StateSet {

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
