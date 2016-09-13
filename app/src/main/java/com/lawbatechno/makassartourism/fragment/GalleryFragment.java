package com.lawbatechno.makassartourism.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lawbatechno.makassartourism.R;
import com.lawbatechno.makassartourism.adapter.GalleryAdapter;
import com.lawbatechno.makassartourism.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    private ArrayList<Image> images ;
    private ProgressDialog pDialog ;
    private GalleryAdapter adapter ;
    private RecyclerView recyclerView ;


    /*
    private int img [] = {
            R.drawable.air_terjun_parangloe,
            R.drawable.balla_lompoa,
            R.drawable.bantimurung,
            R.drawable.benteng_sombaopu,
            R.drawable.bugis_waterpark,
            R.drawable.fort_rotterdam,
            R.drawable.museum_kota,
            R.drawable.pantai_losari
    }; */

    private String imgUrl [] = {
            "http://2.bp.blogspot.com/-w1Iu5mEu9Ew/U7JPv8sKmGI/AAAAAAAAIzE/xlNCw3xSpwk/s1600/_MG_2572.JPG",
            "https://i.ytimg.com/vi/AHwSuq-67NY/maxresdefault.jpg",
            "http://harmonimedia.com/wp-content/uploads/2015/11/gbr91.jpg",
            "http://i0.wp.com/daenggassing.com/wp-content/uploads/2013/11/09c28c44b2ac8433e4494e3fb285be45.jpg",
            "http://res.cloudinary.com/dt5pdf3pn/image/upload/v1452011771/Makassartourism_gallery/makassartourism_gallery03.jpg",
            "http://panduanwisata.id/files/2013/02/Fort_Rotterdam_Makassar1.jpg",
            "https://cdns.klimg.com/newshub.id/photonews/2016/05/27/62472/foto-menengok-koleksi-museum-kota-makassar-160527a-001.jpg",
            "https://travels101.com/blog/wp-content/uploads/2015/12/fc7ff-anjungan-pantai-losari.jpg"

    };


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        pDialog = new ProgressDialog(getContext().getApplicationContext());
        images = new ArrayList<>();
        adapter = new GalleryAdapter(getContext().getApplicationContext(), images);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext().getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        fetchImages();


        return rootView ;
    }

    private void fetchImages() {
        for (int i = 0 ; i < imgUrl.length; i++) {
            Image image =  new Image();
            image.setImage(imgUrl[i]);
            images.add(image);
        }

        adapter.notifyDataSetChanged();
    }


}
