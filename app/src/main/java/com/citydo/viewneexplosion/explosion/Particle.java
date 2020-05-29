package com.citydo.viewneexplosion.explosion;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @Author: liusihui
 * @CreateDate: 2020-05-15 17:04
 * 粒子
 */
public abstract class Particle {

    // 属性
    protected float cx;
    protected float cy;
    protected int color;

    public Particle(float x, float y, int color) {
        cx = x;
        cy = y;
        this.color = color;
    }

    // 计算 运动规则
    protected abstract void calculate(float factor);

    // 绘制 粒子类型（样式）
    protected abstract void draw(Canvas canvas, Paint paint);

    // 逐帧绘制
    public void advance(Canvas canvas, Paint paint, float factor) {
        calculate(factor);
        draw(canvas, paint);
    }
}
