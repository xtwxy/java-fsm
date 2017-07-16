package fsm.core;

public interface Event {
	boolean apply(State s);
	StateSet source();
}
