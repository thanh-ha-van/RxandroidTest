package thanhahvan.mydownloadzip.fragments.fragment1;

import java.io.File;

import rx.Observable;

/**
 * Created by HaVan on 5/5/2017.
 */
public class Fragment1Presenter implements Fragment1Interface.PresenterOps {

    Fragment1Model model;
    Fragment1Interface.ViewOps mView;
    Observable<File> fileObservable;

    public Fragment1Presenter(Fragment1Interface.ViewOps mView) {

        this.mView = mView;
        model = new Fragment1Model(this);
    }

    public void downloadZip() {

        fileObservable = model.getData("http://itp.magik.vn/JSON%20files.zip");
        getDownloadZipFile(fileObservable);

    }

    @Override
    public void getDownloadZipFile(final Observable<File> fileObservable) {

        mView.Waiting();

        fileObservable.subscribe(File ->
                {
                    mView.showFile(File);
                },
                (Throwable error) ->
                {
                    mView.GetError(error.toString());
                }

        );
    }
}
