package fsm.core;

import org.junit.Test;

import fsm.core.mock.delay.DelayAlarmMachine;
import fsm.core.mock.delay.ThreadedTimer;
import fsm.nfa.State;
import fsm.timer.SetDeadlineTimer;
import fsm.timer.TimeEventQueue;

public class DelayAlarmTest {
	@Test
	public void testDelayAlarm() {
		TimeEventQueue timer = new TimeEventQueue(new ThreadedTimer());
		
		State initial = null;
		Context src = new DelayAlarmMachine(initial);
		SetDeadlineTimer evt = new SetDeadlineTimer(src, 1000);
		timer.send(evt);
	}
}
