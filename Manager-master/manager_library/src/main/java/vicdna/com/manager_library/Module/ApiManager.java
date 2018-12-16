package vicdna.com.manager_library.Module;

import android.graphics.Bitmap;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONObject;

import java.io.File;

import vicdna.com.manager_library.Interface.ApiBitmapCallBack;
import vicdna.com.manager_library.Interface.ApiCallBack;
import vicdna.com.manager_library.Interface.ApiFileCallBack;


/**
 * Created by lewis on 2017/12/15.
 */

public class ApiManager {

    private static ApiManager ins = null;
    private final String TAG = this.getClass().getSimpleName();
    private final int METHOD_POST = 0;
    private final int METHOD_GET = 1;

    public static synchronized ApiManager getIns() {
        if (ins == null) ins = new ApiManager();
        return ins;
    }

    /**
     * connectAPI
     *
     * @param requestMethod
     * @param apiUrl
     * @param httpParams
     * @param apiCallBack
     */
    public void connectAPI(int requestMethod, String apiUrl, HttpParams httpParams, final ApiCallBack apiCallBack, final String apiName) {

        if (requestMethod == METHOD_POST) {
            OkGo.<String>post(apiUrl)
                    .tag(this)
                    .params(httpParams)
                    .execute(new StringCallback() {
                        @Override
                        public String convertResponse(okhttp3.Response response) throws Throwable {
                            return super.convertResponse(response);
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            apiCallBack.onApiStringCallBack(response.code(), "", apiName);
                        }

                        @Override
                        public void onFinish() {
                            super.onFinish();
                        }

                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            super.onStart(request);
                        }

                        @Override
                        public void onSuccess(Response<String> response) {
                            apiCallBack.onApiStringCallBack(response.code(), response.body().toString(), apiName);
                        }
                    });
        } else if (requestMethod == METHOD_GET) {
            OkGo.<String>get(apiUrl)
                    .tag(this)
                    .execute(new StringCallback() {
                        @Override
                        public String convertResponse(okhttp3.Response response) throws Throwable {
                            return super.convertResponse(response);
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            apiCallBack.onApiStringCallBack(response.code(), "", apiName);
                        }

                        @Override
                        public void onFinish() {
                            super.onFinish();
                        }

                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            super.onStart(request);
                        }

                        @Override
                        public void onSuccess(Response<String> response) {
                            apiCallBack.onApiStringCallBack(response.code(), response.body().toString(), apiName);
                        }
                    });
        }

    }

    /**
     * @param apiUrl
     * @param apiBitmapCallBack
     */
    public void connectGetBitmap(String apiUrl, final ApiBitmapCallBack apiBitmapCallBack) {

        OkGo.<Bitmap>post(apiUrl)
                .tag(this)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Response<Bitmap> response) {
                        super.onError(response);
                        apiBitmapCallBack.onApiBitmapCallBack(response.code(), null);
                    }

                    @Override
                    public void onSuccess(Response<Bitmap> response) {
                        apiBitmapCallBack.onApiBitmapCallBack(response.code(), response.body());
                    }
                });
    }

    /**
     * connectGetFileAPI
     *
     * @param url
     * @param filePath
     * @param fileName
     * @param apiFileCallBack
     */
    public void connectGetFileAPI(String url, String filePath, String fileName, final ApiFileCallBack apiFileCallBack) {

        OkGo.<File>post(url)
                .tag(this)
                .execute(new FileCallback(filePath, fileName) {
                    @Override
                    public File convertResponse(okhttp3.Response response) throws Throwable {
                        return super.convertResponse(response);
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        super.downloadProgress(progress);
                    }

                    @Override
                    public void onError(Response<File> response) {
                        super.onError(response);
                        apiFileCallBack.onApiFileCallBack(response.code(), null);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }

                    @Override
                    public void onStart(Request<File, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(final Response<File> response) {
                        apiFileCallBack.onApiFileCallBack(response.code(), response.body());
                    }
                });
    }

    /**
     * connectUpLoadJsonAPI
     *
     * @param url
     * @param jsonObject
     * @param apiCallBack
     */
    public void connectUpLoadJsonAPI(String url, JSONObject jsonObject, final ApiCallBack apiCallBack, final String apiName) {

        OkGo.<String>post(url)
                .tag(this)
                .upJson(jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        apiCallBack.onApiStringCallBack(response.code(), "", apiName);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        apiCallBack.onApiStringCallBack(response.code(), response.body(), apiName);
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);
                    }
                });
    }

    /**
     * connectUpLoadStringAPI
     *
     * @param url
     * @param upJsonString
     */
    public void connectUpLoadStringAPI(String url, String upJsonString, final ApiCallBack apiCallBack, final String apiName) {

        OkGo.<String>post(url)
                .tag(this)
                .upString(upJsonString)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        apiCallBack.onApiStringCallBack(response.code(), "", apiName);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        apiCallBack.onApiStringCallBack(response.code(), response.body(), apiName);
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);
                    }
                });
    }
}
