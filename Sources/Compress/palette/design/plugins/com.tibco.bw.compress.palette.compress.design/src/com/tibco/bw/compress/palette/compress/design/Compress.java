package com.tibco.bw.compress.palette.compress.design;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class Compress extends AbstractUIPlugin 


{

	// The plug-in ID
	public static final String PLUGIN_ID = "com.tibco.bw.palette.compress.design"; //$NON-NLS-1$

	// The shared instance
	private static Compress plugin;
	
	/**
	 * The constructor
	 */
	public Compress() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Compress getDefault() {
		return plugin;
	}

}
