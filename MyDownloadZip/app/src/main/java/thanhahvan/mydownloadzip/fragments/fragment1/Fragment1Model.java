package thanhahvan.mydownloadzip.fragments.fragment1;

import java.io.File;

import rx.Observable;
import thanhahvan.mydownloadzip.api.services.DownloadService;

public class Fragment1Model {


    public   Fragment1Presenter fragment1Presenter;

    private DownloadService downloadService = new DownloadService();

    public Fragment1Model(Fragment1Presenter fragment1Presenter) {
        this.fragment1Presenter = fragment1Presenter;
    }

    public Observable<File> getData (String link) {

        return downloadService.downloadFromLink(link);
    }
}

