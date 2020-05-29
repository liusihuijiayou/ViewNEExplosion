package com.citydo.viewneexplosion.explosion;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * @Author: liusihui
 * @CreateDate: 2020-05-15 17:50
 * 粒子控制器（控制动画的进度）
 */
public class ExplosionAnimator extends ValueAnimator{
    public static int default_duration=1500;
    private ParticleFactory mParticleFactory;  //粒子工厂
    private Particle[][] mParticles; //粒子
    private View mContainer;//field 场地
    private Paint mPaint; //画笔 控制动画的改变


    public ExplosionAnimator(View container, Bitmap bitmap, Rect bound,ParticleFactory particleFactory) {
        mParticleFactory = particleFactory;
        mContainer = container;

        mPaint=new Paint();
        setFloatValues(0.0f, 1.0f);
        setDuration(default_duration);
        mParticles=mParticleFactory.generateParticles(bitmap,bound);

    }

    //绘制

    public void draw(Canvas canvas){

        if (!isStarted()){
            //动画未开始
            return;
        }
        //所有粒子开始运动
        for (Particle[] particles : mParticles) {
            for (Particle particle : particles) {
                particle.advance(canvas,mPaint, (Float) getAnimatedValue());
            }
        }
        mContainer.invalidate(); //整个动画可以动起来了

    }

    @Override
    public void start() {
        super.start();
        mContainer.invalidate();
    }
}
