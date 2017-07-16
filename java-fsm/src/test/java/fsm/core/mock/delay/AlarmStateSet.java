package fsm.core.mock.delay;

import fsm.core.State;
import fsm.core.StateSet;

public class AlarmStateSet implements StateSet {
	private ReceiveState receiveState;
	private DelayState delayState;
	private NotificationState notificationState;
	private Alarm alarm;
	private final AlarmGraph alarmGraph;
	
	AlarmStateSet(ReceiveState r, DelayState d, NotificationState n, Alarm a, AlarmGraph g) {
		this.receiveState = r;
		this.delayState = d;
		this.notificationState = n;
		this.alarm = a;
		this.alarmGraph = g;
	}

	public State state() {
		return null;
	}

	@Override
	public boolean stopped() {
		return (NotificationState.DOWN_NOTIFIED == notificationState)
				|| (NotificationState.SUPPRESSED == notificationState && DelayState.DELAY_DOWN_COMPLETED == delayState);
	}

	@Override
	public void start() {

	}

	public AlarmPriority priority() {
		return alarmGraph.priority(alarm);
	}
}
