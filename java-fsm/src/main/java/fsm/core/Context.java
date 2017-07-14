package fsm.core;

public interface Context {
	void accept(Event evt);
	boolean stopped();
	void start();
}
