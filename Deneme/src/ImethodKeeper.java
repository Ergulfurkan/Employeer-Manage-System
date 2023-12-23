import java.io.IOException;

public interface ImethodKeeper {
	public void fileWrite();
	public void fileWriteCompletedTasks();
	public void fileWriteCompletedTasks(String writing) throws IOException;
}
