package org.zywx.wbpalmstar.plugin.diditravel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.engine.universalex.EUExBase;
import org.zywx.wbpalmstar.engine.universalex.EUExCallback;

import com.sdu.didi.openapi.DIOpenSDK;
import com.sdu.didi.openapi.DIOpenSDK.TicketType;

import android.content.Context;

public class EUExDiDiTravel extends EUExBase {

    private Context mContext;
    public static final String function_getTicket = "uexDiDiTravel.cbGetTicket";
    public static final String function_isLogin = "uexDiDiTravel.cbIsLogin";
    public static final String function_getEstimateTime = "uexDiDiTravel.cbGetEstimateTime";
    public static final String function_getEstimatePrice = "uexDiDiTravel.cbGetEstimatePrice";
    public static final String function_getCurrentOrderStatus = "uexDiDiTravel.cbGetCurrentOrderStatus";
    public static final String function_getCurrentDriverInfo = "uexDiDiTravel.cbGetCurrentDriverInfo";
    public static final String function_getOrderList = "uexDiDiTravel.cbGetOrderList";
    public static final String function_openPage = "uexDiDiTravel.cbOpenPage";
    public static final String JSON_KEY_APPID = "appid";
    public static final String JSON_KEY_SECRECT = "secrect";
    public static final String JSON_KEY_FROMLAT = "fromlat";
    public static final String JSON_KEY_FROMLNG = "fromlng";
    public static final String JSON_KEY_FROMADDR = "fromaddr";
    public static final String JSON_KEY_FROMNAME = "fromname";
    public static final String JSON_KEY_TOLAT = "tolat";
    public static final String JSON_KEY_TOLNG = "tolng";
    public static final String JSON_KEY_TOADDR = "toaddr";
    public static final String JSON_KEY_TONAME = "toname";
    public static final String JSON_KEY_BIZ = "biz";
    public static final String JSON_KEY_PHONE = "phone";
    public static final String JSON_KEY_MAPTYPE = "maptype";
    public static final String JSON_KEY_PAGE_LOGIN = "login";
    public static final String JSON_KEY_PAGE_ORDERDETAIL = "orderDetail";
    public static final String JSON_KEY_PAGE_ORDERLIST = "orderList";
    public static final String JSON_KEY_PAGE_INVOICE = "invoice";
    public static final String JSON_KEY_PAGE_FINISH = "finish";
    public static final String JSON_KEY_OID = "oid";
    public static final String JSON_KEY_PAGE_INVOICE_PAGE = "page";
    public static final String JSON_KEY_API_GETESTIMATETIME = "getEstimateTime";
    public static final String JSON_KEY_API_GETESTIMATEPRICE = "getEstimatePrice";
    public static final String JSON_KEY_API_GETCURRENTORDERSTATUS = "getCurrentOrderStatus";
    public static final String JSON_KEY_API_GETCURRENTDRIVERINFO = "getCurrentDriverInfo";
    public static final String JSON_KEY_API_GETORDERLIST = "getOrderList";
    public static final String JSON_KEY_SIZE = "size";
    public static final String JSON_KEY_OFFSET = "offset";
    public static final String JSON_KEY_TICKET_TYPE = "type";

    public EUExDiDiTravel(Context context, EBrowserView ebView) {
         super(context, ebView);
         mContext = context;
    }

    public void registerApp(String[] params) {
        try {
            JSONObject object = new JSONObject(params[0]);
            String appid = object.optString(JSON_KEY_APPID);
            String secrect = object.optString(JSON_KEY_SECRECT);
            DIOpenSDK.registerApp(mContext, appid, secrect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDDPage(String[] params) {
        try {
            JSONObject object = new JSONObject(params[0]);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(JSON_KEY_FROMLAT, object.optString(JSON_KEY_FROMLAT));
            map.put(JSON_KEY_FROMLNG, object.optString(JSON_KEY_FROMLNG));
            map.put(JSON_KEY_FROMADDR, object.optString(JSON_KEY_FROMADDR));
            map.put(JSON_KEY_FROMNAME, object.optString(JSON_KEY_FROMNAME));
            map.put(JSON_KEY_TOLAT, object.optString(JSON_KEY_TOLAT));
            map.put(JSON_KEY_TOLNG, object.optString(JSON_KEY_TOLNG));
            map.put(JSON_KEY_TOADDR, object.optString(JSON_KEY_TOADDR));
            map.put(JSON_KEY_TONAME, object.optString(JSON_KEY_TONAME));
            map.put(JSON_KEY_BIZ, object.optString(JSON_KEY_BIZ));
            map.put(JSON_KEY_PHONE, object.optString(JSON_KEY_PHONE));
            map.put(JSON_KEY_MAPTYPE, object.optString(JSON_KEY_MAPTYPE));
            DIOpenSDK.showDDPage(mContext, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callDDApi(String[] params) {
        try {
            String apiname = "";
            String callbackName = "";
            HashMap<String, String> map = new HashMap<String, String>();
            JSONObject object = new JSONObject(params[0]);
            if (object.has(JSON_KEY_API_GETESTIMATETIME)) {
                JSONObject time = new JSONObject(object.getString(JSON_KEY_API_GETESTIMATETIME));
                map.put(JSON_KEY_FROMLAT, time.optString(JSON_KEY_FROMLAT));
                map.put(JSON_KEY_FROMLNG, time.optString(JSON_KEY_FROMLNG));
                map.put(JSON_KEY_FROMADDR, time.optString(JSON_KEY_FROMADDR));
                map.put(JSON_KEY_FROMNAME, time.optString(JSON_KEY_FROMNAME));
                map.put(JSON_KEY_MAPTYPE, time.optString(JSON_KEY_MAPTYPE));
                map.put(JSON_KEY_BIZ, time.optString(JSON_KEY_BIZ));
                apiname = JSON_KEY_API_GETESTIMATETIME;
                callbackName = function_getEstimateTime;
            } else if (object.has(JSON_KEY_API_GETESTIMATEPRICE)) {
                JSONObject price = new JSONObject(object.getString(JSON_KEY_API_GETESTIMATEPRICE));
                map.put(JSON_KEY_FROMLAT, price.optString(JSON_KEY_FROMLAT));
                map.put(JSON_KEY_FROMLNG, price.optString(JSON_KEY_FROMLNG));
                map.put(JSON_KEY_FROMADDR, price.optString(JSON_KEY_FROMADDR));
                map.put(JSON_KEY_FROMNAME, price.optString(JSON_KEY_FROMNAME));
                map.put(JSON_KEY_TOLAT, price.optString(JSON_KEY_TOLAT));
                map.put(JSON_KEY_TOLNG, price.optString(JSON_KEY_TOLNG));
                map.put(JSON_KEY_TOADDR, price.optString(JSON_KEY_TOADDR));
                map.put(JSON_KEY_TONAME, price.optString(JSON_KEY_TONAME));
                map.put(JSON_KEY_MAPTYPE, price.optString(JSON_KEY_MAPTYPE));
                map.put(JSON_KEY_BIZ, price.optString(JSON_KEY_BIZ));
                apiname = JSON_KEY_API_GETESTIMATEPRICE;
                callbackName = function_getEstimatePrice;
            } else if (object.has(JSON_KEY_API_GETCURRENTORDERSTATUS)) {
                apiname = JSON_KEY_API_GETCURRENTORDERSTATUS;
                callbackName = function_getCurrentOrderStatus;
            } else if (object.has(JSON_KEY_API_GETCURRENTDRIVERINFO)) {
                apiname = JSON_KEY_API_GETCURRENTDRIVERINFO;
                callbackName = function_getCurrentDriverInfo;
            } else if (object.has(JSON_KEY_API_GETORDERLIST)) {
                JSONObject orderList = new JSONObject(object.getString(JSON_KEY_API_GETORDERLIST));
                map.put(JSON_KEY_SIZE, orderList.optString(JSON_KEY_SIZE));
                map.put(JSON_KEY_OFFSET, orderList.optString(JSON_KEY_OFFSET));
                apiname = JSON_KEY_API_GETORDERLIST;
                callbackName = function_getOrderList;
            }

            final String callback = callbackName;
            DIOpenSDK.asynCallDDApi(mContext, apiname, map, new DIOpenSDK.DDCallBack() {
                @Override
                public void onFinish(Map<String, String> result) {
                    onJSONResultCallback(callback, result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTicket(String[] params) {
        try {
            JSONObject object = new JSONObject(params[0]);
            String type = object.optString(JSON_KEY_TICKET_TYPE);
            TicketType ticketType = "1".equals(type) ? TicketType.LONGTIME : TicketType.SINGLE;
            DIOpenSDK.asynGetTicket(mContext, ticketType, new DIOpenSDK.DDCallBack() {
                @Override
                public void onFinish(Map<String, String> result) {
                    onJSONResultCallback(function_getTicket, result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int isLogin(String[] params) {
        int isLogin = DIOpenSDK.isLogin(mContext) ? 0 : 1;
        jsCallback(function_isLogin, 0, EUExCallback.F_C_INT, isLogin);
        return isLogin;
    }

    public void openPage(String[] params) {
        try {
            String page = "";
            HashMap<String, String> map = new HashMap<String, String>();
            JSONObject object = new JSONObject(params[0]);
            if (object.has(JSON_KEY_PAGE_LOGIN)) {
                JSONObject login = new JSONObject(object.getString(JSON_KEY_PAGE_LOGIN));
                String finish = login.optString(JSON_KEY_PAGE_FINISH, "close_page");
                map.put(JSON_KEY_PAGE_FINISH, finish);
                page = JSON_KEY_PAGE_LOGIN;
            } else if (object.has(JSON_KEY_PAGE_ORDERDETAIL)) {
                JSONObject orderDetail = new JSONObject(object.getString(JSON_KEY_PAGE_ORDERDETAIL));
                map.put(JSON_KEY_BIZ, orderDetail.optString(JSON_KEY_BIZ));
                map.put(JSON_KEY_OID, orderDetail.optString(JSON_KEY_OID));
                page = JSON_KEY_PAGE_ORDERDETAIL;
            } else if (object.has(JSON_KEY_PAGE_ORDERLIST)) {
                page = JSON_KEY_PAGE_ORDERLIST;
            } else if (object.has(JSON_KEY_PAGE_INVOICE)) {
                JSONObject invoice = new JSONObject(object.getString(JSON_KEY_PAGE_INVOICE));
                String invoicePage = invoice.optString(JSON_KEY_PAGE_INVOICE_PAGE, "menu");
                map.put(JSON_KEY_PAGE_INVOICE_PAGE, invoicePage);
                page = JSON_KEY_PAGE_INVOICE;
            }

            DIOpenSDK.openPage(mContext, page, map, new DIOpenSDK.DDCallBack() {
                @Override
                public void onFinish(Map<String, String> result) {
                    onJSONResultCallback(function_openPage, result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callPhone(String[] params) {
        try {
            JSONObject object = new JSONObject(params[0]);
            String phone = object.optString(JSON_KEY_PHONE);
            DIOpenSDK.callPhone(mContext, phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean clean() {
         return false;
    }

    private void onJSONResultCallback(String callback, Map<String, String> result) {
        try {
            JSONObject object = new JSONObject();
            Iterator<String> iterator = result.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                object.put(key, result.get(key));
            }
            jsCallback(callback, 0, EUExCallback.F_C_TEXT, object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}