package fsm.timer;

import fsm.core.Event;
import fsm.core.State;
import fsm.core.StateMachine;

public class DeadlineTimerStateSet extends StateMachine.Adapter {
	private Event response;
	private final State state = new State() {

		@Override
		public boolean accept(Event evt) {
			response = evt;
			synchronized (DeadlineTimerStateSet.this) {
				DeadlineTimerStateSet.this.notifyAll();
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
}
