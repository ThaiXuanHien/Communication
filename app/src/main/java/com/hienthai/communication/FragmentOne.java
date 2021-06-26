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

public class FragmentOne extends Fragment {

    private FragmentOneListener fragmentOneListener;

    EditText edtFrmOne;
    Button btnFrmOne;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        edtFrmOne = view.findViewById(R.id.edtFrmOne);
        btnFrmOne = view.findViewById(R.id.btnFrmOne);

        btnFrmOne.setOnClickListener(v -> {
            CharSequence input = edtFrmOne.getText();
            fragmentOneListener.onInputFrmOneSent(input);
        });

        return view;
    }

    public void updateEditText(CharSequence newText) {
        edtFrmOne.setText(newText);
    }

    public interface FragmentOneListener {
        void onInputFrmOneSent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentOneListener) {
            fragmentOneListener = (FragmentOneListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentOneListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        fragmentOneListener = null;
    }
}
