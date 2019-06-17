package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author andreyf
 * Helper to hide panels
 */
public class UIHelper {

	static void setPanelEnabled(JPanel panel, Boolean isEnabled) {
	    panel.setEnabled(isEnabled);

	    Component[] components = panel.getComponents();

	    for (Component component : components) {
	        if (component instanceof JPanel) {
	            setPanelEnabled((JPanel) component, isEnabled);
	        }
	        component.setEnabled(isEnabled);
	    }
	}
	
    public static void disableUI(final Container container, Class<?>... ignoreList) {

    	ArrayList componentsToReenable = new ArrayList();

        final Component[] components = container.getComponents();
        for (Component component : components) {

            if (component != null) {

                if (component instanceof Container) {
                	disableUI((Container) component, ignoreList);
                }

                // AND THEN DEAL WITH THE ELEMENTS
                if (component.isEnabled()) {
                    boolean found = false;
                    if (ignoreList != null) {
                        for (Class<?> cls : ignoreList) {
                            if (component.getClass() == cls) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) {
                        component.setEnabled(false);
                        componentsToReenable.add(component);
                    }
                }
            }
        }
    }
}
