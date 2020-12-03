package com.xela.browser;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    Button open_book1,open_book2,open_book3,open_book4,open_book5;
    MainActivity main;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        open_book1 = view.findViewById(R.id.bookmark_btn_1);
        open_book2 = view.findViewById(R.id.bookmark_btn_2);
        open_book3 = view.findViewById(R.id.bookmark_btn_3);
        open_book4 = view.findViewById(R.id.bookmark_btn_4);
        open_book5 = view.findViewById(R.id.bookmark_btn_5);

        main = ((MainActivity)getActivity());

        homepage();

        return view;
    }


    public void homepage(){
        open_book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.progressBar.setVisibility(View.VISIBLE);
                main.webView.setVisibility(View.VISIBLE);
                main.refresh_gst.setVisibility(View.VISIBLE);
                main.fragmentui.setVisibility(View.GONE);
                try {
                    if(!NetworkState.connectionAvailable(getContext().getApplicationContext())){
                        Toast.makeText(getContext().getApplicationContext(), "connect", Toast.LENGTH_SHORT).show();
                    }else {
                        InputMethodManager inputMethodManager = (InputMethodManager) main.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(main.editText.getWindowToken(), 0);
                        main.webView.loadUrl("https://" + open_book1.getText().toString());
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        open_book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.progressBar.setVisibility(View.VISIBLE);
                main.webView.setVisibility(View.VISIBLE);
                main.refresh_gst.setVisibility(View.VISIBLE);
                main.fragmentui.setVisibility(View.GONE);
                try {
                    if(!NetworkState.connectionAvailable(getContext().getApplicationContext())){
                        Toast.makeText(getContext().getApplicationContext(), "connect", Toast.LENGTH_SHORT).show();
                    }else {
                        InputMethodManager inputMethodManager = (InputMethodManager) main.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(main.editText.getWindowToken(), 0);
                        main.webView.loadUrl("https://" + open_book2.getText().toString());
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        open_book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.progressBar.setVisibility(View.VISIBLE);
                main.webView.setVisibility(View.VISIBLE);
                main.refresh_gst.setVisibility(View.VISIBLE);
                main.fragmentui.setVisibility(View.GONE);
                try {
                    if(!NetworkState.connectionAvailable(getContext().getApplicationContext())){
                        Toast.makeText(getContext().getApplicationContext(), "connect", Toast.LENGTH_SHORT).show();
                    }else {
                        InputMethodManager inputMethodManager = (InputMethodManager) main.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(main.editText.getWindowToken(), 0);
                        main.webView.loadUrl("https://" + open_book3.getText().toString());
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        open_book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.progressBar.setVisibility(View.VISIBLE);
                main.webView.setVisibility(View.VISIBLE);
                main.refresh_gst.setVisibility(View.VISIBLE);
                main.fragmentui.setVisibility(View.GONE);
                try {
                    if(!NetworkState.connectionAvailable(getContext().getApplicationContext())){
                        Toast.makeText(getContext().getApplicationContext(), "connect", Toast.LENGTH_SHORT).show();
                    }else {
                        InputMethodManager inputMethodManager = (InputMethodManager) main.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(main.editText.getWindowToken(), 0);
                        main.webView.loadUrl("https://" + open_book4.getText().toString());
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        open_book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.progressBar.setVisibility(View.VISIBLE);
                main.webView.setVisibility(View.VISIBLE);
                main.refresh_gst.setVisibility(View.VISIBLE);
                main.fragmentui.setVisibility(View.GONE);
                try {
                    if(!NetworkState.connectionAvailable(getContext().getApplicationContext())){
                        Toast.makeText(getContext().getApplicationContext(), "connect", Toast.LENGTH_SHORT).show();
                    }else {
                        InputMethodManager inputMethodManager = (InputMethodManager) main.getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(main.editText.getWindowToken(), 0);
                        main.webView.loadUrl("https://" + open_book5.getText().toString());
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
