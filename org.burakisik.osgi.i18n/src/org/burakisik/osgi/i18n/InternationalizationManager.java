package org.burakisik.osgi.i18n;


import java.util.Locale;
import java.util.ResourceBundle;
import org.burakisik.osgi.common.service.i18n.InternationalizationService;
import org.osgi.service.component.annotations.Component;

@Component(service = InternationalizationService.class, immediate = true)
public class InternationalizationManager implements InternationalizationService {

	private Locale defaultLocale = new Locale("en","US");
	private ResourceBundle messages = ResourceBundle.getBundle("language", defaultLocale);

	@Override
	public String fetchTextfromResourceBundle(String property) {
		String value = messages.getString(property);
		return value;
	}	
}
