package thanhahvan.mydownloadzip.fragments.fragment1;


import java.io.File;

import rx.Observable;

/**
 * Created by HaVan on 5/5/2017.
 */
public class Fragment1Interface {


    interface PresenterOps {


        void getDownloadZipFile(Observable<File> fileObservable);
    }

    interface ViewOps {


        void Waiting();
        void GetError(String error);

        void showFile(File file);
    }

}
