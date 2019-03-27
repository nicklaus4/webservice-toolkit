package com.github.nicklaus4.webservice.client.interceptors;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * client auth
 *
 * @author weishibai
 * @date 2019/03/26 11:27 PM
 */
public class AuthorizeInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    private String username;

    private String password;

    private String targetNamespace;

    public AuthorizeInterceptor(String username, String password, String targetNamespace) {
        //设置在发送请求前阶段进行拦截
        super(Phase.PREPARE_SEND);
        this.username = username;
        this.password = password;
        this.targetNamespace = targetNamespace;
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        final List<Header> headers = soapMessage.getHeaders();
        Document doc = DOMUtils.createDocument();
        Element auth = doc.createElementNS(targetNamespace,"SecurityHeader");
        Element UserName = doc.createElement("username");
        Element UserPass = doc.createElement("password");

        UserName.setTextContent(username);
        UserPass.setTextContent(password);

        auth.appendChild(UserName);
        auth.appendChild(UserPass);

        headers.add(0, new Header(new QName("SecurityHeader"), auth));
    }
}
