package com.example.rubs.renderscriptdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class Bluer {
    private static final float SCALE = 0.5f;
    private static final float BLUR_RADIUS = 10f;

    public static Bitmap blur(Context context, Bitmap image){
        int height = Math.round(image.getHeight() * SCALE);
        int width = Math.round(image.getWidth() * SCALE);
        Bitmap inputBitmap = Bitmap.createScaledBitmap(image,width,height,false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);
        RenderScript renderScript = RenderScript.create(context);
        ScriptIntrinsicBlur intrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        Allocation tmIn = Allocation.createFromBitmap(renderScript, inputBitmap);
        Allocation tmOut = Allocation.createFromBitmap(renderScript, outputBitmap);
        intrinsicBlur.setRadius(BLUR_RADIUS);
        intrinsicBlur.setInput(tmIn);
        intrinsicBlur.forEach(tmOut);
        tmOut.copyTo(outputBitmap);
        return outputBitmap;
    }
}
