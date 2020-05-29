package com.citydo.viewneexplosion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.citydo.viewneexplosion.explosion.ExplodeParticleFactory;
import com.citydo.viewneexplosion.explosion.ExplosionFiled;
import com.citydo.viewneexplosion.explosion.FallingParticleFactory;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExplosionFiled explosionFiled=new ExplosionFiled(this,new FallingParticleFactory());
        explosionFiled.addListener(findViewById(R.id.text));
        explosionFiled.addListener(findViewById(R.id.iv_one));
        
         explosionFiled=new ExplosionFiled(this,new ExplodeParticleFactory());

        explosionFiled.addListener(findViewById(R.id.iv_two));

    }
}
