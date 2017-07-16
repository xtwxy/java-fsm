package fsm.timer;

import org.junit.Assert;
import org.junit.Test;

import fsm.core.mock.delay.ThreadedTimer;

public class ThreadedDeadlineTimerTest {

	@Test
	public void testDeadlineTimer() {
		ThreadedTimer timer = new ThreadedTimer();
		TimeEventQueue queue = new TimeEventQueue(timer);

		DeadlineTimerStateSet reply = new DeadlineTimerStateSet();

		SetDeadlineTimer evt = new SetDeadlineTimer(reply, 1000);
		queue.send(evt);
		try {
			synchronized (reply) {
				reply.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(reply.response() instanceof DeadlineTimeout);

		timer.shutdown();
	}
}
