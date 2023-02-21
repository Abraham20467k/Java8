package com.mkyong.jdbc.statement.row.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Poliza {

	
		Date FECINIVIG;
		 Date FECFINVIG;
		 LocalDateTime   FECREG;
		 LocalDateTime   FECMOD;
		 Date   FECCOT;
		 BigDecimal  TASA;
		 BigDecimal  PRIMAPOLTRANSAC;
		public Date getFECINIVIG() {
			return FECINIVIG;
		}
		public void setFECINIVIG(Date fECINIVIG) {
			FECINIVIG = fECINIVIG;
		}
		public Date getFECFINVIG() {
			return FECFINVIG;
		}
		public void setFECFINVIG(Date fECFINVIG) {
			FECFINVIG = fECFINVIG;
		}
		public LocalDateTime getFECREG() {
			return FECREG;
		}
		public void setFECREG(LocalDateTime fECREG) {
			FECREG = fECREG;
		}
		public LocalDateTime getFECMOD() {
			return FECMOD;
		}
		public void setFECMOD(LocalDateTime fECMOD) {
			FECMOD = fECMOD;
		}
		public Date getFECCOT() {
			return FECCOT;
		}
		public void setFECCOT(Date fECCOT) {
			FECCOT = fECCOT;
		}
		public BigDecimal getTASA() {
			return TASA;
		}
		public void setTASA(BigDecimal tASA) {
			TASA = tASA;
		}
		public BigDecimal getPRIMAPOLTRANSAC() {
			return PRIMAPOLTRANSAC;
		}
		public void setPRIMAPOLTRANSAC(BigDecimal pRIMAPOLTRANSAC) {
			PRIMAPOLTRANSAC = pRIMAPOLTRANSAC;
		}
		 
		 
}
