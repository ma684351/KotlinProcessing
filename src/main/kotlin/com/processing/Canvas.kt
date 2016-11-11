package com.processing

import processing.core.*

/**
 * Created by ma684351 on 2016/11/11.
 */
class Canvas : PApplet() {
    var increment :Float = 0.01f
    var zoff :Float = 0.0f
    var zincrement :Float = 0.02f

    override fun settings() {
        size(640, 360)
    }

    override fun setup() {
        frameRate(30f)
    }

    override fun draw() {
        loadPixels()

        var xoff :Float = 0.0f

        for(x in 0..width -1){
            xoff += increment
            var yoff :Float = 0.0f

            for(y in 0..height - 1){
                yoff += increment

                var bright :Float = (noise(xoff,yoff,zoff)*255.0f)

                pixels[y*width + x]  = color(bright,bright,bright)
            }
        }

        updatePixels()

        zoff += zincrement
    }

    fun run(args: Array<String>) = PApplet.main("com.processing.Canvas")
}