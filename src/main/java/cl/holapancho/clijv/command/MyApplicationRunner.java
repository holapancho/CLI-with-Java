package cl.holapancho.clijv.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
public class MyApplicationRunner implements CommandLineRunner, ExitCodeGenerator {

	private final MyCommand myCommand;

	private final IFactory factory; // auto-configured to inject PicocliSpringFactory

	private int exitCode;

	public MyApplicationRunner(MyCommand myCommand, IFactory factory) {
		this.myCommand = myCommand;
		this.factory = factory;
	}

	@Override
	public void run(String... args) throws Exception {
		exitCode = new CommandLine(myCommand, factory).execute(args);
	}

	@Override
	public int getExitCode() {
		return exitCode;
	}
}