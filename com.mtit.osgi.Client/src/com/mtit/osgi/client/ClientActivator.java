package com.mtit.osgi.client;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.mtit.osgi.service.IServiceActions;
import com.mtit.osgi.service.ServiceActions;

/**
 * The activator class controls the plug-in life cycle
 */
public class ClientActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.mtit.osgi.Client"; //$NON-NLS-1$

	// The shared instance
	private static ClientActivator plugin;
	
	org.osgi.framework.ServiceReference serviceRef;
	
	/**
	 * The constructor
	 */
	public ClientActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		System.out.println("client starts!!");
		serviceRef = context.getServiceReference(IServiceActions.class.getName());
		ServiceActions sactions = (ServiceActions)context.getService(serviceRef);
		System.out.println(sactions.PrintService());
		System.out.println(sactions.Hello());
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		
		System.out.println("client stoped!!");
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ClientActivator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
