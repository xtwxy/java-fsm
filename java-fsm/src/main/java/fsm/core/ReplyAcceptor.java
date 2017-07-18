package fsm.core;

public interface ReplyAcceptor extends State {
	State acceptReply(StateMachine m, ReplyEvent evt);
}
