package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.State;
import fsm.core.StateSet;

public class DelayAlarmStateSet implements StateSet {
	private Event response;
	private final State state = new State() {

		@Override
		public boolean accept(Event evt) {
			response = evt;
			synchronized (DelayAlarmStateSet.this) {
				DelayAlarmStateSet.this.notifyAll();
			}
			return true;
		}

	};

	public State state() {
		return state;
	}

	public Event response() {
		return response;
	}

	@Override
	public boolean stopped() {
		return (state() == null);
	}

	@Override
	public void start() {
	}
}
