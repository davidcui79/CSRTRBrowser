package gui;

import java.awt.event.ActionEvent;

public interface MainWindowAdapter {
	public void fileOpenActionPerformed(ActionEvent event);
	public void exitActionPerformed(ActionEvent event);
	public void aboutActionPerformed(ActionEvent event);
	public void searchNextActionPerformed(ActionEvent event);
	public void searchPrevActionPerformed(ActionEvent event);
}
