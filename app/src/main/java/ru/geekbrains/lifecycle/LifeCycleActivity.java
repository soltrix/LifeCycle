package ru.geekbrains.lifecycle;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    //private int counter = 0;                    // Счетчик
    private static final String TAG = "myLogs";
    //private TextView textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        // создадим фрагмент
        fragment1 = new Fragment1();

        //обработка кнопок
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new ListenerOnAdd(fragment1));

        Button remove = findViewById(R.id.remove);
        remove.setOnClickListener(new ListenerOnRemove(fragment1));

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - Activity.onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                instanceState + " - Activity.onCreate()");

        final TextView textCounter = findViewById(R.id.textCounter);                                 // Текст

        final LifeCyclePresenter presenter = LifeCyclePresenter.getInstance();        // Получить презентер


        textCounter.setText(((Integer)presenter.getCounter()).toString());

        Button button = findViewById(R.id.button);     // Кнопка
        button.setOnClickListener(new View.OnClickListener() {  // Обработка нажатий
            @Override
            public void onClick(View v) {
                presenter.incrementCounter();                   // Увеличиваем счетчик на единицу
                textCounter.setText(((Integer)presenter.getCounter()).toString());  // Выводим счетчик в поле
            }
        });
    }

    private class ListenerOnAdd implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnAdd(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            addFragment();
        }

        // Добавить фрагмент
        private void addFragment() {
            // открыть транзакцию
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            // добавить фрагмент
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack("");
            // закрыть транзакцию
            fragmentTransaction.commit();
        }
    }

    private class ListenerOnRemove implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnRemove(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            removeFragment();
        }

        // удалить фрагмент
        private void removeFragment() {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);

        //saveInstanceState.putInt("Counter", counter);               // Сохраняем счетчик
        Toast.makeText(getApplicationContext(), "Activity.onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        //counter = saveInstanceState.getInt("Counter");              // Восстанавливаем счетчик
        //textCounter.setText(((Integer)counter).toString());         // Выводим счетчик в поле
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - Activity.onRestoreInstanceState()",
                Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Повторный запуск!! - Activity.onRestoreInstanceState()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Activity.onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Activity.onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Activity.onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Activity.onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Activity.onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Activity.onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,
                "Activity.onDestroy()");
    }
}
