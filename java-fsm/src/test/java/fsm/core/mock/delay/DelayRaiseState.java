package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.State;

public class DelayRaiseState implements State {
	private final DelayAlarmStateSet machine;

	public DelayRaiseState(DelayAlarmStateSet m) {
		this.machine = m;
	}

	@Override
	public boolean accept(Event evt) {
		return false;
	}
}
