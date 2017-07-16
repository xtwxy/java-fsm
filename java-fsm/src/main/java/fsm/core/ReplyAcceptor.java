package fsm.core;

public interface ReplyAcceptor extends State {
	State acceptReply(Machine m, ReplyEvent evt);
}
