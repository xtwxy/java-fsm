package fsm.core;

public interface Event {
	boolean apply(State s);
	Machine source();
}
