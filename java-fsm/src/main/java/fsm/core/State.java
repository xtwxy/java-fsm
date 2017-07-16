package fsm.core;

public interface State {
	boolean accept(Event evt);
}
