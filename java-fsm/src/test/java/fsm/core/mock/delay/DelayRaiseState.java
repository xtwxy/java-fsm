package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.EventQueue;
import fsm.core.Machine;
import fsm.core.State;
import fsm.timer.SetDeadlineTimer;

public class DelayRaiseState implements State {
	private final Machine machine;

	public DelayRaiseState(Machine m) {
		this.machine = m;
	}

	@Override
	public boolean accept(Event evt) {
		return false;
	}
}
