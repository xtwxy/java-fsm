package fsm.core;

import org.junit.Assert;
import org.junit.Test;

import fsm.core.mock.delay.DelayAlarmStateSet;
import fsm.core.mock.delay.ThreadedTimer;
import fsm.timer.DeadlineTimeout;
import fsm.timer.SetDeadlineTimer;
import fsm.timer.TimeEventQueue;

public class DelayAlarmTest {
	@Test
	public void testDelayAlarm() {
		TimeEventQueue timer = new TimeEventQueue(new ThreadedTimer());

		DelayAlarmStateSet src = new DelayAlarmStateSet();
		SetDeadlineTimer evt = new SetDeadlineTimer(src, 1000);
		timer.send(evt);
		synchronized (src) {
			try {
				src.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Assert.assertTrue(src.response() instanceof DeadlineTimeout);
	}
}
