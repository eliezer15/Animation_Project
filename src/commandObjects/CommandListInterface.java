package commandObjects;

public interface CommandListInterface {

	public void addElement(Runnable r);

	public Runnable elementAt(int index);

	public int size();

}