package fsm.timer;

import org.junit.Assert;
import org.junit.Test;

import fsm.core.Context;
import fsm.core.Event;
import fsm.core.mock.delay.ThreadedTimer;

public class ThreadedDeadlineTimerTest {
	private Event response = null;

	@Test
	public void testDeadlineTimer() {
		ThreadedTimer timer = new ThreadedTimer();
		TimeEventQueue queue = new TimeEventQueue(timer);

		Context reply = new Context.Adapter() {
			@Override
			public void accept(Event evt) {
				response = evt;
				synchronized (ThreadedDeadlineTimerTest.this) {
					ThreadedDeadlineTimerTest.this.notifyAll();
				}
			}
		};

		SetDeadlineTimer evt = new SetDeadlineTimer(reply, 1000);
		queue.send(evt);
		try {
			synchronized (ThreadedDeadlineTimerTest.this) {
				ThreadedDeadlineTimerTest.this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(response instanceof DeadlineTimeout);

		timer.shutdown();
	}
}
