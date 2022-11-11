package com.example.web_crawler_app.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.web_crawler_app.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    ArrayList<String[]> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        list.add(new String[]{"Heading 1", "URL"});
        list.add(new String[]{"Heading 2", "URL"});
        list.add(new String[]{"Heading 3", "URL"});
        list.add(new String[]{"Heading 4", "URL"});
        list.add(new String[]{"Heading 5", "URL"});

        binding = FragmentGalleryBinding.inflate(inflater, container, false);

        URLAdapter adapter = new URLAdapter(list, getContext());
        binding.charRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        binding.charRecyclerView.setLayoutManager(layoutManager);

        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}