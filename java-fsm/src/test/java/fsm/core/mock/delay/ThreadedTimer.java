package fsm.core.mock.delay;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import fsm.core.State;
import fsm.core.StateMachine;

public class ThreadedTimer implements StateMachine {
	private final BlockingQueue<Runnable> workQueue;
	private final ThreadPoolExecutor executor;
	private final SetTimerAcceptorImpl setTimerAcceptor;

	public ThreadedTimer() {
		workQueue = new ArrayBlockingQueue<>(8);
		executor = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, workQueue);
		setTimerAcceptor = new SetTimerAcceptorImpl(this, executor);
	}

	@Override
	public boolean stopped() {
		return executor.isShutdown();
	}

	@Override
	public void start() {
	}

	public void shutdown() {
		executor.shutdown();
	}

	@Override
	public State state() {
		return setTimerAcceptor;
	}
}
