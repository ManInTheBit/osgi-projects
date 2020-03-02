package org.burakisik.osgi.custom.console.commands;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service = CommandProvider.class)
public class ServiceComponent implements CommandProvider {

	private BundleContext context;
	
	@Activate
	public void activate(BundleContext context) {
		this.context = context;
	}

	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
        buffer.append("\tsysinfo - returns framework information\n");
        return buffer.toString();
	}
	
	public void _sysinfo(CommandInterpreter ci) throws Exception {
        String vendor = context.getProperty(Constants.FRAMEWORK_VENDOR);
        String version = context.getProperty(Constants.FRAMEWORK_VERSION);
        String osName = context.getProperty(Constants.FRAMEWORK_OS_NAME);
        String osVersion = context.getProperty(Constants.FRAMEWORK_OS_VERSION);
        System.out.println("\n " + vendor + " " 
                + version + " (" + osName + " " 
                + osVersion + ")");
    }
	
	public void _allBundleIdWithVersion(CommandInterpreter ci) throws Exception {
        Bundle [] bundles = context.getBundles();
        
        for (Bundle bundle : bundles) {
        	System.out.println(bundle.getBundleId() + ": " + bundle.getVersion() +"\n ");
		}
    }
}