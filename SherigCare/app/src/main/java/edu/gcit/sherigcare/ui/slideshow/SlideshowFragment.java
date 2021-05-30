package edu.gcit.sherigcare.ui.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import edu.gcit.sherigcare.R;
import edu.gcit.sherigcare.TeacherRegister;
import edu.gcit.sherigcare.registerUser;
import edu.gcit.sherigcare.ui.gallery.DeleteUser;

public class SlideshowFragment extends Fragment {
    private SlideshowViewModel slideshowViewModel;
    Activity context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        TextView rTUser = (TextView) context.findViewById(R.id.Treg);
        rTUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TeacherRegister.class);
                startActivity(intent);
            }
        });

        TextView dTUser = (TextView) context.findViewById(R.id.Tdel);
        dTUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeleteUser.class);
                startActivity(intent);
            }
        });
    }
}