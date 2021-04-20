package org.burakisik.osgi.common.data;

import java.awt.Rectangle;

import org.burakisik.osgi.common.type.LocationOnScreen;

public record Placement(LocationOnScreen location, Rectangle size) {

}
