package com.project.servlets.services;

import com.project.entities.Car;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;


import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.StringWriter;

public class JAXBUtil {
    private static JAXBUtil instance;
    private static JAXBContext context;
    public  JAXBUtil getInstance(){
        return instance;
    }
    static{
        try{
            context = JAXBContext.newInstance(ListCars.class, Car.class);
        }catch(JAXBException error){
            throw new RuntimeException();
        }
    }




    public static String toJson(Object object) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            Marshaller marshaller = context.createMarshaller();
            MappedNamespaceConvention convention = new MappedNamespaceConvention();
            XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(convention, writer);
            marshaller.marshal(object, xmlStreamWriter);
            String json = writer.toString();
            return json;
        } catch (JAXBException error) {
            error.printStackTrace();
            return null;
        }
    }



}
