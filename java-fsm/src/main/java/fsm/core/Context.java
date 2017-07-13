package fsm.core;

public interface Context {
	void send(Event evt);
	boolean stopped();
	ReplyEvent reply();
}
