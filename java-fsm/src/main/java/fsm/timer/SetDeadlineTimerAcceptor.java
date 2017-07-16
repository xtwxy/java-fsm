package fsm.timer;

import fsm.core.Event;
import fsm.core.State;

public interface SetDeadlineTimerAcceptor extends State {
	void acceptSetDeadlineTimer(SetDeadlineTimer evt);

	public abstract class Adaptor implements SetDeadlineTimerAcceptor {
		@Override
		public boolean accept(Event evt) {
			return false;
		}
	}
}
