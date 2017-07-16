package fsm.core.mock.delay;

public final class AlarmState {
	public final AlarmPriority alarmPriority;
	public final ReceiveState receiveState;
	public final DelayState delayState;
	public final NotificationState notificationState;

	AlarmState(AlarmPriority p, ReceiveState r, DelayState d, NotificationState n) {
		this.alarmPriority = p;
		this.receiveState = r;
		this.delayState = d;
		this.notificationState = n;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alarmPriority == null) ? 0 : alarmPriority.hashCode());
		result = prime * result + ((delayState == null) ? 0 : delayState.hashCode());
		result = prime * result + ((notificationState == null) ? 0 : notificationState.hashCode());
		result = prime * result + ((receiveState == null) ? 0 : receiveState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlarmState other = (AlarmState) obj;
		if (alarmPriority != other.alarmPriority)
			return false;
		if (delayState != other.delayState)
			return false;
		if (notificationState != other.notificationState)
			return false;
		if (receiveState != other.receiveState)
			return false;
		return true;
	}
}
