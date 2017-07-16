package fsm.timer;

import fsm.core.Event;
import fsm.core.State;

public interface DeadlineTimeoutAcceptor extends State {
	void acceptDeadlineTimeout(Event evt);

	public abstract class Adaptor implements DeadlineTimeoutAcceptor {
		@Override
		public boolean accept(Event evt) {
			return false;
		}
	}
}
