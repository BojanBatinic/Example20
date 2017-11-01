package com.example.androiddevelopment.glumcilegende.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androiddevelopment.glumcilegende.R;
import com.example.androiddevelopment.glumcilegende.model.Film;
import com.example.androiddevelopment.glumcilegende.model.Glumac;
import com.example.androiddevelopment.glumcilegende.providers.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by BBLOJB on 30.10.2017..
 */

public class DetailFragment extends Fragment {

    private static int NOTIFICATION_ID = 1;

    private int position = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        //fotografija glumca
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ime i prezime glumca
        TextView tvImePrezime = (TextView) getView().findViewById(R.id.tv_imePrezime);
        tvImePrezime.setText(GlumacProvider.getGlumacById(position).getImePrezime());

        // kratka biografija o glumcu
        TextView tvBiografija = (TextView) getView().findViewById(R.id.tv_biografija);
        tvBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());

        // datum roidjenja
        TextView tvDatumRodjenja = (TextView) getView().findViewById(R.id.tv_datumRodjenja);
        tvDatumRodjenja.setText(GlumacProvider.getGlumacById(position).getDatumRodjenja());

        // datum smrti
        TextView tvDatumSmrti = (TextView) getView().findViewById(R.id.tv_datumSmrti);
        tvDatumSmrti.setText(GlumacProvider.getGlumacById(position).getDatumSmrti());

        // lista filmova
        List<Film> films = (GlumacProvider.getGlumacById(position).getFilmovi());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter(getActivity(), R.layout.mylist, films);
        ListView listView = (ListView) getView().findViewById(R.id.lista_filmova_glumac);
        listView.setAdapter(itemsAdapter);

        // Finds "btnBuy" Button and sets "onClickListener" listener
       FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }
    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);

        //fotografija glumca
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ime i prezime glumca
        TextView tvImePrezime = (TextView) getView().findViewById(R.id.tv_imePrezime);
        tvImePrezime.setText(GlumacProvider.getGlumacById(position).getImePrezime());

        // kratka biografija o glumcu
        TextView tvBiografija = (TextView) getView().findViewById(R.id.tv_biografija);
        tvBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());

        // datum rodjenja
        TextView tvDatumRodjenja = (TextView) getView().findViewById(R.id.tv_datumRodjenja);
        tvDatumRodjenja.setText(GlumacProvider.getGlumacById(position).getDatumRodjenja());

        // datum smrti
        TextView tvDatumSmrti = (TextView) getView().findViewById(R.id.tv_datumSmrti);
        tvDatumSmrti.setText(GlumacProvider.getGlumacById(position).getDatumSmrti());

        // lista filmova
        List<Film> films = (GlumacProvider.getGlumacById(position).getFilmovi());
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter(getActivity(), R.layout.mylist, films);
        ListView listView = (ListView) getView().findViewById(R.id.lista_filmova_glumac);
        listView.setAdapter(itemsAdapter);

       // Finds "btnBuy" Button and sets "onClickListener" listener
        FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }
    private void showNotification() {
        // Creates notification with the notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_stat_buy);
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        builder.setContentTitle(getActivity().getString(R.string.notification_title));
        builder.setContentText(getActivity().getString(R.string.notification_text));
        builder.setLargeIcon(bitmap);

        // Shows notification with the notification manager (notification ID is used to update the notification later on)
        NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());
    }
}
