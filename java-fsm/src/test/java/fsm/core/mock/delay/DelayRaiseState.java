package fsm.core.mock.delay;

import fsm.core.Event;
import fsm.core.EventQueue;
import fsm.core.Context;
import fsm.nfa.State;
import fsm.timer.SetDeadlineTimer;

public class DelayRaiseState implements State {
	private EventQueue timerQueue;
	
	@Override
	public State accept(Context ctx, Event evt) {
		return null;
	}

	@Override
	public void enter(Context ctx) {
		timerQueue.send(new SetDeadlineTimer(ctx, 1000));
	}

	@Override
	public void leave(Context ctx) {
		
	}
}
