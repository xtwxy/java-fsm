package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.State;

public class DelayDownState implements State {
	private final DelayAlarmStateSet machine;

	public DelayDownState(DelayAlarmStateSet m) {
		this.machine = m;
	}

	@Override
	public boolean accept(Event evt) {
		return false;
	}
}
