package com.example.claudio_pc.alarm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Claudio_pc on 09/05/2016.
 */
public class CameraDraw extends View {
    private Bitmap cameraLine;
    private float changingY;
    public CameraDraw(Context context) {
        super(context);
        cameraLine = BitmapFactory.decodeResource(getResources(), R.id.cameraLayout);
        changingY = 0;
    }

    protected void onDraw(Canvas canvas) {

        //canvas.drawRGB(255, 255, 255);
        //int ancho = canvas.getWidth();
        //int alto = canvas.getHeight();
        //Paint pincel1 = new Paint();
        //pincel1.setARGB(255, 255, 0, 0);
        //pincel1.setStyle(Paint.Style.STROKE);
        //canvas.drawCircle(ancho / 2, alto / 2,  15, pincel1);

        canvas.drawColor(Color.RED);
        canvas.drawBitmap(cameraLine, (canvas.getWidth()/2), changingY, null);
        if(changingY < canvas.getHeight())
            changingY += 10;
        else
            changingY = 0;

        invalidate();
    }
}
