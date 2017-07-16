package fsm.core;

public interface TopicQueue extends EventQueue {
	void subscribe(Machine m);
	void unsubscribe(Machine m);
	void publish(Event evt);
}
