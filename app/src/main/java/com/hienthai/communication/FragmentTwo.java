package com.hienthai.communication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private FragmentTwoListener fragmentTwoListener;

    EditText edtFrmTwo;
    Button btnFrmTwo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);
        edtFrmTwo = view.findViewById(R.id.edtFrmTwo);
        btnFrmTwo = view.findViewById(R.id.btnFrmTwo);

        btnFrmTwo.setOnClickListener(v -> {
            CharSequence input = edtFrmTwo.getText();
            fragmentTwoListener.onInputFrmTwoSent(input);
        });

        return view;
    }

    public void updateEditText(CharSequence newText) {
        edtFrmTwo.setText(newText);
    }

    public interface FragmentTwoListener {
        void onInputFrmTwoSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentTwoListener) {
            fragmentTwoListener = (FragmentTwoListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentTwoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        fragmentTwoListener = null;
    }
}
