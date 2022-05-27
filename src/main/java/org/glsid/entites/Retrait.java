package org.glsid.entites;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

}
