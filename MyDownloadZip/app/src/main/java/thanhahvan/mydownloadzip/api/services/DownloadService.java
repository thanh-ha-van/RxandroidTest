package thanhahvan.mydownloadzip.api.services;


import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by HaVan on 5/10/2017.
 */
public class DownloadService {

    public DownloadService() {

        }

    public Observable<File> downloadFromLink(String url) {
        Observable<File> ob =  Observable.create(new Observable.OnSubscribe<File>() {
            @Override
            public void call(Subscriber<? super File> subscriber) {
                try {

                    File file = writeToFile(url);
                    subscriber.onNext(file);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }

            }
        });
        ob.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        return ob;

    }

    public  File writeToFile (String url) {
        int count;

        try {

            URL link = new URL(url);
            URLConnection conexion = link.openConnection();
            conexion.connect();

            int lenghtOfFile = conexion.getContentLength();
            Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

            InputStream input = new BufferedInputStream(link.openStream());
            OutputStream output = new FileOutputStream("/sdcard/the_downloaded.zip");

            byte data[] = new byte[1024];

            while ((count = input.read(data)) != -1) {

                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
        }
        return null;
    }
}
