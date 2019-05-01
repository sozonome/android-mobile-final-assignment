package id.ac.umn.keburusarjanainc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.umn.keburusarjanainc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private TextView textView;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        textView = view.findViewById(R.id.text_display);
        textView.setText(getArguments().getString("message"));



        return view;
    }

}
