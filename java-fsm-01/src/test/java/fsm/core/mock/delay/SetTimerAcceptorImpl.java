package fsm.core.mock.delay;

import java.util.concurrent.ThreadPoolExecutor;

import fsm.core.Context;
import fsm.core.Event;
import fsm.nfa.State;
import fsm.timer.DeadlineTimeout;
import fsm.timer.SetDeadlineTimer;
import fsm.timer.SetDeadlineTimerAcceptor;

public class SetTimerAcceptorImpl implements SetDeadlineTimerAcceptor {

	private final ThreadPoolExecutor executor;

	public SetTimerAcceptorImpl(ThreadPoolExecutor executor) {
		this.executor = executor;
	}

	@Override
	public State acceptSetDeadlineTimer(Context ctx, SetDeadlineTimer evt) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				if (evt.deadline() > System.currentTimeMillis()) {
					try {
						Thread.sleep(evt.deadline() - System.currentTimeMillis());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				evt.source().accept(new DeadlineTimeout(ctx));
			}
		};
		executor.execute(r);
		return this;
	}

	@Override
	public State accept(Context ctx, Event evt) {
		return null;
	}

	@Override
	public void enter(Context ctx) {
	}

	@Override
	public void leave(Context ctx) {
	}

}
