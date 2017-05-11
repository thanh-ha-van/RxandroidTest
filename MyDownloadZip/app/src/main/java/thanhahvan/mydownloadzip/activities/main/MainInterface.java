package thanhahvan.mydownloadzip.activities.main;

import java.io.File;

/**
 * Created by HaVan on 5/3/2017.
 */
public interface MainInterface {

    interface View {

        void showImages();
        void showDialog();
        void dismissDialog();
        void showError(String error);
    }

    interface Presenter {

        void getDownloadData(File file);
    }
}
