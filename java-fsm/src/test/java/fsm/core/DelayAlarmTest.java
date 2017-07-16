package fsm.core;

import org.junit.Test;

import fsm.core.mock.delay.DelayAlarmStateSet;
import fsm.core.mock.delay.ThreadedTimer;
import fsm.timer.SetDeadlineTimer;
import fsm.timer.TimeEventQueue;

public class DelayAlarmTest {
	@Test
	public void testDelayAlarm() {
		TimeEventQueue timer = new TimeEventQueue(new ThreadedTimer());

		StateSet src = new DelayAlarmStateSet();
		SetDeadlineTimer evt = new SetDeadlineTimer(src, 1000);
		timer.send(evt);
	}
}
