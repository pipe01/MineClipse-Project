package org.craftyourmod.mineclipse.core;

import java.beans.PropertyChangeSupport;

import org.craftyourmod.mineclipse.core.filemanager.FileManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.craftyourmod.mineclipse.core"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	private static PropertyChangeSupport mineClipseSupport;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		mineClipseSupport = new PropertyChangeSupport(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		save();
		super.stop(context);
	}

	private void save() {
		FileManager.INSTANCE.store(getPreferenceStore());
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the support
	 * 
	 * @return support (PCS)
	 */
	public static PropertyChangeSupport getSupport() {
		return mineClipseSupport;

	}

}
