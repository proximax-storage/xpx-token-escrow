package io.proximax.escrow.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

//import org.nem.core.model.Transaction;
//import org.nem.core.model.TransferTransaction;
//import org.nem.core.model.mosaic.Mosaic;
//import org.nem.core.model.mosaic.MosaicId;
//import org.nem.core.model.ncc.TransactionMetaDataPair;
//import io.nem.apps.api.TransactionApi;
public class TransactionHelper {

    public static final String SUPPORT_ADDRESS = "TDZQB4XV6ZQ3X7PXGWYL4KWEY7DY2RGSLIN7PA3F";
    public static final String SUPPORT_PRIVATE = "";
    public static final String SUPPORT_PUBLIC = "";

    public static long checkTransaction(String tranId) {
        try {
//			TransactionMetaDataPair tranMetaDataPair = TransactionApi.getTransaction(tranId);
//			Transaction txn = tranMetaDataPair.getEntity();
//			if (txn instanceof TransferTransaction) {
//				TransferTransaction tran = (TransferTransaction) txn;
//				if (SUPPORT_ADDRESS.equals(tran.getRecipient().getAddress().getEncoded())) {
//					MosaicId xpxMosaic = MosaicId.parse("prx:xpx");
//					for (Mosaic m : tran.getMosaics()) {
//						if (xpxMosaic.equals(m.getMosaicId())) {
//							return m.getQuantity().getRaw();
//						}
//					}
//
//				}
//			}
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public static long getXPX(String transactionId) {
        try {
//            TransactionMetaDataPair tranMetaDataPair = TransactionApi.getTransaction(transactionId);
//            Transaction txn = tranMetaDataPair.getEntity();
//            if (txn instanceof TransferTransaction) {
//                TransferTransaction tran = (TransferTransaction) txn;
//                if (SUPPORT_ADDRESS.equals(tran.getRecipient().getAddress().getEncoded())) {
//                    MosaicId xpxMosaic = MosaicId.parse("prx:xpx");
//                    for (Mosaic m : tran.getMosaics()) {
//                        if (xpxMosaic.equals(m.getMosaicId())) {
//                            return m.getQuantity().getRaw();
//                        }
//                    }
//
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    //https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd
    //https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd
    // https://api.coingecko.com/api/v3/simple/price?ids=proximax&vs_currencies=usd
    // {"proximax":{"usd":0.00547268}}
    public static double getTokenPrice(String token) {
        String ids = null;
        if (token.equalsIgnoreCase("xpx")) {
            ids = "proximax";
        } else if (token.equalsIgnoreCase("eth")) {
            ids = "ethereum";
        } else if (token.equalsIgnoreCase("btc")) {
            ids = "bitcoin";
        } else if (token.equalsIgnoreCase("usdt-eth") || token.equalsIgnoreCase("usdt-omni")) {
            ids = "tether";
        }
        if (ids == null) {
            return 0;
        }
        String currency = "usd";
        String json = sendGetHTTP("api.coingecko.com", 80, "/api/v3/simple/price?ids="
                + ids
                + "&vs_currencies="
                + currency);
        System.out.println("Return: " + json);
        Gson gson = new Gson();
        JsonObject queryAccount = gson.fromJson(json, JsonObject.class);
        return queryAccount.get(ids).getAsJsonObject().get("usd").getAsDouble();
    }

    public static double getProximaxPrice() {
        String json = sendGetHTTP("api.coingecko.com", 80, "/api/v3/simple/price?ids=proximax&vs_currencies=usd");
        System.out.println("Return: " + json);
        Gson gson = new Gson();
        JsonObject queryAccount = gson.fromJson(json, JsonObject.class);
        return queryAccount.get("proximax").getAsJsonObject().get("usd").getAsDouble();
    }

    /**
     * Http Get.
     *
     * @param host
     * @param port
     * @param requestUrl the request url
     * @return the string
     */
    public static String sendGetHTTP(String host, int port, String requestUrl) {
        String result = "";
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String url = "http://" + host + ":" + port + requestUrl;
            System.out.println(url);
            url = URLDecoder.decode(url, "UTF-8");
            HttpGet method = new HttpGet(url);
            response = httpClient.execute(method);
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
