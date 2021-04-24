package org.burakisik.osgi.user.interfaces;

import org.burakisik.osgi.common.service.i18n.InternationalizationService;

public class Services {
	
	private static Services instance;
	private InternationalizationService i18n;
	
	private Services() {
		
	}
	
	public static Services getInstance() {
		if(instance == null) {
			instance = new Services();
		}
		return instance;
	}

	public InternationalizationService getI18n() {
		return i18n;
	}

	public void setI18n(InternationalizationService i18n) {
		this.i18n = i18n;
	}
}
