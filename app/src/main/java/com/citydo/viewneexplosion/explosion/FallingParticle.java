package com.citydo.viewneexplosion.explosion;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @Author: liusihui
 * @CreateDate: 2020-05-29 09:46
 */
public class FallingParticle extends Particle{

    //自由掉落
    float radius=FallingParticleFactory.PART_WH/2;
    float alpha=1.0f;
    Rect mBound; //控件区域 (获取改变的值)


    public FallingParticle( int color, float x, float y, Rect bound) {
        super(x, y, color);
        mBound = bound;
    }

    //factor动画的百分比
    @Override
    protected void calculate(float factor) {
        //位置的改变
        cx=cx+factor*Utils.RANDOM.nextInt(mBound.width())*(Utils.RANDOM.nextFloat()-0.5f);
        cy=cy+factor*Utils.RANDOM.nextInt(mBound.height()/2);

        radius=radius-factor*Utils.RANDOM.nextInt(2);
        alpha=(1f-factor)*(1+Utils.RANDOM.nextFloat());

    }

    @Override
    protected void draw(Canvas canvas, Paint paint) {

        paint.setColor(color);
        paint.setAlpha((int)(Color.alpha(color)*alpha));
        canvas.drawCircle(cx,cy,radius,paint);

    }
}
