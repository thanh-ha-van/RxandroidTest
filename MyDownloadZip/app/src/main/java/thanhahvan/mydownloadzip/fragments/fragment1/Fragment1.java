package thanhahvan.mydownloadzip.fragments.fragment1;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;


import android.support.v4.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.io.File;


import thanhahvan.mydownloadzip.R;


public class Fragment1 extends Fragment implements Fragment1Interface.ViewOps {


    private Button button;
    private ProgressDialog mProgressDialog;

    private Fragment1Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        button = (Button) view.findViewById(R.id.btn_download);

        presenter = new Fragment1Presenter(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.downloadZip();
            }
        });

        return view;
    }


    @Override
    public void Waiting() {


        showMyDialog();

    }

    @Override
    public void GetError(String error) {

        // show error

    }

    @Override
    public void showFile(File file) {

        // do stuffs

        dismissMyDialog();

    }

    public void showMyDialog() {

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage("Dowloading...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

    }

    public void dismissMyDialog() {
        mProgressDialog.dismiss();

    }
}

