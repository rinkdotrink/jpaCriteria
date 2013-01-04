/*
 * (c) Bernd Müller & Harald Wehr, www.jpainfo.de
 */
package de.koerner.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GIRO")
public class Girokonto extends Konto {
	
	private BigDecimal kreditlimit;
	private BigDecimal sollzinssatz;
	private BigDecimal ueberziehungszinssatz;
	

	public BigDecimal getKreditlimit() {
		return kreditlimit;
	}
	public void setKreditlimit(BigDecimal kreditlimit) {
		this.kreditlimit = kreditlimit;
	}
	public BigDecimal getSollzinssatz() {
		return sollzinssatz;
	}
	public void setSollzinssatz(BigDecimal sollzinssatz) {
		this.sollzinssatz = sollzinssatz;
	}
	public BigDecimal getUeberziehungszinssatz() {
		return ueberziehungszinssatz;
	}
	public void setUeberziehungszinssatz(BigDecimal ueberziehungszinssatz) {
		this.ueberziehungszinssatz = ueberziehungszinssatz;
	}

}
