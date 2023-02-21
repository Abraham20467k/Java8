package com.mkyong.jdbc.statement.row.datapower;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import pe.com.pacifico.consulta.salud.types.DatosEntidadRequest;
import pe.com.pacifico.consulta.salud.types.ObtenerEntidadRequest;
import pe.com.pacifico.consulta.salud.types.ParametrosAuditRequest;

public class TestDataPower {

	public static void main(String[] args) throws IOException, Exception {

		String soapEndpointUrl = "http://localhost:8090/ConsultaSitedsWS/ebsServiceSOAP11";
		String soapAction = "http://www.pacifico.com.pe/consulta/salud/ws/consultarCartaGarantia";

		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		ParametrosAuditRequest auditRequest = new ParametrosAuditRequest();
		auditRequest.setIdTransaccion("1");

		DatosEntidadRequest datosEntRequest = new DatosEntidadRequest();
		datosEntRequest.setCodIafa("");
		datosEntRequest.setCodIpress("");

		ObtenerEntidadRequest obEntidadRequest = new ObtenerEntidadRequest();
		obEntidadRequest.setAuditRequest(auditRequest);
		obEntidadRequest.setDatosRequest(datosEntRequest);

//		ObtenerEntidadResponse obEntidadResponse = consultaSitedsClient.consultarClinica("", obEntidadRequest);
		callSoapWebService(soapEndpointUrl, soapAction);

	}
	
	 private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
	        SOAPPart soapPart = soapMessage.getSOAPPart();

	        String myNamespace = "myNamespace";
	        String myNamespaceURI = "http://www.pacifico.com.pe/consulta/salud/ws";

	        // SOAP Envelope
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

	            /*
	            Constructed SOAP Request Message:
	            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="https://www.w3schools.com/xml/">
	                <SOAP-ENV:Header/>
	                <SOAP-ENV:Body>
	                    <myNamespace:CelsiusToFahrenheit>
	                        <myNamespace:Celsius>100</myNamespace:Celsius>
	                    </myNamespace:CelsiusToFahrenheit>
	                </SOAP-ENV:Body>
	            </SOAP-ENV:Envelope>
	            */

	        // SOAP Body
	        SOAPBody soapBody = envelope.getBody();
	        SOAPElement soapBodyElem = soapBody.addChildElement(null, myNamespace);
	        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement(null, myNamespace);
	        soapBodyElem1.addTextNode("100");
	    }
	
	 private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
	        try {
	            // Create SOAP Connection
	            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

	            // Send SOAP Message to SOAP Server
	            SOAPMessage soapResponse = soapConnection.call(null, soapEndpointUrl);

	            // Print the SOAP Response
	            System.out.println("Response SOAP Message:");
	            soapResponse.writeTo(System.out);
	            System.out.println();

	            soapConnection.close();
	        } catch (Exception e) {
	            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
	            e.printStackTrace();
	        }
	    }
	 
	 private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();

	        createSoapEnvelope(soapMessage);

	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        headers.addHeader("SOAPAction", soapAction);

	        soapMessage.saveChanges();

	        /* Print the request message, just for debugging purposes */
	        System.out.println("Request SOAP Message:");
	        soapMessage.writeTo(System.out);
	        System.out.println("\n");

	        return soapMessage;
	    }
}