package com.mtit.osgi.service;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import com.mtit.osgi.service.IServiceActions;

/**
 * The activator class controls the plug-in life cycle
 */
public class ServerActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.mtit.osgi.Service"; //$NON-NLS-1$

	org.osgi.framework.ServiceRegistration serviceReg;
	// The shared instance
	private static ServerActivator plugin;
	
	/**
	 * The constructor
	 */
	public ServerActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		System.out.println("service started");
		IServiceActions sactions = new ServiceActions();
		serviceReg = context.registerService(IServiceActions.class.getName(),sactions,null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		
		serviceReg.unregister();
		System.out.println("service stopped");
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ServerActivator getDefault() {
		return plugin;
	}

}
