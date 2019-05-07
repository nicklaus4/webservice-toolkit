package com.github.nicklaus4.webservice.client;

import java.util.function.Supplier;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Suppliers;

/**
 * @author weishibai
 * @date 2019/05/07 17:17
 */
public class CxfCommonClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CxfCommonClient.class);

    private final DynamicClientFactory factory = DynamicClientFactory.newInstance();

    private final String wsUrl;

    private final Supplier<Client> clientSupplier;

    public CxfCommonClient(String wsUrl) {
        this.wsUrl = wsUrl;
        this.clientSupplier = Suppliers.memoize(() -> factory.createClient(this.wsUrl));

    }

    public Object[] execute(String operationName, String userName, String password, byte[] reqBytes) {
        final Client client = clientSupplier.get();
        try {
            return client.invoke(operationName, userName
                    , password, reqBytes);
        } catch (Exception e) {
            LOGGER.error("query error: ", e);
            return null;
        }
    }

    public Object[] execute(String operationName, Object... params) {
        final Client client = clientSupplier.get();
        try {
            return client.invoke(operationName, params);
        } catch (Exception e) {
            LOGGER.error("query error: ", e);
            return null;
        }
    }
}
