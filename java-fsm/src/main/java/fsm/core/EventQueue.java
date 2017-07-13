package fsm.core;

public interface EventQueue {
	void subscribe(Context ctx);
	void publish(Event evt);
}
