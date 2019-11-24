package io.proximax.escrow.util;

public class CONSTS {

    public static final String SUPPORT_ADDRESS = "TDZQB4XV6ZQ3X7PXGWYL4KWEY7DY2RGSLIN7PA3F";
    public static final String SUPPORT_PUBLICKEY = "36e6fbc1cc5c3ef49d313721650b98d7d7d126a4f731d70071f4f3b4798cdc85";
    public static final String SUPPORT_PRIVATEKEY = "deaae199f8e511ec51eb0046cf8d78dc481e20a340d003bbfcc3a66623d09763";

    public static final String NETWORK = "testnet";
    public static final int NODE_DEFAULT_PORT = 7890;
    public static final int NODE_DEFAULT_WSPORT = 7778;
    public static final String[] TESTNET_NODES = {"104.128.226.60", "23.228.67.85", "192.3.61.243", "50.3.87.123"};

    final public static int STATUS_LICENSE_EXPIRED = 0;
    final public static int STATUS_SUBMIT_RERISTER = 1;
    final public static int STATUS_WAITING_PAY = 2;
    final public static int STATUS_SEND_LICENSE = 3;
    final public static int STATUS_WAITING_ACTIVE = 4;
    final public static int STATUS_ACTIVE_LICENSE = 5;
    final public static int STATUS_REGISTER_VOID = 255;

    final public static String LICENSE_PREFIX = "PROXIMAX";

}
