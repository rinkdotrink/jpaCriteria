/*
 * (c) Bernd Müller & Harald Wehr, www.jpainfo.de
 */
package de.koerner.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Sparkonto.DISCRIMINATOR_VALUE)
public class Sparkonto extends Konto {
	
	public static final String DISCRIMINATOR_VALUE = "SPAR"; 
	
	private BigDecimal guthabenzinssatz;

	public BigDecimal getGuthabenzinssatz() {
		return guthabenzinssatz;
	}

	public void setGuthabenzinssatz(BigDecimal guthabenzinssatz) {
		this.guthabenzinssatz = guthabenzinssatz;
	}
	
}
