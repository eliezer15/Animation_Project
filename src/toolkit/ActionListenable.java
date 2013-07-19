package toolkit;

import java.awt.event.ActionListener;

public interface ActionListenable {

	void addActionListener(ActionListener anActionListener);
	boolean getEnabled();
	void setEnabled(boolean newVal);
}
