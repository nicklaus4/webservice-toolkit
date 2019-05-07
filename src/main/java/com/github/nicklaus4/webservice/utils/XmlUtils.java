package com.github.nicklaus4.webservice.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author weishibai
 * @date 2019/05/02 1:49 PM
 */
public class XmlUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

    public static <T> String toXml(T obj, Class<T> clz) {
        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(clz);
            Marshaller marshal = context.createMarshaller();

            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
            marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息
            marshal.setProperty("jaxb.encoding", "utf-8");
            marshal.marshal(obj, writer);
            return new String(writer.getBuffer());
        } catch (JAXBException e) {
            LOGGER.error("xml parse error: ", e);
            return "";
        }
    }

    public static <T> T fromXml(String xmlStr, Class<T> clz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            //noinspection unchecked
            return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            LOGGER.error("parse from xml error: ", e);
            return null;
        }
    }

}
