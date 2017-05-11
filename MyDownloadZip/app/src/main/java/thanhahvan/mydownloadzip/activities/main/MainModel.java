package thanhahvan.mydownloadzip.activities.main;


import com.esafirm.rxdownloader.RxDownloader;

import java.io.File;

import rx.Observer;
import thanhahvan.mydownloadzip.api.services.DownloadService;

/**
 * Created by HaVan on 5/3/2017.
 */
public class MainModel {

    MainInterface.Presenter presenter;
    File file;
    DownloadService downloadService;

    public MainModel(MainInterface.Presenter presenter) {

        this.presenter = presenter;
        this.downloadService = new DownloadService();

    }

}
