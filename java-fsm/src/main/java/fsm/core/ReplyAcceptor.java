package fsm.core;

public interface ReplyAcceptor extends State {
	State acceptReply(StateSet m, ReplyEvent evt);
}
