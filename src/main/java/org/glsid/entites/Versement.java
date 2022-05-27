package org.glsid.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {
    
}