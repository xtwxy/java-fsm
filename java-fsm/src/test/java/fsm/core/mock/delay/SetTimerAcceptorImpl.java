package fsm.core.mock.delay;

import java.util.concurrent.ThreadPoolExecutor;

import fsm.core.Event;
import fsm.core.StateMachine;
import fsm.timer.DeadlineTimeout;
import fsm.timer.SetDeadlineTimer;
import fsm.timer.SetDeadlineTimerAcceptor;

public class SetTimerAcceptorImpl implements SetDeadlineTimerAcceptor {

	private final StateMachine machine;
	private final ThreadPoolExecutor executor;

	public SetTimerAcceptorImpl(StateMachine m, ThreadPoolExecutor executor) {
		this.machine = m;
		this.executor = executor;
	}

	@Override
	public void acceptSetDeadlineTimer(SetDeadlineTimer evt) {
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
				evt.source().state().accept(new DeadlineTimeout(machine));
			}
		};
		executor.execute(r);
	}

	@Override
	public boolean accept(Event evt) {
		return false;
	}
}
