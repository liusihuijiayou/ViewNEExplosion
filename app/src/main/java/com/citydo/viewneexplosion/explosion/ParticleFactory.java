package com.citydo.viewneexplosion.explosion;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * @Author: liusihui
 * @CreateDate: 2020-05-15 17:14
 * 粒子管理类
 */
public abstract class ParticleFactory {
    
    public abstract Particle[][] generateParticles(Bitmap bitmap, Rect bound);
}
