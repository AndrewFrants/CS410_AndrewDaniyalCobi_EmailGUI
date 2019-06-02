import java.awt.Component;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author andreyf
 * Helper to hide panels
 */
public class UIHelper {

	void setPanelEnabled(JPanel panel, Boolean isEnabled) {
	    panel.setEnabled(isEnabled);

	    Component[] components = panel.getComponents();

	    for (Component component : components) {
	        if (component instanceof JPanel) {
	            setPanelEnabled((JPanel) component, isEnabled);
	        }
	        component.setEnabled(isEnabled);
	    }
	}
}
