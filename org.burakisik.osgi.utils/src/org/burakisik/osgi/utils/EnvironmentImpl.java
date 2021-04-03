package org.burakisik.osgi.utils;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.management.ManagementFactory;
import java.util.stream.Stream;

import org.burakisik.osgi.common.data.CpuUsage;
import org.burakisik.osgi.common.data.DisplayInfo;
import org.burakisik.osgi.common.service.utils.Environment;
import org.burakisik.osgi.common.service.utils.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.sun.management.OperatingSystemMXBean;

@Component
public class EnvironmentImpl implements Environment {
	
	private StringUtils stringUtils;

	@Override
	public CpuUsage cpuUsage() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		CpuUsage cpuUsage = new CpuUsage(stringUtils.format(String.valueOf(osBean.getProcessCpuLoad()), 4), stringUtils.format(String.valueOf(osBean.getSystemCpuLoad()), 4));
		return cpuUsage;
	}
	
	@Override
	public DisplayInfo displayInfo() {
		
		return new DisplayInfo((byte)totalDevices(), displayWidth(), displayHeight());
	}
	
	private int totalDevices() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length;
	}
	
	private int displayWidth() {
		GraphicsDevice devices [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		return Stream.of(devices).map(GraphicsDevice::getDefaultConfiguration)
					.map(GraphicsConfiguration::getBounds)
					.mapToInt(bounds -> bounds.x + bounds.width)
					.max()
					.orElse(0);
	}
	
	private int displayHeight() {
		GraphicsDevice devices [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		return Stream.of(devices).map(GraphicsDevice::getDefaultConfiguration)
					.map(GraphicsConfiguration::getBounds)
					.mapToInt(bounds -> bounds.y + bounds.height)
					.max()
					.orElse(0);
	}

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setStringUtils(StringUtils stringUtils) {
		this.stringUtils = stringUtils; 
	}
}
