package com.yada.demo.ws;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.SourceExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class WebServiceClient {

    public static void main(String[] args) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.yada.demo.ws");
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller, marshaller);

        String message = "<HolidayRequest xmlns=\"http://mycompany.com/hr/schemas\">" +
                "<StartDate>2006-07-03</StartDate>" +
                "<EndDate>2006-07-07</EndDate>" +
                "<FirstName>li</FirstName>" +
                "<LastName>rh</LastName>" +
                "</HolidayRequest>";

        StreamSource source = new StreamSource(new StringReader(message));
        StreamResult result = new StreamResult(System.out);
        SourceExtractor extractor = new SourceExtractor() {
            @Override
            public Object extractData(Source source) {
                return source;
            }
        };

        Object node = webServiceTemplate.sendSourceAndReceive("http://localhost:8080/services/holiday", source, extractor);

        HolidayRequest req = new HolidayRequest();
        req.setStartDate("2006-07-03");
        req.setEndDate("2006-07-07");
        req.setFirstName("李");
        req.setLastName("任昊");
        webServiceTemplate.setDefaultUri("http://localhost:8080/services/holiday.wsdl");
        HolidayResponse resp = (HolidayResponse) webServiceTemplate.marshalSendAndReceive(req);
        System.out.println(resp.getResult());
    }

}