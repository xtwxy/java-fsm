package fsm.core;

public interface TopicQueue extends EventQueue {
	void publish(Event evt);
}
