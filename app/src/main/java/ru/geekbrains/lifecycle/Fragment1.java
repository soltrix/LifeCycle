package ru.geekbrains.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    private static final String TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getActivity(), instanceState + "Fragment.onCreate()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, instanceState + "Fragment.onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Fragment.onCreateView()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onCreateView");
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Toast.makeText(getActivity(), "Fragment.onAttach()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onAttach");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "Fragment.onActivityCreated()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "Fragment.onStart()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "Fragment.onResume()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "Fragment.onPause()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "Fragment.onStop()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "Fragment.onDestroyView()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "Fragment.onDestroy()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
        Toast.makeText(getActivity(), "Fragment.onDetach()",
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "Fragment.onDetach");
    }
}
