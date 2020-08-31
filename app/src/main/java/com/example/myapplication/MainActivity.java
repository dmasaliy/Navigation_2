package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1ClickListener,
        Fragment2.Fragment2ClickListener, Fragment0.Fragment0ClickListener {

    NavController navController;
    public static final String BUNDLE_STRING = "string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.inflateMenu(R.menu.main_menu);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavigationUI.onNavDestinationSelected(item, navController);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragment1NextClick() {
//        Bundle bundle = new Bundle();
//        bundle.putString(BUNDLE_STRING, "Hello from fragment1");
//        bundle.putInt(getResources().getString(R.string.argument_one), 123);
//        Fragment1Directions.ActionFragment1ToFragment2 action = Fragment1Directions.actionFragment1ToFragment2();
//        action.setStringArgumentOne(999);
        navController.navigate(R.id.action_fragment1_to_fragment2);
    }

    @Override
    public void onFragment1BackClick() {
        navController.popBackStack();
    }

    @Override
    public void onFragment2NextClick() {

        Bundle bundle = new Bundle();
        bundle.putString("url","instagram");
        bundle.putString("sufix","com");
        navController.navigate(R.id.secondActivity, bundle);
    }

    @Override
    public void onFragment2BackClick() {
        navController.popBackStack();
    }

    @Override
    public void onFragment0NextClick() {
        navController.navigate(R.id.fragment1);
    }

    @Override
    public void onFragment0BackClick() {
        this.finish();
    }
}