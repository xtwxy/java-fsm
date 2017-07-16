package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.Machine;
import fsm.core.State;

public class DelayDownState implements State {
	private final Machine machine;

	public DelayDownState(Machine m) {
		this.machine = m;
	}

	@Override
	public boolean accept(Event evt) {
		return false;
	}
}
