package fsm.core;

public interface TopicQueue extends EventQueue {
	void subscribe(Context ctx);
	void unsubscribe(Context ctx);
	void publish(Event evt);
}
