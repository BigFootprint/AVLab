package com.footprint.avlab.teclab.surfaceviewzoom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {
    private SurfaceHolder holder;
    public boolean isRun;

    public DrawThread(SurfaceHolder holder) {
        this.holder = holder;
        isRun = true;
    }

    @Override
    public void run() {
        int count = 0;
        while (isRun) {
            Canvas c = null;
            try {
                synchronized (holder) {
                    c = holder.lockCanvas();//锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作了。
                    c.drawColor(Color.BLACK);//设置画布背景颜色
                    Paint p = new Paint(); //创建画笔
                    p.setColor(Color.WHITE);
                    Rect r = new Rect(100, 50, 300, 250);
                    c.drawRect(r, p);
                    c.drawText("这是第" + (count++) + "秒", 100, 310, p);

                    r = new Rect(200, 500, 400, 700);
                    c.drawRect(r, p);

                    Thread.sleep(1000);//睡眠时间为1秒
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                if (c != null) {
                    holder.unlockCanvasAndPost(c);//结束锁定画图，并提交改变。
                }
            }
        }
    }
}